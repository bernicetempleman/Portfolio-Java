/*
Bernice Templeman
CIS 5230Operating Systems - Program 2 

File Operations - Write a Java program to imitate a certain file system and certain utility programs of an operating system.  	
•	Select a file from a file dialog box, using the class JFileChooser.
•	List the absolute path of the file
•	Show the size of the selected file.
•	List all the files, directories and subdirectories in the path of the file selected.
 */
package program.pkg2.os;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

public class Program2OS 
{
    public static void main(String[] args) throws IOException 
    {
        Scanner keyboard = new Scanner(System.in);
        String runTest = "1";       
        do{
        System.out.printf("This program tests the JFileChooser.\n"
                + "Option 1: tests with the throws clause \n"
                + "          (Exceptions will cause the program to hang and you will need to manually stop it.)\n"
                + "Option 2: tests with try/catch blocks\n"
                + "Option 3: tests with try/catch and some if/else error checkng\n"
                + "(Any other number or character will exit the application.)\n\n"
                + "Your Choice: 1 2 3: ");
        runTest = keyboard.nextLine();
        if(runTest.equals("1"))
        {
                JFileChooserDemo application = new JFileChooserDemo();
                application.setSize(400, 400); 
                application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                application.setVisible(true);          
        }  
        else if (runTest.equals("2"))
        {
                JFileChooserDemo2 application2 = new JFileChooserDemo2();
                application2.setSize(400, 400); 
                application2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                application2.setVisible(true); 
        }
        else if(runTest.equals("3"))
        {
                JFileChooserDemo3 application3 = new JFileChooserDemo3();
                application3.setSize(400, 400); 
                application3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                application3.setVisible(true); 
        }
    }while (runTest.equals("1")||runTest.equals("2")||runTest.equals("3"));
    }//end main
}//end class