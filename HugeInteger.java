/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 1 – 8.16 pg. 358
Name:                       Bernice Templeman

8.16 (Huge Integer Class) 
Create a class HugeInteger which uses a 40-element array of digits 
to store integers as large as 40 digits each. 

Provide methods 
* parse, 
* toString, 
* add 
* subtract. 

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
* multiply, 
* divide and 
* remainder.

[Note: Primitive boolean values can be output as 
the word “true” or the word “false” with format specifier %b.]

The following assumptions are acceptable.
    "HugeInteger" class only represent positive numbers
    User input is valid (i.e. assume only valid numeric values are entered)
 */

package hugeintegertest;

import java.util.Arrays;

// HugeInteger class 
public class HugeInteger 
{
    private int[] intArray;     // reference to int intArray
    private int numDigits;      // stores the number of digits in intArray

    // no-arg constructor
    public HugeInteger()
    {
        intArray = new int[40];
        numDigits = 0;
    }
    
    // 1 arg constructor receives a String of positive digits <= 40 characters
    public HugeInteger(String s)
    {
        intArray = new int[40]; // allocate array
        numDigits = 0;          // initialize numDigits to 0
        this.parse(s);          // call parse(s) to set intArray & numDigits
    }

    // getNumDigits method returns the number of digits in a HugeInteger
    public int getNumDigits() {
        return numDigits;
    }
    
    // setHugeInt method sets a HugeInteger
    public void setHugeInt(String s)
    {
        for(int i = 0; i <40; i++)
        {
            intArray[i] = 0;
        }
        numDigits = 0;
        this.parse(s);
    }
  
    /* parse method to parse string
    Method parse should receive a String, 
    extract each digit using method charAt and 
    place the integer equivalent of each digit into the integer array.
    */
    public void parse(String s)
    {
        int offset = 40 - s.length(); //offset is the maxsize(40) - length of string
        
        // loop to Add each digit to the array
        for(int i = 0; i < s.length(); i++)
        {
            // fill array so it has leading zeros (right justified)
            intArray[ i + offset] = ((int) s.charAt(i)) - 48; // 48 is the ASCII difference
            numDigits++; 
        }
        removeLeadingZeros(); // call function to remove any leading zeros from the numDigits
    }
    
    // method removes leading zeros from numDigits
    private void removeLeadingZeros()
    {
        //remove leading zeros
        for(int i = 40-numDigits; i < 40; i++)
        {
            if (intArray[i]==0)
                numDigits--;
        }
    }
    
    // add method: adds 2 HugeIntegers
    // Add digits from hugeInt1 and hugeInt2,
    // Store in corresponding hugeInt3
    public static HugeInteger add(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        // Create hugeInt3
        HugeInteger hugeInt3 = new HugeInteger();
        
        //set maxSize to the largest numDigits
        int maxSize = hugeInt1.numDigits;
        if (hugeInt1.numDigits< hugeInt2.numDigits)
            maxSize = hugeInt2.numDigits;
        
        int carryFlag = 0; //initialize carry flag
        
        // Loop  through array to add the numbers
        for (int i = 39; i >= 39-(maxSize-1 ); i--)
        {
            //check if there will be no carry (less than 10)
            if ((hugeInt1.intArray[i] + hugeInt2.intArray[i]) < 10)
            {
                //add the digits and store in hugeInt3
                hugeInt3.intArray[i]=    
                    hugeInt1.intArray[i] + hugeInt2.intArray[i];
                //check for previous carry
                if (carryFlag==1) 
                { 
                    // increment by 1
                    hugeInt3.intArray[i]++;
                    //check if no new carry after adding 1
                    if(hugeInt3.intArray[i]< 10)
                    {
                        carryFlag = 0;
                    }
                    else //there is a new carry after adding old carry
                    {
                        carryFlag = 1;
                        hugeInt3.intArray[i]-=10;  
                    }
                }// end if carry flag      
            }//end if no carry
            else // there will be a carry
            {
                //check for previous carry
                if (carryFlag == 1)
                {
                    hugeInt3.intArray[i]++;        
                }
                // add the digits and subtract 10 
                hugeInt3.intArray[i] = 
                    hugeInt3.intArray[i]
                    + hugeInt1.intArray[i] 
                    + hugeInt2.intArray[i]
                    - 10;
                carryFlag = 1;
            } //end else carry
            //increment the number of digits
            hugeInt3.numDigits++;
            
            //check if there is a carry after the MaxSize
            if(carryFlag == 1 && i == 40-maxSize && i >0 )
            {
                // set the next digit to 1 
                hugeInt3.intArray[i-1] = 1; 
                hugeInt3.numDigits++; 
            }       
      } //end loop       
      return hugeInt3;
    }// end method add
 
