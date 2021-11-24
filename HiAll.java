public class HiAll {

    /*
    Variable names are case-sensitive.
     A variable's name can be
    — an unlimited-length sequence of letters and digits,
    beginn with a letter, the dollar sign "$", or the underscore character "_".
    Best to always begin your variable names with a letter,
     not "$" or "_".
     Additionally, the dollar sign character, by convention, is never used at all.

Subsequent characters may be letters, digits, dollar signs, or underscore characters.
Conventions (and common sense) apply to this rule as well.
When choosing a name for your variables,
use full words instead of cryptic abbreviations.
Doing so will make your code easier to read and understand.
In many cases it will also make your code self-documenting;
fields named cadence, speed, and gear,
 for example, are much more intuitive than abbreviated versions,
  such as s, c, and g.
   Also keep in mind that the name you choose must not be a keyword or reserved word.
If the name you choose consists of only one word,
spell that word in all lowercase letters.
If it consists of more than one word,
capitalize the first letter of each subsequent word.
 The names gearRatio and currentGear are prime examples of this convention.
 If your variable stores a constant value,
 such as static final int NUM_GEARS = 6,
  the convention changes slightly,
   capitalizing every letter and separating subsequent words with the underscore character.
   By convention, the underscore character is never used elsewhere.
     */

    // Java primitive data types
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    //  byte
    //  short
    //  int
    //  long
    //  float
    //  double
    //  boolean
    //  char

    //cah you change?
    // Well, if you declare something changeable, you can
    // but, if you declare something 5, then...
    // you can edit it here
    public static final double PI= 3.14;


    public static void main(String[] args) {

        System.out.println(PI);

        //oops, that is not right lets change it
        //PI = 3.14;
        //java: cannot assign a value to final variable PI

    // defining variables

    byte myByte = 0;        // 8 bit value of -128 to 127
    short myShort;       // 16 bit  value of -32,768  to 32,767
    int myInt;          // 32 bit value of f -2^31 to 2^31-1
    long myLong;        // 64 bit  value of -2^63 to 2^63-1
    float myFloat;      // single precision32-bit IEEE 754 floating point
    double myDouble;    // double precision 64-bit IEEE 754 floating point
    boolean myBoolean;  // value is either true or false
    char myChar;        // a single 16-bit Unicode character.
                        // '\u0000' (or 0) to '\uffff' (or 65,535 inclusive).

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    // We learned the 8 primitive variable types in Java
    // We learned how to declare primitive variables
    // There is still more to learn about primitive variables.
        System.out.println(myByte);

    // to set a variable:
    myByte = 100;
    myShort = 10000;
    myInt = 1;
    myLong = 2L;
    myFloat = 1.2f;
    myDouble = 1.2e2;
    myBoolean = true;
    myChar = '1';

    // to output a variable
    System.out.println("myByte = " + myByte);
    System.out.println("myShort = " + myShort);
    System.out.println("myInt = " + myInt);
    System.out.println("myLong = " + myLong);
    System.out.println("myFloat = " + myFloat);
    System.out.println("myDouble = " + myDouble);
    System.out.println("myBoolean = " + myBoolean);
    System.out.println("myChar = " + myChar);

    myInt +=4;
    System.out.println("myInt = " + myInt);
    System.out.println("myInt /2 = " + myInt/2);
    System.out.println("myInt %2 =  " + myInt%2);

        System.out.println(0.0 / 0.0);	  //zero divided by zero
        System.out.println(Math.sqrt(-1)); // sqrt of negative number
        System.out.println(10.0 % 0);      // mod by 0

//converting
        int inum =1;
        System.out.println("inum = "+ inum);
        double dnum = 2.99999;
        System.out.println("dnum = "+ dnum);
        inum = (int) dnum;
        System.out.println("inum = "+ inum);
        dnum = (double) inum;
        System.out.println("dnum = "+ dnum);

    System.out.println(Double.POSITIVE_INFINITY);
    System.out.println(Double.NEGATIVE_INFINITY);

    Double maxD = Double.MAX_VALUE * 2;
        System.out.println( maxD*(-1));
        System.out.println( maxD);

        var vacation = 15;
        System.out.println("vacation "+ vacation);

        var greet = "hi all";
        System.out.println(greet);

        vacation++;
        System.out.println("vacation "+ vacation);


    }

}
