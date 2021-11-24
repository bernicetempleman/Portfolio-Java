/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.ch10.filelocking;

import java.io.*;
import java.nio.channels.*;
public class OSCh10FileLocking { 
	public static final boolean EXCLUSIVE = false;
	public static final boolean SHARED = true;
	public static void main(String arsg[]) throws IOException { 
		FileLock sharedLock = null;
		FileLock exclusiveLock = null;
		try { 
			RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
			// get the channel for the file
			FileChannel ch = raf.getChannel();
			// this locks the first half of the file - exclusive
			exclusiveLock = ch.lock(0, raf.length()/2, EXCLUSIVE);
			/** Now modify the data . . . */
			// release the lock
			exclusiveLock.release();

// this locks the second half of the file - shared
			sharedLock = ch.lock(raf.length()/2+1, raf.length(), 				SHARED);
			/** Now read the data . . . */
			// release the lock
			sharedLock.release();
		} catch (java.io.IOException ioe) { 
			System.err.println(ioe);
		}finally { 
			if (exclusiveLock != null)
			exclusiveLock.release();
			if (sharedLock != null)
			sharedLock.release();
		}
	}
}
