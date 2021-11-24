/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 1 – 8.16 pg. 358
Name:                       Bernice Templeman

HugeIntegerTest test the HugeInteger Class

Class HugeInteger uses a 40-element array of digits 
to store integers as large as 40 digits each. 

[Note: Primitive boolean values can be output as 
the word “true” or the word “false” with format specifier %b.]

The following assumptions are acceptable.
    "HugeInteger" class only represent positive numbers
    User input is valid (i.e. assume only valid numeric values are entered)
 */
package hugeintegertest;

public class HugeIntegerTest {

    /**
     * @param args the command line arguments
     */
    
    // main method begins execution of the Java application
    public static void main(String[] args) 
    {
        // Create HugeIntegers
        HugeInteger hi1 = new HugeInteger("99");
        HugeInteger hi2 = new HugeInteger("3");
        HugeInteger hi3 = new HugeInteger("03");  
        HugeInteger hi6 = new HugeInteger("9999999999999999999999999999999999999999");
        HugeInteger hi7 = new HugeInteger("");
        HugeInteger hi8 = new HugeInteger();
        HugeInteger hi9 = new HugeInteger("0000000000000000000000000000000000000000");
        HugeInteger hi10 = new HugeInteger("9999999999999999999999999999999999999999");
        HugeInteger hi12 = new HugeInteger("999999999999999999999999999999999999999");
                     
        // test toString and numDigits
        System.out.printf("\nTest to String hi1: %s", hi1.toString());
        System.out.printf("\nnumDigits = %d", hi1.getNumDigits());
        System.out.printf("\nTest to String hi2: %s", hi2.toString());
        System.out.printf("\nnumDigits = %d", hi2.getNumDigits());
        System.out.printf("\nTest to String hi3: %s", hi3.toString());
        System.out.printf("\nnumDigits = %d", hi3.getNumDigits());
        System.out.printf("\nTest to String hi6: %s", hi6.toString());
        System.out.printf("\nnumDigits = %d", hi6.getNumDigits());
        System.out.printf("\nTest to String hi7: %s", hi7.toString());
        System.out.printf("\nnumDigits = %d", hi7.getNumDigits());
        System.out.printf("\nTest to String hi8: %s", hi8.toString());
        System.out.printf("\nnumDigits = %d", hi8.getNumDigits());
        System.out.printf("\nTest to String hi9: %s", hi9.toString());
        System.out.printf("\nnumDigits = %d", hi9.getNumDigits());
        System.out.printf("\nTest to String hi10: %s", hi10.toString());
        System.out.printf("\nnumDigits = %d", hi10.getNumDigits());
        System.out.printf("\nTest to String hi12: %s", hi12.toString());
        System.out.printf("\nnumDigits = %d", hi12.getNumDigits());
        
        // test add
        HugeInteger hi4 = HugeInteger.add(hi1, hi2);
        System.out.printf("\n\nTest add hi1 + hi2 (expect 102): \n   %s\n + %s\n = %s\n",    
                hi1.toString(),
                hi2.toString(),
                hi4.toString());
        System.out.printf("numDigits = %d\n", hi4.getNumDigits());
        
        HugeInteger hi11 = HugeInteger.add(hi10, hi6);
        System.out.printf("\nTest add hi10 + hi6 "
                + "(expect overflow)\n9999999999999999999999999999999999999998:\n"
                + " \n   %s\n + %s\n = %s\n",    
                hi10.toString(),
                hi6.toString(),
                hi11.toString());
        System.out.printf("numDigits = %d\n", hi11.getNumDigits());
        
        HugeInteger hi13 = HugeInteger.add(hi12, hi3);
        System.out.printf("\nTest add hi12 + hi3 "
                + "\n(no overflow)\n1000000000000000000000000000000000000002:\n"
                + " \n   %s\n + %s\n = %s\n",    
                hi12.toString(),
                hi3.toString(),
                hi13.toString());
        System.out.printf("numDigits = %d\n", hi13.getNumDigits());
      
        // test subtract
        HugeInteger hi5 = HugeInteger.subtract(hi1, hi1);
                System.out.printf("\nTest subtract hi1 - hi1(expect 0): \n   %s\n - %s\n = %s\n",    
                hi1.toString(),
                hi1.toString(),
                hi5.toString());
        System.out.printf("numDigits = %d\n", hi5.getNumDigits());
        
       
                
        HugeInteger hi15 = HugeInteger.subtract(hi9, hi6);
                System.out.printf("\nTest subtract hi9 - hi6(invalid : expect 0): \n   %s\n - %s\n = %s\n",    
                hi9.toString(),
                hi6.toString(),
                hi15.toString()); 
        System.out.printf("numDigits = %d\n", hi15.getNumDigits());
                
        HugeInteger hi16 = HugeInteger.subtract(hi2, hi1);
                System.out.printf("\nTest subtract hi2 - hi1(invalid : expect 0): \n   %s\n - %s\n = %s\n",    
                hi2.toString(),
                hi1.toString(),
                hi16.toString());
        System.out.printf("numDigits = %d\n", hi16.getNumDigits());
                
        HugeInteger hi17 = HugeInteger.subtract(hi1, hi2);
                System.out.printf("\nTest subtract hi1 - hi2(valid : expect96): \n   %s\n - %s\n = %s\n",    
                hi1.toString(),
                hi2.toString(),
                hi17.toString());
        System.out.printf("numDigits = %d\n", hi17.getNumDigits());   
        
         
        
        // test is zero
        System.out.printf("\nTest is zero hi1 (expect false): %b\n",HugeInteger.isZero(hi1));
        System.out.printf("Test isZero hi5(expect true): %b\n", HugeInteger.isZero(hi5));
      
        // test is equal
        System.out.printf("\nTest is equal hi1 hi2 (expect false): %b\n",HugeInteger.isEqualTo(hi1,hi2));
        System.out.printf("Test is equal hi3 hi2 (expect true): %b\n",HugeInteger.isEqualTo(hi3,hi2));
         
        //* isNotEqualTo, 
        System.out.printf("\nTest is not equal hi1 hi2 (expect true): %b\n",HugeInteger.isNotEqualTo(hi1,hi2));
        System.out.printf("Test is not equal hi3 hi2 (expect false): %b\n",HugeInteger.isNotEqualTo(hi3,hi2));
        
        // test isGreaterThan, 
        System.out.printf("\nTest is Greater hi1 hi2 (expect true): %b\n",HugeInteger.isGreaterThan(hi1,hi2));
        System.out.printf("Test is Greater hi3 hi2 (expect false): %b\n",HugeInteger.isGreaterThan(hi3,hi2));
        
        // test isLessThan, 
        System.out.printf("\nTest is Less hi1 hi2(expect false): %b\n",HugeInteger.isLessThan(hi1,hi2));
        System.out.printf("Test is Less  hi2 hi1(expect true): %b\n",HugeInteger.isLessThan(hi2,hi1));
        
        //  isGreaterThanOrEqualTo 
        System.out.printf("\nTest is Greater or Equal hi1  hi1 (expect true): %b\n",HugeInteger.isGreaterThanOrEqualTo(hi1,hi1));
        System.out.printf("Test is Greater or Equal hi2 hi1 (expect false): %b\n",HugeInteger.isGreaterThanOrEqualTo(hi2,hi1));
        
        // isLessThanOrEqualTo
        System.out.printf("\nTest is Less or Equal hi1 hi1 (expect true): %b\n",HugeInteger.isLessThanOrEqualTo(hi1,hi1));
        System.out.printf("Test is Less or Equal hi1 hi2(expect false): %b\n",HugeInteger.isLessThanOrEqualTo(hi1,hi2));
   
        //test setHugeInt
        HugeInteger hi18 = new HugeInteger();
        System.out.printf("\nTest to String hi8: %s", hi18.toString());
        System.out.printf("\nnumDigits = %d", hi18.getNumDigits());
        hi18.setHugeInt("12345");
        System.out.printf("\nTest setHugeInt hi8: %s", hi18.toString());
        System.out.printf("\nnumDigits = %d\n", hi18.getNumDigits());
        
        //huge integer
        //h1 = 765 h2 = 66
        HugeInteger hi19 = new HugeInteger("765");
        HugeInteger hi20 = new HugeInteger("66");
        HugeInteger hi21 = HugeInteger.subtract(hi19, hi20);
         System.out.printf("\nTest subtract hi1 - hi2(valid : expect 699): \n   %s\n - %s\n = %s\n",    
                hi19.toString(),
                hi20.toString(),
                hi21.toString());
        System.out.printf("numDigits = %d\n", hi20.getNumDigits()); 
    }// end main
} //end HugeIntegerTest class
