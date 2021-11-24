package hugeinteger1;
import java.util.Arrays;

/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 1 – 8.16 pg. 358
Name:                       Bernice Templeman


zip and submit all files required to compile & run the application 
via the Drop box in Week 1 module) by January, 22th . 
The module contains a suggested solution 
for the class structure of the "HugeInteger" class.
The following assumptions are acceptable.
    "HugeInteger" class only represent positive numbers
    User input is valid (i.e. assume only valid numeric values are entered)
=====================================================================

8.16 (Huge Integer Class) 
Create a class HugeInteger which uses a 40-element array of digits 
to store integers as large as 40 digits each. 

Provide methods 
* parse, 
* toString, 
* add 
* subtract. 

Method parse should receive a String, 
extract each digit using method charAt and 
place the integer equivalent of each digit into the integer array.

For comparing HugeInteger objects, provide the following methods: 
* isEqualTo, 
* isNotEqualTo, 
* isGreaterThan, 
* isLessThan, 
* isGreaterThanOrEqualTo and 
* isLessThanOrEqualTo. 

Each of these is a predicate method that 
returns true if the relationship holds between the two HugeInteger objects and 
returns false if the relationship does not hold. 

*Provide a predicate method isZero. 

If you feel ambitious, 
also provide methods 
multiply, 
divide and 
remainder. 
[Note: Primitive boolean values can be output as 
the word “true” or the word “false” with format specifier %b.]
 */



public class HugeInteger1 
{
  @SuppressWarnings("FieldMayBeFinal")
    private int[] intArray;
    private int numDigits;  // stores the number of digits in intArray
  
    public static void main(String[] args) {
      // TODO code application logic here
      HugeInteger1 hi1 = new HugeInteger1("99");
      HugeInteger1 hi2 = new HugeInteger1("3");
      
      System.out.println(HugeInteger1.isEqualTo(hi1,hi2));
        
      hi1.toString();
      hi2.toString();
      HugeInteger1 hi3 = HugeInteger1.add(hi1, hi2);
      hi1.toString();
      hi2.toString();
      hi3.toString();
      hi1.toString();
      hi2.toString();
      HugeInteger1 hi4 = HugeInteger1.subtract(hi1, hi2);
      hi1.toString();
      hi2.toString();
      hi4.toString();
      
    }

    // 1 arg constructor
    public HugeInteger1(String s)
    {
        intArray = new int[40];
        numDigits = 0;
        // call parse(s)
        this.parse(s);
    }
  
    //no-arg constructor
    public HugeInteger1()
    {
        intArray = new int[40];
        numDigits = 0;
    }
  
    //method to parse string
    public void parse(String s)
    {
        int offset = 40- s.length();
        // Add each digit to the arrays
        for(int i = 0; i < s.length(); i++)
        {
            intArray[i+ offset] = ((int) s.charAt(i))-48;
            numDigits++;
        }
        System.out.println("Numdigits = " + numDigits+"\n");
    }
  
