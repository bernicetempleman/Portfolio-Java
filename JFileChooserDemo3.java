/*
Bernice Templeman
CIS 5230Operating Systems - Program 2 

File Operations - Write a Java program to imitate a certain file system and certain utility programs of an operating system.  	
•	Select a file from a file dialog box, using the class JFileChooser.
•	List the absolute path of the file
•	Show the size of the selected file.
•	List all the files, directories and subdirectories in the path of the file selected.

JFileChooserDemo3.java tests with try/catch blocks + error checking
 */
package program.pkg2.os;

import java.awt.HeadlessException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class JFileChooserDemo3 extends JFrame
{
    private final JTextArea outputArea; // displays file contents
   
    // set up GUI
    public JFileChooserDemo3() 
    {
        super("JFileChooser Demo3");
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea)); // outputArea is scrollable
        analyzePath(); // get Path from user and display info
    }//end gui constructor

    // display information about file or directory user specifies
    public void analyzePath()
    {
        // get Path to user-selected file or directory
        Path path = getFileOrDirectoryPath();
        
        // if exists, display info
        if (path != null && Files.exists(path)) 
        {
            try
            {
                StringBuilder builder = new StringBuilder();
   
                // absolutePath
                builder.append(String.format("Absolute path: %s%n", 
                path.toAbsolutePath()));
         
                // size
                builder.append(String.format("%nSize: %s%n", Files.size(path)));
         
                // list files
                if (Files.isDirectory(path)) // output directory listing
                {
                    builder.append(String.format("%nDirectory contents:%n"));
            
                    // object for iterating through a directory's contents
                    DirectoryStream<Path> directoryStream = 
                        Files.newDirectoryStream(path);
   
                    for (Path p : directoryStream)
                        builder.append(String.format("%s%n", p));
                }
                outputArea.setText(builder.toString()); // display String content
             
            }//end try
            catch( NullPointerException e1)
            {
                System.out.println("Null Pointer");
                JOptionPane.showMessageDialog(this, 
                "File does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            catch( IOException e3)
            {
                System.out.println("IO Exception");
                JOptionPane.showMessageDialog(this, 
                "IO Exception.", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            catch ( SecurityException e4)
            {
                System.out.println("Security Exception");  
                JOptionPane.showMessageDialog(this, 
                "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            catch ( RuntimeException e5)
            {
                System.out.println("RunTime Exception"); 
                JOptionPane.showMessageDialog(this, 
                "Runtime error", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }//end if
        else // Path does not exist
        {
            JOptionPane.showMessageDialog(this,
                "Path does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
    } // end method analyzePath

   // allow user to specify file or directory name
   private Path getFileOrDirectoryPath()
   {
       Path path = null;
       
        try
        {
            // configure dialog allowing selection of a file or directory
            JFileChooser fileChooser = new JFileChooser();
            
            //throws  IllegalArgumentException 
            fileChooser.setFileSelectionMode(
                JFileChooser.FILES_AND_DIRECTORIES);
            
            // throws  HeadlessException 
            int result = fileChooser.showOpenDialog(this);

            // if user clicked Cancel button on dialog, return
            if (result == JFileChooser.CANCEL_OPTION)
                System.exit(1);
            
            // return Path representing the selected file
            // throws InvalidPathException
            path = fileChooser.getSelectedFile().toPath();        
        }
        catch (InvalidPathException e1)
        {
            System.out.println("Invalid Path Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Invaid Path.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( IllegalArgumentException e2)
        {
            System.out.println("Illegal Argument Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Illegal Argument.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( HeadlessException  e3)
        {
            System.out.println("Headless Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Headless Exception.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch (NullPointerException e4)
        {
            System.out.println("NullPointer Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Null Pointer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( SecurityException e5)
        {
            System.out.println("Security Exception");  
            JOptionPane.showMessageDialog(this, 
            "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( RuntimeException e6)
        {
            System.out.println("RunTime Exception");  
            JOptionPane.showMessageDialog(this, 
            "Runtime error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }      
        return path;  
    } 
} // end class JFileChooserDemo
