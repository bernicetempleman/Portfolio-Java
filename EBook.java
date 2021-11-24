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
public class EBook extends Book {
      
    //inherits numPages field 
    
    public static int totalEBooks = 0;
    
    private String website;
    
    //private String name = "EBook Name";
    
    //inherits length method
    
    public EBook()
    {
        Book.totalBooks++;
        totalEBooks++;
    }
    
    public EBook(int numPages)
    {
        Book.totalBooks++;
        totalEBooks++;
        
        this.numPages = numPages;
        website = "books.com";
    }

    //required to override abstract method
    @Override
    public void readBook() {
        System.out.println("Read book online at: " + getWebsite());    
    } 
    
    public String getWebsite()
    {
        return website;
    }
    @Override
    public String getName()
    {
        name = "EBook Name";
        return name;
    }
}
