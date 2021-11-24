/*
Bernice Templeman
CIS 5230Operating Systems - Program 5

sources: 
http://docs.oracle.com/javase/7/docs/api/allclasses-noframe.html
Class JFileChooser -- JFileChooser provides a simple mechanism for the user to choose a file.
source: http://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
How to Use File Choosers:
http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html

Examples:
http://www.uwgb.edu/mielkeb/cs331/Java/filechooser.htm

File Operations - Write a Java program to imitate a certain file system 
and certain utility programs of an operating system.  
	
•	Select a file from a file dialog box, using the class JFileChooser.
•	If the file is readable (text file), then process the file as follow,
otherwise display a message stating that the file is not readable. 

Process the readable file:
•	Buffer chunks of 32 bytes; each row saves id 
(in column 1, succession number starting from 1) and the 32 bytes. 
The buffer size of the last row may be less than 32 byes, in which case pad it with ‘*’.
•	Display the content of the buffer.
•	Save the buffer in a file, where the file name is buffOut.txt 

/*
Bernice Templeman
CIS 5230Operating Systems - Program 5
 */
package os.program5;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

public class OSProgram5 {

    public static void main(String[] args) throws IOException 
    {
        Scanner keyboard = new Scanner(System.in);
        String runTest = "1";       
        do{
        System.out.printf("This program tests the JFileChooser.\n"
                + "Option 1: tests with try/catch and some if/else error checkng\n"
                + "(Any other number or character will exit the application.)\n\n"
                + "Your Choice: 1: ");
        runTest = keyboard.nextLine();

        if(runTest.equals("1"))
        {
                JFileChooserDemo3 application3 = new JFileChooserDemo3();
                application3.setSize(400, 400); 
                application3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                application3.setVisible(true); 
        }
    }while (runTest.equals("1"));
    }//end main
}//end class
