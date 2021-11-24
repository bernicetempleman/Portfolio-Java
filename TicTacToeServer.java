/*
Fig 28.11 TicTacToeServer.java
Server side of client/server Tic-Tac-Toe program

 */
package ch28.tictactoeservertest;

import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class TicTacToeServer extends JFrame
{
    private String[] board = new String[9];
    private JTextArea outputArea;
    private Player[] players;
    private ServerSocket server;
    private int currentPlayer;
    private final static int PLAYER_X =0;
    private final static int PLAYER_O = 1;
    private final static String[] MARKS = { "X", "O"};
    private ExecutorService runGame;
    private Lock gameLock;
    private Condition otherPlayerConnected;
    private Condition otherPlayerTurn;
    
    // set up tic-tac-toe server and GUI that displays messages
    public TicTacToeServer()
    {
        super("Tic-Tac-Toe Server");
        
        // create ExecutorService with a thread for each player
        runGame = Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock(); // create lock for the game
        
        //condition variable for both players being connected
        otherPlayerConnected = gameLock.newCondition();
        
        //condition variable for the other player's turn
        otherPlayerTurn = gameLock.newCondition();
        
        for(int i = 0; i< 9; i++)
        {
            board[i] = new String(""); //create tictactoe board
        }
        players = new Player[2];
        currentPlayer = PLAYER_X;
        
        try
        {
            server = new ServerSocket(12345,2);
            
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
            System.exit(1);
            
        }
        
        outputArea = new JTextArea();
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");
        
       setSize(300,300);
       setVisible(true);
    }
    
    public void execute()
    {
        //wait for each client to connect
        for (int i= 0; i< players.length; i++)
        {
            try
            {
                players[i] = new Player(server.accept(), i);
                runGame.execute(players[i]);
                
            }
            catch(IOException ioException)
            {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
        
        gameLock.lock(); //lock game to signame player X's thread
        
        try
        {
            players[PLAYER_X].setSuspended(false); // resume player x
            otherPlayerConnected.signal(); // wake up player X's thread
        }
        finally
        {
            gameLock.unlock(); //unlock game after signaling player x
        }
    }
    
    // display message in outputArea
    private void displayMessage(final String messageToDisplay)
    {
        // display message from event-dispatch thread of execution
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run() // updates outputArea
                    {
                        outputArea.append(messageToDisplay); //add message
                    }
                }    
        );
    }
    
    // determine if move is valid
    public boolean validateAndMove(int location, int player)
    {
        //while not current player, must wait for turn
        while(player != currentPlayer)
        {
            gameLock.lock(); // lock game to wait for other player to go
            
            try
            {
                otherPlayerTurn.await();
            }
            catch(InterruptedException exception)
            {
                exception.printStackTrace();
            }
            finally
            {
                gameLock.unlock(); // unlock game after waiting
            }
        }
    
    
    // if location not occupied, make move
    if (!isOccupied(location))
    {
        board[location] = MARKS[currentPlayer]; //set move on board
        currentPlayer = (currentPlayer + 1) % 2; //change player
       
        // let new current player know that move occured
        players[currentPlayer].otherPlayerMoved(location);
        
        gameLock.lock(); // lock game to signal other player to go
        
        try
        {
            otherPlayerTurn.signal();
        }
        finally
        {
            gameLock.unlock(); //unlock game after signaling
        }
        
        return true;
    }
    else //move was not valid
        return false; // notify player that move was valid
    
    }
    
    // determine whether location is occupied
      public boolean isOccupied(int location)
      {
         if (board[location].equals(MARKS[PLAYER_X]) ||
            board [location].equals(MARKS[PLAYER_O]))
            return true; // location is occupied
        else
            return false; // location is not occupied
      }
   
      // place code in this method to determine whether game over
      public boolean isGameOver()
      {
        return false; // this is left as an exercise
      }
   
    // private inner class Player manages each Player as a runnable
    private class Player implements Runnable
    {
        private Socket connection;
        private Scanner input;
        private Formatter output;
        private int playerNumber;
        private String mark;
        private boolean suspended = true;
        
        //set up Player thread
        public Player(Socket socket, int number)
        {
            playerNumber = number;
            mark = MARKS[playerNumber];
            connection = socket;
        
        
        try
        {
            input = new Scanner(connection.getInputStream());
            output = new Formatter(connection.getOutputStream());
            
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
            System.exit(1);
        }
    }
    
    //send message that other player moved
    public void otherPlayerMoved(int location)
    {
        output.format("Opponent moved\n");
        output.format("%d\n", location);
        output.flush();
    }
    
    //contorl thread's execution
        @Override
    public void run()
    {
        //send client its mark (X or O), process messages from client
        try
        {
            displayMessage("Player " + mark + " connection\n");
            output.format("%s\n", mark); //send players mark
            output.flush(); //flush output
            
            //if player X wait for another player to arrive
            if(playerNumber == PLAYER_X)
            {
                output.format("%s\n%s", "Player X connected", "Waiting for another player \n");
                output.flush();
                
                gameLock.lock();
                
                try
                {
                    while(suspended)
                    {
                        otherPlayerConnected.await();
                        
                    }
                }
                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
                finally
                {
                    gameLock.unlock();
                }
                
                //send message that other player connected
                output.format("Other player connected. Your move. \n");
                output.flush();
                
            }
            else
            {
                output.format("Player O connected, please wait\n");
                output.flush();
            }
            
            // while game not over
            while (!isGameOver())
            {
                int location = 0;
                
                if (input.hasNext())
                    location = input.nextInt();
                
                if(validateAndMove(location, playerNumber))
                {
                    displayMessage("\nlocation: " + location);
                    output.format("Valid move.\n");
                    output.flush();
                }
                else
                {
                    output.format("Inavalid move, try again\n");
                    output.flush();
                }
            }
                    
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch(IOException ioException)
            {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
    }
    
    //set whether or not thread is suspended
    public void setSuspended(boolean status)
    {
        suspended = status; //set value of suspended
    }
    
    }
}