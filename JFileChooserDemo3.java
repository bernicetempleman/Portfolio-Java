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
	
• Select a file from a file dialog box, using the class JFileChooser.
• If the file is readable (text file), then process the file as follow,
otherwise display a message stating that the file is not readable. 

Process the readable file:
• Buffer chunks of 32 bytes; each row saves id 
(in column 1, succession number starting from 1) and the 32 bytes. 
The buffer size of the last row may be less than 32 byes, in which case pad it with ‘*’.
• Display the content of the buffer.
• Save the buffer in a file, where the file name is buffOut.txt 

/*
Bernice Templeman
CIS 5230Operating Systems - Program 5
 */
package os.program5;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.regex.PatternSyntaxException;
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
        
        //Select a file from a file dialog box, using the class JFileChooser
        Path path = getFileOrDirectoryPath();
        boolean good = false;
        
        //check If the file is readable then if (text file)
        good = analyzePath(path); // get Path from user and display info
        if (good) //readable
        {
            //check if text file
            good = checkIfTextFile(path);
            if(good)
            {
                //Process the readable file:
                processTextFile(path);
            }
            else //display a message stating that the file is not readable.
            {
                outputArea.setText("File is not readable.");
            }
        }
        else//not a valid path
        {
            outputArea.setText("File is not readable."); // display String content
        }
    }//end gui constructor

    // check if readable file
    public boolean analyzePath(Path path)
    {
        
        // if exists, display info
        if (path != null ) 
        {
            try{
                StringBuilder builder = new StringBuilder();
                builder.append(String.format("%s:%n", path.getFileName()));
                
                String fileString = path.getFileName().toString();
                
                Path filePath = path.getFileName();
                
                /* Verifying the Existence of a File or Directory

                The methods in the Path class are syntactic, meaning that they operate on the Path instance. 
                But eventually you must access the file system to verify that a particular Path exists, 
                or does not exist. You can do so with the exists(Path, LinkOption...) and the notExists(Path, LinkOption...) methods. 
                Note that !Files.exists(path) is not equivalent to Files.notExists(path). 
                When you are testing a file's existence, three results are possible:

                The file is verified to exist.
                The file is verified to not exist.
                The file's status is unknown. This result can occur when the program does not have access to the file.
                If both exists and notExists return false, the existence of the file cannot be verified.
                */
                boolean exists = Files.exists(path);
                boolean notExists = Files.notExists(path);
                boolean isRegularFile = Files.isRegularFile(path);
                boolean isReadableFile = Files.isReadable(path);
                boolean isDirectory = Files.isDirectory(path);
                
                
                if (!isDirectory && exists && !notExists && isReadableFile && isRegularFile)
                {   
                    return true;
                }
                else 
                {
                    return false;
                }
            }     
            catch( NullPointerException e1)
            {
                System.out.println("Null Pointer");
                JOptionPane.showMessageDialog(this, 
                "File does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch ( SecurityException e4)
            {
                System.out.println("Security Exception");  
                JOptionPane.showMessageDialog(this, 
                "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch ( RuntimeException e5)
            {
                System.out.println("RunTime Exception"); 
                JOptionPane.showMessageDialog(this, 
                "Runtime error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }//end if
        else // Path does not exist
        {
            JOptionPane.showMessageDialog(this,
                "Path does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
        return false;   
    }

    //check if file is a Text file
    public boolean checkIfTextFile(Path path)
    {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        boolean error = false;
        
        try 
        {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", path.getFileName()));
                
            String fileString = path.getFileName().toString(); 
            String fileName =  path.toAbsolutePath().toString();           
            Path filePath = path.getFileName();
            String line = null; 
                    
            //open file for reading: This will reference one line at a time
            // FileReader reads text files in the default encoding.
            fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            bufferedReader = new BufferedReader(fileReader);

            error = false;
            while(!error &&((line = bufferedReader.readLine()) != null) )
            {
                //check if line is readable characters
                if(line.matches("\\A\\p{ASCII}*\\z"))
                {
                    error = false;
                    //System.out.println(line);
                }
                else if(isAllASCII(line))
                {
                    error = false;
                    //System.out.println(line);
                }
                else if (line.matches("[_a-zA-Z0-9\\-\\.]*"))   
                {
                    error = false;
                    //System.out.println(line);
                }
                else //if (!line.matches("[_a-zA-Z0-9\\-\\.]*"))   
                {
                    // \\A - Beginning of input ... \\p{ASCII}* - Any ASCII character any times ...\\z - End of input 
                    System.out.println("file appears to not be a text file");
                    error = true;
                }
            } //end while 
 
            if(error)
            {
                builder.append(String.format("File Error. Not a Text File %s \n",  fileString));
                outputArea.setText(builder.toString()); // display String content
                //return false;
            }
        }  
        catch(FileNotFoundException e0)
        {
            System.out.println("FileNotFoundException");
            JOptionPane.showMessageDialog(this, 
                "FileNotFoundException.", "ERROR", JOptionPane.ERROR_MESSAGE);          
        }
        catch( NullPointerException e1)
        {
            System.out.println("Null Pointer");
            JOptionPane.showMessageDialog(this, 
                "File does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
        catch ( SecurityException e4)
        {
            System.out.println("Security Exception");  
            JOptionPane.showMessageDialog(this, 
                "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch ( RuntimeException e5)
        {
            System.out.println("RunTime Exception"); 
            JOptionPane.showMessageDialog(this, 
                "Runtime error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( IOException e4)
        {
            System.out.println("I/O Exception");  
            JOptionPane.showMessageDialog(this, 
                "IO Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        finally 
        {  // always close the streams
            try 
            {
               bufferedReader.close();

            } 
            catch (IOException ex) 
            { 
                ex.printStackTrace(); 
            }
        }//end finally
        if (!error)
            return true;
        else
            return false;
    }//end checkIfTextFile
    
    public void processTextFile(Path path)
    {
        
        /*Buffer chunks of 32 bytes; 
        each row saves id (in column 1, succession number starting from 1) and the 32 bytes. 
        The buffer size of the last row may be less than 32 byes, in which case pad it with ‘*’.
        Display the content of the buffer.
        Save the buffer in a file, where the file name is buffOut.txt 
        */
        
        String fileName =  path.toAbsolutePath().toString();
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:%n", path.getFileName()));               
        String fileString = path.getFileName().toString();                
        Path filePath = path.getFileName();   
                                              
        String inFileStr = fileName;
        String outFileStr = "buffOut.txt ";
        FileInputStream in = null;
        FileOutputStream out = null;
 
        try 
        {
            in = new FileInputStream(inFileStr);
            out = new FileOutputStream(outFileStr);

            byte[] byteBuf = new byte[32];   
            int numBytesRead;
            int i = 1;
            while ((numBytesRead = in.read(byteBuf)) != -1) 
            {
                String StringI = Integer.toString(i);
                String newline = "\r\n" ;
                String star = "*";
            
                out.write(StringI.getBytes());
                out.write(byteBuf, 0, numBytesRead);
                int currentbytes = numBytesRead;

                if(numBytesRead != 32)
                {
                    while(currentbytes < 32)
                    {                                      
                        if(currentbytes < byteBuf.length)
                        {
                            out.write(star.getBytes());
                            byteBuf[currentbytes] = '*';
                        }
                        currentbytes++;
                    }
                }
            
                out.write(newline.getBytes());
                out.write(newline.getBytes());
                        
                String outBuf = "";
                for(int j=0; j < byteBuf.length; j++)
                {
                    outBuf +=Character.toString ((char) byteBuf[j]);
                }
            
                builder.append(String.format("\n%s%s\n", StringI, outBuf)); 
                outputArea.setText(builder.toString()); // display String content
                i++;
            }//end while

        } //end try
        catch(PatternSyntaxException e)
        {
            System.out.println("PatternSyntaxException ");
        }
  
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch( NullPointerException e1)
        {
            System.out.println("Null Pointer");
            JOptionPane.showMessageDialog(this, 
                "File does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch ( SecurityException e4)
        {
            System.out.println("Security Exception");  
            JOptionPane.showMessageDialog(this, 
                "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch ( RuntimeException e5)
        {
            System.out.println("RunTime Exception"); 
            JOptionPane.showMessageDialog(this, 
                "Runtime error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch(IOException ex) 
        {
            System.out.println( "Error reading file '" + fileName + "'");                  
        }
        finally 
        {  // always close the streams
            try 
            {
                if (in != null) in.close();
                if (out != null) out.close();
            } 
            catch (IOException ex) 
            { 
                ex.printStackTrace(); 
            }
        }//end finally
   
 }//end process file

//Select a file from a file dialog box, using the class JFileChooser
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
            
        }
        catch ( IllegalArgumentException e2)
        {
            System.out.println("Illegal Argument Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Illegal Argument.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        catch ( HeadlessException  e3)
        {
            System.out.println("Headless Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Headless Exception.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        catch (NullPointerException e4)
        {
            System.out.println("NullPointer Exception"); 
            JOptionPane.showMessageDialog(this, 
            "Null Pointer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        catch ( SecurityException e5)
        {
            System.out.println("Security Exception");  
            JOptionPane.showMessageDialog(this, 
            "Security Exception", "ERROR", JOptionPane.ERROR_MESSAGE);
           
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
   
//code from the IDN class. to check if a string only contains US-ASCII code 
private static boolean isAllASCII(String input) {
    boolean isASCII = true;
    for (int i = 0; i < input.length(); i++) {
        int c = input.charAt(i);
        if (c > 0x7F) {
            isASCII = false;
            break;
        }
    }
    return isASCII;
}

} // end class JFileChooserDemo
