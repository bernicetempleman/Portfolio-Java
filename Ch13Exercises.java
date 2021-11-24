/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch13.exercises;

// Grid.java
// This program draws an 8 x 8 grid
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Bernice
 */
public class Ch13Exercises extends JFrame {


//public class Grid extends JFrame {
 public Ch13Exercises()
 {
  super( "Grid" );
  setSize( 560, 560 );
  show();
 }

public void paint( Graphics g )
 {
 /* 4 * 4
 int y = 50; 
 int x = 50;

 for ( int r = 1; r <= 5; r++, y += 13 ) 
 g.drawLine( 50, y, 100, y );

 for ( int c = 1; c <= 5; c++, x += 13 )
 g.drawLine( x, 50, x, 100 );
 }

     //4x 4
 int y =75; 
 int x = 75;

 for ( int r = 1; r <= 5; r++, y += 75 ) 
    g.drawLine( 75, y, 375, y );

 for ( int c = 1; c <= 5; c++, x += 75 )
    g.drawLine( x, 375, x, 75 );
         
         
     
 //3 x 3
 int y =100; 
 int x = 100;

 for ( int r = 1; r <= 4; r++, y += 100 ) 
    g.drawLine( 100, y, 400, y );

 for ( int c = 1; c <= 4; c++, x += 100 )
    g.drawLine( x, 400, x, 100 );
 
         
     
     /7 * 7
      int y = 30, x1 = 30;

 for ( int r = 1; r <= 8; r++, y += 10 ) 
 g.drawLine( 30, y, 100, y );

 for ( int c = 1; c <= 8; c++, x1 += 10 )
 g.drawLine( x1, 30, x1, 100 );
         */
          //4x 4
 int y = 80; 
 int x = 80;

 for ( int r = 1; r <= 6; r++, y += 80) 
    g.drawLine( 80, y, 480, y );

 for ( int c = 1; c <= 6; c++, x += 80 )
    g.drawLine( x, 480, x, 80 );
     
 }

     
 

public static void main( String args[] )
 {
 Ch13Exercises app = new Ch13Exercises();
 app.addWindowListener(
 new WindowAdapter() 
   {
   public void windowClosing( WindowEvent e )
      {
      System.exit( 0 );
      }
   }
 ); 
 }
}