    // subtract method subtracts 2 HugeIntegers
    // Subtract hugeInt2 digit from  hugeInt1, 
    // Store in corresponding hugeInt3
    public static HugeInteger subtract(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        // Create hugeInt3
        HugeInteger hugeInt3 = new HugeInteger();
        
        // check if the result will be positive or 0
        if(HugeInteger.isGreaterThanOrEqualTo(hugeInt1, hugeInt2))
        {
            int maxSize;
            int carryFlag = 0;
            
            // set maxSize to largest numDigits
            if(hugeInt1.numDigits < hugeInt2.numDigits)
                maxSize = hugeInt2.numDigits;
            else
                maxSize = hugeInt1.numDigits;
            
            // Loop through digits
            for (int i = 39; i >= 40-maxSize; i--)
            {
                if (hugeInt1.intArray[i] >= hugeInt2.intArray[i])
                {
                    if (carryFlag == 1)
                    {
                        hugeInt3.intArray[i] = 
                        (hugeInt1.intArray[i] - hugeInt2.intArray[i] - 1);
                        carryFlag = 0;
                    }
                    else// no carry
                    {
                        hugeInt3.intArray[i] = 
                        (hugeInt1.intArray[i] - hugeInt2.intArray[i]);
                    }
                }
                else // hugeInt2.intArray[i] > hugeInt1.intArray[i]
                {
                    hugeInt3.intArray[i] = 
                      (hugeInt1.intArray[i] 
                      - hugeInt2.intArray[i]
                      + 10);             
                    carryFlag = 1;
                }
                hugeInt3.numDigits++;
            }// End loop
            hugeInt3.removeLeadingZeros();
        }//end if
        return hugeInt3;
    }//end subtract
  
    // isEqualTo method return true if the value represented by 
    // elements of hugeInt1.intArray is equal to
    // value represented by elements of hughInt2.intArray   
    public static boolean isEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (Arrays.equals(hugeInt1.intArray, hugeInt2.intArray))
            return true;
        return false;
    }
  
    // isNotEqualTo method return true if the value represented by 
    // elements of hugeInt1.intArray is not equal to
    // value represented by elements of hughInt2.intArray
    public static boolean isNotEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (Arrays.equals(hugeInt1.intArray, hugeInt2.intArray))
            return false;
        return true;
    }

    // isGreaterThan method return true if the value represented by 
    // elements of hugeInt1.intArray is greater than 
    // value represented by elements of hughInt2.intArray
    public static boolean isGreaterThan(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) > 0)
            return true;
        return false;
    }
  
    // isLessThan method returns true if the value represented by 
    // elements of hugeInt1.intArray is less than
    // value represented by elements of hughInt2.intArray
    public static boolean isLessThan(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) < 0)
            return true;
        return false;
    }
  
    // isGreaterThanOrEqualTo method return true if the value represented by 
    // elements of hugeInt1.intArray is greater than or equal to
    // value represented by elements of hughInt2.intArray
    public static boolean isGreaterThanOrEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) >= 0)
            return true;
        return false; 
    }
  
    // isLessThanOrEqualTo method return true if the value represented by 
    // elements of hugeInt1.intArray is greater than or equal to
    // value represented by elements of hughInt2.intArray
    public static boolean isLessThanOrEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2)
    {
        if (hugeInt1.toString().compareTo(hugeInt2.toString()) <= 0)
            return true;
        return false;
    }

    // isZero method returns true if the value represented by 
    // elements of hugeInt1.intArray is 0 
    public static boolean isZero(HugeInteger hugeInt1 )
    {
        for(int i = 0; i < hugeInt1.intArray.length; i++ )
        {
            if(hugeInt1.intArray[i] != 0 )
                return false;
        }
        return true;
    }
  
    //toString method to return a string
    public String toString()
    {     
        String s = Arrays.toString(this.intArray).replaceAll("[\\,\\[\\]\\ ]", "");
        // return string representation of this object
        return s;
    }
}//end class
