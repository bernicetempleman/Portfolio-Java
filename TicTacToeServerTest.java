/*
Fig 28.12 TicTacToeServerTest.java
class that tests tic-tac-toe server

 */
package ch28.tictactoeservertest;

import javax.swing.JFrame;

public class TicTacToeServerTest 
{

 
    public static void main(String[] args) {
        TicTacToeServer application = new TicTacToeServer();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.execute();
    }
    
}
