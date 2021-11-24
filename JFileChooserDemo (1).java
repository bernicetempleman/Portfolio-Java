/*
Class JFileChooser displays a dialog that enables the user to easily select files or directories. 
To demonstrate JFileChooser, we enhance the example in Section 15.3, as shown in Figs. 15.12–15.13. 
The example now contains a graphical user interface, but still displays the same data as before. 
The constructor calls method analyzePath in line 24. This method then calls method getFileOrDirectoryPath 
in line 31 to retrieve a Path object representing the selected file or directory.

Method getFileOrDirectoryPath (lines 71–85 of Fig. 15.12) creates a JFileChooser (line 74). 
Lines 75–76 call method setFileSelectionMode to specify what the user can select from the fileChooser. 
For this program, we use JFileChooser static constant FILES_AND_DIRECTORIES to indicate that files and directories can be selected. 
Other static constants include FILES_ONLY (the default) and DIRECTORIES_ONLY.
Line 77 calls method showOpenDialog to display the JFileChooser dialog titled Open. 
Argument this specifies the JFileChooser dialog’s parent window, which determines the position of the dialog on the screen. 
If null is passed, the dialog is displayed in the center of the screen—otherwise, 
the dialog is centered over the application window (specified by the argument this). 
A JFileChooser dialog is a modal dialog that does not allow the user to interact with any other window in the program until the dialog is closed. 
The user selects the drive, directory or filename, then clicks Open. 
Method showOpenDialog returns an integer specifying which button (Open or Cancel) the user clicked to close the dialog. 
Line 48 tests whether the user clicked Cancel by comparing the result with static constant CANCEL_OPTION. 
If they’re equal, the program terminates. 
Line 84 calls JFileChooser method getSelectedFile to retrieve a File object (package java.io)
 representing the file or directory that the user selected, then calls File method toPath to return a Path object. 
The program then displays information about the selected file or directory.

*/
package jfilechoosertest;
// Fig. 15.12: JFileChooserDemo.java
// Demonstrating JFileChooser.
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

      if (path != null && Files.exists(path)) // if exists, display info
      {
         // gather file (or directory) information
         StringBuilder builder = new StringBuilder();
         builder.append(String.format("%s:%n", path.getFileName()));
      	builder.append(String.format("%s a directory%n", 
      		Files.isDirectory(path) ? "Is" : "Is not"));
      	builder.append(String.format("%s an absolute path%n", 
      		path.isAbsolute() ? "Is" : "Is not"));
      	builder.append(String.format("Last modified: %s%n", 
      		Files.getLastModifiedTime(path)));
      	builder.append(String.format("Size: %s%n", Files.size(path)));
      	builder.append(String.format("Path: %s%n", path));
      	builder.append(String.format("Absolute path: %s%n", 
            path.toAbsolutePath()));

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
      } 
      else // Path does not exist
      {
         JOptionPane.showMessageDialog(this, path.getFileName() +
            " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
      }   
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
