public class Hi
{
static String randomString = "string to print";
static final double PINUM = 3.141529;

	public static void main(String[] args)
	{
	System.out.println(randomString);
	System.out.println(PINUM);
	
	int intergerOne = 22;
	int intergerTwo = intergerOne +1;
	System.out.println(intergerTwo);
	
	byte bigByte = 127;
	short bigShort = 32767;
	int bigInt = 21000000;
	long bigLong = 9220000000000000000L;
	float bigFloat = 3.14F;
	double bigDouble = 3.14823794872734872347923748;
	
	System.out.println(Float.MAX_VALUE);
	System.out.println(Double.MAX_VALUE);
	
	boolean trueOrFalse = true;
	
	char randomChar = 66;
	
	char anotherCar ='A';
	
	char escapedChars = '\\';
	
	String randomString = "I'm a random stirng";
	String anotherString = "another";
	String andAnotherString = randomString+ ' ' + anotherString;
	
	String byteString = Byte.toString(bigByte);
	String shortString = Short.toString(bigShort);
	String intString = Integer.toString(bigInt);
	String longString = Long.toString(bigLong);
	String floatString = Double.toString(bigFloat);
	String booleanString = Boolean.toString(trueOrFalse);
	
	double aDoubleValue = 3.14546466464;
	int doubleToInt = (int) aDoubleValue;
	System.out.println("caste");
	System.out.println(aDoubleValue);
	System.out.println(doubleToInt);
	//loose info
	
	
	// 
	int stringToInt = Integer.parseInt(intString);
	System.out.println(stringToInt);
	
	System.out.println(andAnotherString);
	System.out.println(bigByte);
	
	}
	}