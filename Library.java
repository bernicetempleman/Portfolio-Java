/* Bernice Templeman

An abstract class is a class declared as abstract and used as a superclass in 
a hierarchy of classes. 
Abstract classes cannot be instantiated, but they can be subclassed.

An abstract class may or may not include abstract methods. 
If an abstract class includes abstract methods, those methods must be in the 
implemented in the concrete (non-abstract) subclasses. 
Abstract classes can have abstract subclasses that don't need to include the 
abstract methods.

Only the abstract method declaration is in the abstract class. 
Abstract methods are instance methods with the abstract keyword in the 
declaration.
There is no implementation of the abstract method in the abstract class.

Abstract methods can only be declared in abstract classes.

The purpose of an abstract class is to be extended.
It provides a superclass from which other classes can inherit and share a
common design.
You never intend to create objects of the abstract class because it is 
general and incomplete. 
Abstract classes only specify what is common in the subclasses.

An example of an abstract class is:

// This is simple example of an abstract class and subclasses. 
 */
package library;

/**
 *
 * @author Bernice
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create variables of Abstract type Book 
        // and objects of ConcreteTypes 
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        System.out.println("\nCreating Books\n");
        Book myBook1 = new PBook(200);
        Book myBook2 = new EBook(100);
        
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        System.out.println("\nCreating Books\n");
        PBook myBook3 = new PBook(250);
        EBook myBook4 = new EBook(150);
        Book myBook5;
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        System.out.println("\nCreating myBook5 \n");
        myBook5 = new PBook();
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        System.out.println("\nTo Read Book 1:");
        myBook1.readBook();
        System.out.println("This book has " + myBook1.length() + " pages");
               
        System.out.println("\nTo Read Book 2:");
        myBook2.readBook();
        System.out.println("This book has " + myBook2.length() + " pages");
        
        // not every book has a website
        System.out.println("I can't  call getWebsite: on static type book/dynamic type eBook");
        
        //every book has a name & getName (not abstract so not required, can override book method
        System.out.println("I can  call getName: on static type book/dynamic type eBook: " + myBook2.getName() );
        
        System.out.println("\nTo Read Book 4:");
        myBook4.readBook();
        System.out.println("This book has " + myBook4.length() + " pages");
        System.out.println("I can  call getWebsite: on static type eBook/dynamic type eBook: "+ myBook4.getWebsite());
        System.out.println("I can  call getName: on static type book/dynamic type eBook: " + myBook4.getName() );
        
        Book myBook6;
        System.out.println("\nTotal Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        System.out.println("\nCreating EBook\n");
        EBook myBook7 = new EBook();
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);

        System.out.println("\nSetting myBook6 = myBook7;\n");
        myBook6 = myBook7;
        
        System.out.println("\nTotal Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        //myBook7 = myBook6 can't do 
        System.out.println("\nCasting:  myBook7 = (EBook) myBook6;\n");
        myBook7 = (EBook) myBook6;  //this works & runs
        
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        EBook myBook8;
        
        System.out.println("\nCreating JBook9\n");
        JBook myBook9 = new JBook();     
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
        //myBook9 = myBook8; //can't do : incompatible types: ebook can't be converted to jbook
        
        myBook8 = myBook9;
        myBook9 = (JBook) myBook8;  //this works & runs
        
        System.out.println("\nCreating new EBook 8\n");
        
        myBook8 = new EBook();
        
        System.out.println("Total Library books: "+ Book.totalBooks);
        System.out.println("Total Library Physical books: "+ PBook.totalPhysicalBooks);
        System.out.println("Total Library ebooks: "+ EBook.totalEBooks);
        
       // myBook9 = (JBook) myBook8; 
       //runtime error: Exception in thread "main" java.lang.ClassCastException: 
        //library.EBook cannot be cast to library.JBook at library.Library.main
        
        System.out.println("\n\nBook names");
        System.out.println("Book 1: " + myBook1.getName() + " is a PBook: " + (myBook1 instanceof PBook));
        System.out.println("Book 2: " + myBook2.getName() + " is a EBook: " + (myBook2 instanceof EBook));
        System.out.println("Book 3: " + myBook3.getName() + " is a Book: " + (myBook3 instanceof Book));
        System.out.println("Book 4: " + myBook4.getName() + " is a JBook: " + (myBook4 instanceof JBook));
        System.out.println("Book 5: " + myBook5.getName() + " is a PBook: " + (myBook5 instanceof PBook));
        System.out.println("Book 6: " + myBook6.getName() + " is a PBook: " + (myBook6 instanceof PBook));
        System.out.println("Book 7: " + myBook7.getName() + " is a JBook: " + (myBook7 instanceof JBook));
        System.out.println("Book 8: " + myBook8.getName() + " is a EBook: " + (myBook8 instanceof EBook));
        System.out.println("Book 9: " + myBook9.getName() + " is a JBook: " + (myBook9 instanceof JBook));
    }
    
}
