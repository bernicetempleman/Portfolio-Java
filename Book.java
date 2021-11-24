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
public abstract class Book {
    
    public static int totalBooks = 0;
    
    protected int numPages;
    
    protected String name = "Book Name";
    
    protected int length(){
        return numPages;
    }
    
    // all subclasses must implement
    // and you can call this on any Book without knowing what type of subclass book
    public abstract void readBook();
    
    public String getName()
    {
        return name;
    }
    
    
}