    public static HugeInteger1 add(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
    {
        // Create hugeInt3
        HugeInteger1 hugeInt3 = new HugeInteger1();
        
        int maxSize = hugeInt1.numDigits;
        if (hugeInt1.numDigits< hugeInt2.numDigits)
            maxSize = hugeInt2.numDigits;
        int carryFlag = 0;
        // Loop  
        for (int i = 39; i >= 39-maxSize; i--)
        {
        //    Add digits from hugeInt1 and hugeInt2,
        //    Store in corresponding hugeInt3
            if ((hugeInt1.intArray[i] + hugeInt2.intArray[i]) < 10)
            {
                hugeInt3.intArray[i]= 
                        hugeInt1.intArray[i] 
                        + hugeInt2.intArray[i];
                if (carryFlag==1)
                {
                   
                    hugeInt3.intArray[i]++;
                    if(hugeInt3.intArray[i]< 10)
                    {
                        carryFlag = 0;
                    }
                    else
                        hugeInt3.intArray[i]-=10;             
                }      
            }
            else
            {
                hugeInt3.intArray[i] = 
                        hugeInt1.intArray[i] 
                        + hugeInt2.intArray[i]
                        - 10;
                carryFlag = 1;
            }
            hugeInt3.numDigits++;
      } //end loop       
      return hugeInt3;
    }

 
    public static HugeInteger1 subtract(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
    {
        // Create hugeInt3
        HugeInteger1 hugeInt3 = new HugeInteger1();
        if(HugeInteger1.isGreaterThanOrEqualTo(hugeInt1, hugeInt2))
        {
            int maxSize;
            int carryFlag = 0;
      
            if(hugeInt1.numDigits < hugeInt2.numDigits)
                maxSize = hugeInt2.numDigits;
            else
                maxSize = hugeInt1.numDigits;
            // Loop 
            for (int i = 39; i >= 40-maxSize; i--)
            {
            //    Subtract hugeInt2 digit from  hugeInt1, 
            //    Store in corresponding hugeInt3
            // End
            //
            // return hugeInt3 

                if (hugeInt1.intArray[i] >= hugeInt2.intArray[i])
                {
                    if (carryFlag == 1)
                    {
                        hugeInt3.intArray[i]= (hugeInt1.intArray[i] - hugeInt2.intArray[i] - 1);
                        carryFlag = 0;
                        System.out.println("hereA");
                    }
                    else
                    {
                        System.out.printf("\n"+hugeInt1.intArray[i]+"-"+hugeInt2.intArray[i]+"\n");
                        hugeInt3.intArray[i]= (hugeInt1.intArray[i] - hugeInt2.intArray[i]);
                        System.out.println("hereB");
                        System.out.printf("\n"+hugeInt3.intArray[i]+"\n");
                    }
                }
                else
                {
                    System.out.printf("\n"+hugeInt1.intArray[i]+"-"+hugeInt2.intArray[i]+"\n");
                    hugeInt3.intArray[i] = 
                      (hugeInt1.intArray[i] 
                      - hugeInt2.intArray[i]
                      + 10);             
                    carryFlag = 1;
                    System.out.println("hereC");
                    System.out.printf("\n"+hugeInt3.intArray[i]+"\n");
                }
                hugeInt3.numDigits++;
            }// End loop
        }//end if
        return hugeInt3;
    }

  
    public static boolean isEqualTo(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
    {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is equal to
    // value represented by elements of hughInt2.intArray
        if (Arrays.equals(hugeInt1.intArray, hugeInt2.intArray))
            return true;
        return false;
    }

  
    public static boolean isNotEqualTo(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
    {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is not equal to
    // value represented by elements of hughInt2.intArray
        if (Arrays.equals(hugeInt1.intArray, hugeInt2.intArray))
            return false;
        return true;
  
    }

  public static boolean isGreaterThan(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
  {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is greater than 
    // value represented by elements of hughInt2.intArray
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) > 0)
            return true;
        return false;
  }
  
  public static boolean isLessThan(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
  {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is less than
    // value represented by elements of hughInt2.intArray
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) < 0)
            return true;
        return false;

  }
  
  public static boolean isGreaterThanOrEqualTo(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
  {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is greater than or equal to
    // value represented by elements of hughInt2.intArray
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) >= 0)
            return true;
        return false;
  
  }
  
   public static boolean isLessThanOrEqualTo(HugeInteger1 hugeInt1, HugeInteger1 hugeInt2)
  {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is greater than or equal to
    // value represented by elements of hughInt2.intArray
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) <= 0)
            return true;
        return false;
  }

   public static boolean isZero(HugeInteger1 hugeInt1 )
   {
    // return true if the value represented by 
    // elements of hugeInt1.intArray is 0 
        for(int i = 0; i < hugeInt1.intArray.length; i++ )
        {
            if(hugeInt1.intArray[i] != 0 )
                return false;
        }
        return true;
    }
  
    //method to return a string
    public String toString()
  {     
      String s = Arrays.toString(this.intArray).replaceAll("[\\,\\[\\]\\ ]", "");
      System.out.println(s);

     // return string representation of this object
      return s;
  }
}