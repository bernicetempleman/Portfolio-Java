/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Bernice
 */
public class PBook extends Book {
    
    //inherits numPages field
    
    public static int totalPhysicalBooks = 0;
    
    //inherits length method
    
    public PBook()
    {
        Book.totalBooks++;
        totalPhysicalBooks++;
    }
    
    public PBook(int numPages)
    {
        Book.totalBooks++;
        totalPhysicalBooks++;
        
        this.numPages = numPages;
    }

    //required to override abstract method
    @Override
    public void readBook() {
        System.out.println("Check book out at front desk");
    }
    
    
    
}
