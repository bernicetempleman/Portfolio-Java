/*
 * Static blocks
 */
package staticblocks;

public class StaticBlocks {

    // you can often provide an initial value for a field in its declaration:
    // initialize to 10
    public static int iStaticInt = 10;
    
    //block to print
    {
        System.out.println("iStaticInt: " + iStaticInt);
    }

    // initialize to false
    private int iPrivateInt = 1;
    
    //block to print
    {
        System.out.println("iPrivateInt: " + iPrivateInt);
    }
    
    // static initialization block is a normal block of code enclosed in braces, { }, 
    //and preceded by the static keyword.

    static {
        int iStaticBlock = 1;   
        System.out.println("iStaticBlock: " + iStaticBlock);
    }
    
    // private static method: alternative to static blocks:
    public static int iPrivateStaticBlock = initializeClassVariable();
        
    private static int initializeClassVariable() 
    {
        // initialization code goes here
        int i =1;  
        System.out.println("initializeClassVariable: iPrivateStaticBlock: " + i);
        return i;
    }

    /* Initializer blocks for instance variables look just like static initializer blocks, 
    but without the static keyword:
    The Java compiler copies initializer blocks into every constructor. 
    Therefore, this approach can be used to share a block of code between multiple constructors.
    */
    {
        // whatever code is needed for initialization goes here
        int iIntializerBlock = 1;
        System.out.println("iIntializerBlock: " + iIntializerBlock);
    }
    
    //A final method cannot be overridden in a subclass. 
        private int iPrivateFinalMethod = initializeInstanceVariable();
        
        protected final int initializeInstanceVariable() 
        {
            // initialization code goes here 
            int i = 1;
            System.out.println("iPrivateFinalMethod : " + i );
            return i;
        }
 
        
    // constructor example       
    public int iConstructor = 0; //variable used in constructor
    
    public StaticBlocks() {
        //initialization
        int iConstructor = 1;
        iStaticInt++;
        System.out.println("Constructor: iConstructor: " + iConstructor);
    }
    
    
    public static void main(String[] args) {
        
        // create a new object
        System.out.println("\nCreate first object");
        StaticBlocks staticBlock = new StaticBlocks();
      
        System.out.println("\nCreate second object");
        StaticBlocks staticBlock2 = new StaticBlocks();
    }  
}
