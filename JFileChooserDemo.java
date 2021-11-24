/*
Bernice Templeman
CIS 5230Operating Systems - Program 2 
JFileChooserDemo.java tests with throws clause

File Operations - Write a Java program to imitate a certain file system and certain utility programs of an operating system.  	
•	Select a file from a file dialog box, using the class JFileChooser.
•	List the absolute path of the file
•	Show the size of the selected file.
•	List all the files, directories and subdirectories in the path of the file selected.

 */
package program.pkg2.os;

// Demonstrating JFileChooser.a
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChooserDemo extends JFrame
{
    private final JTextArea outputArea; // displays file contents
   
    // set up GUI
    public JFileChooserDemo() throws IOException 
    {
        super("JFileChooser Demo");
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea)); // outputArea is scrollable
        analyzePath(); // get Path from user and display info
    } 

    // display information about file or directory user specifies
    public void analyzePath() throws IOException
    {
        // get Path to user-selected file or directory
        Path path = getFileOrDirectoryPath();

        StringBuilder builder = new StringBuilder();
        
        //1. absolutePath
        builder.append(String.format("Absolute path: %s%n", 
            path.toAbsolutePath()));
         
        //2. size
        builder.append(String.format("%nSize: %s%n", Files.size(path)));
         
        //3. list files
        builder.append(String.format("%nDirectory contents:%n"));
            
        // object for iterating through a directory's contents
        DirectoryStream<Path> directoryStream = 
        Files.newDirectoryStream(path);
   
        for (Path p : directoryStream)
            builder.append(String.format("%s%n", p));

         outputArea.setText(builder.toString()); // display String content
   } // end method analyzePath

    // allow user to specify file or directory name
    private Path getFileOrDirectoryPath()
    {
        // configure dialog allowing selection of a file or directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
            JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        // return Path representing the selected file
        return fileChooser.getSelectedFile().toPath();
    } 
} // end class JFileChooserDemo
