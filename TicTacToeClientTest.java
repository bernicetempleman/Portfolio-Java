/*
Fig 28.14: TicTacToeClientTest.java
Test class for Tic-Tac_toe client
 */
package ch28.tictactoeclienttest;

import javax.swing.JFrame;


public class TicTacToeClientTest 
{

    public static void main(String[] args) 
    {
        TicTacToeClient application; // declare client application
        
        //if no command line args
        if(args.length == 0)
        {
            application = new TicTacToeClient("127.0.0.1");
            
        }
        else
            application = new TicTacToeClient(args[0]);
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
