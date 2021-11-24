import java.util.Arrays;
import java.util.Scanner;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0) {
            return -1;
        }
        //long milesPerHour = Math.round(kilometersPerHour / 1.609)
        //return milesPerHour;

        return Math.round(kilometersPerHour / 1.609);
    }
    public static void printConversion(double kilometersPerHour){

        if (kilometersPerHour <0 ) {
            System.out.println("Invalid Value");
        }
        else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + "km/h= " + milesPerHour + "mi/h");
        }
    }
    public class MegaBytesConverter {
        public static void printMegaBytesAndKiloBytes(int kiloBytes){
            if (kiloBytes < 0)
            {
                System.out.println("Invalid Value");
            }
            else
            {
                int remainder = kiloBytes % 1024;
                System.out.println( kiloBytes + " KB = " + (kiloBytes /1024 ) + " MB and " + remainder + " KB");
            }
        }
        public class BarkingDog {


            public static boolean shouldWakeUp (boolean barking, int hourOfDay){

                if (hourOfDay < 0 || hourOfDay>23)
                    return false;
                if (barking && (hourOfDay < 8 || hourOfDay>22 ))
                    return true;
                return false;}
        }

    }
    public class LeapYear {

        public static boolean isLeapYear(int year){
            if (year <1 || year > 9999)
                return false;
            if ((year % 4 )== 0)
            {
                if (((year % 100 )== 0) && ((year % 400 )== 0))
                    return true;
                else if ((year % 100 )== 0)
                    return false;
                return true;
            }
            return false;

        }
    }
    public class DecimalComparator{
        public static boolean areEqualByThreeDecimalPlaces(double firstNumbar, double secondNumber){

            if ((Math.round(firstNumber *1000)/1000)== (Math.round(secondNumber*1000))/1000)

                return true;
            return false;
        }

    }
    public class DecimalComparator{
        public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber){

            if (((int)(firstNumber *1000))== ((int)(secondNumber*1000)))

                return true;
            return false;
        }

    }public class DecimalComparator{
        public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber){

            if (((int)(firstNumber *1000))== ((int)(secondNumber*1000)))

                return true;
            return false;
        }

    }
    public class EqualSumChecker {

        public static boolean hasEqualSum( int firstNum, int secondNum, int thirdNum ){
            if (( firstNum + secondNum) == thirdNum)
                return true;
            return false;
        }

    }
    public class TeenNumberChecker {

        public static boolean hasTeen(int first, int second, int third){

            if (first >= 13 && first <=19 )
                return true;
            if (second >= 13 && second <=19 )
                return true;
            if (third >= 13 && third <=19 )
                return true;
            return false;
        }
        public static boolean isTeen (int first){
            if (first >= 13 && first <=19 )
                return true;
            return false;
        }
    }
    public class AreaCalculator {
        public static double area( double radius){
            if (radius < 0)
                return -1.0;
            return (radius*radius*Math.PI );

        }
        public static double area( double x, double y){
            if ((x < 0)||(y<0))
                return -1.0;
            return (x*y);

        }

    }
    public class MinutesToYearsDaysCalculator {
        // write your code here
        public static void printYearsAndDays(long minutes){
            if (minutes <0){
                System.out.println("Invalid Value");}
            else{
                System.out.println( minutes + " min = "+ (minutes/60/24/365 ) + " y and "+ ((minutes/60/24)%365) + " d");
            }

        }
    }
    public class IntEqualityPrinter {
        // write your code here
        public static void printEqual(int param1, int param2, int param3){
            if((param1 <0)||(param2< 0)||(param3 < 0))
                System.out.println("Invalid Value");
            else if((param1==param2)&& (param1 == param3))
                System.out.println("All numbers are equal");
            else if (( param1 != param2)&& (param1!=param3)&& (param2!=param3))
                System.out.println("All numbers are different");
            else
                System.out.println("Neither all are equal or different");

        }
    }
    public class PlayingCat {
        // write your code here
        public static boolean isCatPlaying(boolean summer, int temperature){
            if ((temperature <25) ||(temperature > 45))
                return false;
            if ((!summer)&& (temperature > 35))
                return false;
            return true;

        }
    }
    public class NumberInWord {
        // write your code here
        public static void printNumberInWord(int number){
            switch(number){
                case 0:
                    System.out.println("ZERO");
                    break;
                case 1:
                    System.out.println("ONE");
                    break;
                case 2:
                    System.out.println("TWO");
                    break;
                case 3:
                    System.out.println("THREE");
                    break;
                case 4:
                    System.out.println("FOUR");
                    break;
                case 5:
                    System.out.println("FIVE");
                    break;
                case 6:
                    System.out.println("SIX");
                    break;
                case 7:
                    System.out.println("SEVEN");
                    break;
                case 8:
                    System.out.println("EIGHT");
                    break;
                case 9:
                    System.out.println("NINE");
                    break;
                default:
                    System.out.println("OTHER");
                    break;
            }
        }
    }
    public class NumberOfDaysInMonth {
        // write your code here

        public static boolean isLeapYear(int year){
            if (year <1 || year > 9999)
                return false;
            if ((year % 4 )== 0)
            {
                if (((year % 100 )== 0) && ((year % 400 )== 0))
                    return true;
                else if ((year % 100 )== 0)
                    return false;
                return true;
            }
            return false;

        }
        public static int getDaysInMonth(int month, int year){
            if((month <1)||(month > 12))
                return -1;
            if ((year <1) || (year > 9999 ))
                return -1;
            int days = 29;
            switch (month){
                case 4:
                    days = 30;
                    break;
                case 6:
                    days =  30;
                    break;
                case 9:
                    days =  30;
                    break;
                case 11:
                    days =  30;
                    break;
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days =  31;
                    break;
                case 2:
                    if (isLeapYear(year)){
                        days =  29;
                        break;}
                    else
                        days =  28;
                    break;



            }
            return days;
        }
    }
    public class SumOddRange {



        public static boolean isOdd(int number){
            if (number <= 0)
                return false;

            if (number % 2 == 0)
                return false;

            return true;
        }

        public static int sumOdd(int start, int end){
            if ((start <=0) ||(end <=0))
                return  -1;
            if (start > end)
                return -1;
            int sum = 0;
            for (int i = start; i <= end; i++){
                if (isOdd(i)){
                    sum = sum +i;
                }
            }
            return (sum);
        }

    }
    public class NumberPalindrome {

        public static boolean isPalindrome(int number)
        {

            int num = number;
            int reverse=0;

            while(number != 0){
                int remainder = number % 10;
                reverse = reverse * 10 + remainder;
                number = number/10;
            }
            if (num == reverse)
                return true;
            return false;

            //


        }

    }
    public class FirstLastDigitSum {
        // write your code here
        public static int sumFirstAndLastDigit(int number){
            if (number <0)
                return -1;
            int num = number;
            int remainder = 0;
            int reverse = 0;
            int last = 0;
            int first = 0;
            if (number <10){
                first = number;
                last = number;
                return (first + last);
            }//if
            last = number % 10;
            number = number/10;
            if (number < 10)
                return (number + last);
            else{
                while(number >9){
                    remainder = number % 10;
                    number = number/10;
                }//while
                first = number;
            }

            return (first + last);
        }
    }
    public class EvenDigitSum {
        // write your code here
        public static int getEvenDigitSum (int number){
            if(number < 0)
                return -1;

            int num = number;
            int sum = 0;

            while(number >0){
                int remainder = number % 10;
                if ((remainder % 2)== 0)
                    sum = sum + remainder;
                number = number/10;
            }//while
            return sum;
        }
    }
    public class SharedDigit {
        // write your code here
        public static boolean hasSharedDigit(int number1, int number2){
            if ((number1 <10)|| (number1 > 99)||(number2 <10)|| (number2 > 99))
                return false;

            while(number1 >0){
                int remainder = number1 % 10;
                number1 = number1/10;

                while ( number2 > 0){
                    int remainder2 = number2 % 10;
                    if (remainder == remainder2)
                        return true;
                    if (number1 == remainder2)
                        return true;
                    number2 = number2/10;
                }//inner while
                // if (number1 == number2)
                //    return true;
            }//while
            return false;
        }
    }
    public class LastDigitChecker {
        // write your code here

        public static boolean isValid( int number){
            if ((number <10)|| (number > 1000))
                return false;
            return true;
        }
        public static boolean hasSameLastDigit(int number1, int number2, int number3){
            if (isValid(number1)&&isValid(number2)&& isValid(number3))
            {
                int num1 = number1 % 10;
                int num2 = number2 % 10;
                int num3 = number3 % 10;
                if ((num1 == num2)||(num1== num3)||(num2==num3))
                    return true;
                return false;

            }//not valid number
            else return false;
        }
    }
    public class GreatestCommonDivisor {
        // write your code here
        public static int getGreatestCommonDivisor(int first, int second){
            if ((first < 10) || (second <10))
                return -1;
            int max = first;
            if (first < second)
                max = second;
            if (first == second)
                return first;
            for(int i = max; i > 1; i-- ){
                if((first % i)== 0)
                {
                    if((second % i)==0)
                    {
                        return i;
                    }
                }

            }//for
            return 1;
        }
    }
    public class FactorPrinter {
        // write your code here
        public static void printFactors(int number){
            if (number < 1)
                System.out.println("Invalid Value");
            else{
                for(int i = 1; i <= number; i++){
                    if ((number % i)== 0)
                        System.out.println(i);
                }
            }
        }
    }
    public class PerfectNumber {
        // write your code here
        public static boolean isPerfectNumber(int number){
            if(number <1)
                return false;
            int sum = 0;
            for (int i = 1; i < number; i ++)
            {
                if((number % i)== 0)
                    sum = sum +i;
            }
            if (sum == number)
                return true;
            return false;
        }
    }
    public class NumberToWords {
        // write your code here
        public static void numberToWords(int number){
            if(number <0)
                System.out.println("Invalid Value");
            else {
                int num = number;
                if(num != 0){

                    int numLength = getDigitCount(number);
                    number = reverse(number);
                    int numLengthReverse = getDigitCount(number);


                    for(int i = numLengthReverse; i< numLength; i++){
                        System.out.println("Zero");
                    }//for

                    while(number >0 ){
                        int remainder = number % 10;
                        number = number/10;
                        switch(remainder){
                            case 0: System.out.println("Zero");
                                break;
                            case 1: System.out.println("One");
                                break;
                            case 2: System.out.println("Two");
                                break;
                            case 3: System.out.println("Three");
                                break;
                            case 4: System.out.println("Four");
                                break;
                            case 5: System.out.println("Five");
                                break;
                            case 6: System.out.println("Six");
                                break;
                            case 7: System.out.println("Seven");
                                break;
                            case 8: System.out.println("Eight");
                                break;
                            case 9: System.out.println("Nine");
                        }//switch

                    }//while
                }
                else if(num == 0)
                    System.out.println("Zero");

            }//else
        }//numberToWords

        public static int reverse(int number){
            int reverseNum = 0;
            boolean negative = false;
            if( number < 0)
            {
                negative = true;
                number = number* -1;
            }
            while(number >0){
                int remainder = number % 10;
                reverseNum= reverseNum *10+ remainder ;
                number = number / 10;
            }//while
            if (negative)
                return (reverseNum * -1);
            return reverseNum;
        }//reverse

        public static int getDigitCount(int number){
            if( number == 0)
                return 1;
            if(number < 0)
                return -1;
            int sum = 0;
            while(number >0)
            {
                number= number / 10;
                sum++;
            }//while
            return sum;
        }//getDigitCount
    }

    public class NumberToWords {
        // write your code here
        public static void numberToWords(int number){
            if(number <0)
                System.out.println("Invalid Value");
            else {
                int num = number;
                if(num != 0){

                    int numLength = getDigitCount(number);
                    number = reverse(number);
                    int numLengthReverse = getDigitCount(number);

                    while(number >0 ){
                        int remainder = number % 10;
                        number = number/10;
                        switch(remainder){
                            case 0: System.out.println("Zero");
                                break;
                            case 1: System.out.println("One");
                                break;
                            case 2: System.out.println("Two");
                                break;
                            case 3: System.out.println("Three");
                                break;
                            case 4: System.out.println("Four");
                                break;
                            case 5: System.out.println("Five");
                                break;
                            case 6: System.out.println("Six");
                                break;
                            case 7: System.out.println("Seven");
                                break;
                            case 8: System.out.println("Eight");
                                break;
                            case 9: System.out.println("Nine");
                        }//switch

                    }//while
                    for(int i = numLengthReverse; i< numLength; i++){
                        System.out.println("Zero");
                    }//for
                }
                else if(num == 0)
                    System.out.println("Zero");

            }//else
        }//numberToWords

        public static int reverse(int number){
            int reverseNum = 0;
            boolean negative = false;
            if( number < 0)
            {
                negative = true;
                number = number* -1;
            }
            while(number != 0){
                int remainder = number % 10;
                reverseNum= reverseNum *10+ remainder ;
                number = number / 10;
            }//while
            if (negative)
                return (reverseNum * -1);
            return reverseNum;
        }//reverse



        public static int getDigitCount(int number){
            if( number == 0)
                return 1;
            if(number < 0)
                return -1;
            int sum = 0;
            while(number >0)
            {
                number= number / 10;
                sum++;
            }//while
            return sum;
        }//getDigitCount
    }
    public class FlourPacker {
        // write your code here
        public static boolean canPack(int bigCount, int smallCount, int goal){

            if ((bigCount <0) || (smallCount < 0) || (goal < 0))
                return false;
            if ((bigCount * 5 + smallCount) < goal)
                return false;

            if (( bigCount * 5)>= goal){
                goal = goal - (goal/5*5);
                if (goal <= smallCount)
                    return true;
                return false;
            }
            return true;
        }
    }

    public class LargestPrime {
        // write your code here
        public static int getLargestPrime(int number)
        {
            // Initialize the maximum prime
            // factor variable with the
            // lowest one
            if(number <= 1)
                return -1;
            int maxPrime = -1;

            // Print the number of 2s
            // that divide n
            while (number % 2 == 0) {
                maxPrime = 2;

                // equivalent to n /= 2
                number >>= 1;
            }

            // n must be odd at this point,
            // thus skip the even numbers
            // and iterate only for odd
            // integers
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                while (number % i == 0) {
                    maxPrime = i;
                    number = number / i;
                }
            }

            // This condition is to handle
            // the case when n is a prime
            // number greater than 2
            if (number > 2)
                maxPrime = number;

            return maxPrime;
        }//method
    }
    public class DiagonalStar {
        public static void printSquareStar(int number){
            if(number < 5) System.out.println("Invalid Value");
            else{
                for (int row = 0; row <number; row++){
                    for (int column=0; column<number; column++){
                        if(row==0 || row==number-1 || column==0 || column==number-1 || column==row || column==number-1-row)
                            System.out.print("*");
                        else System.out.print(" ");
                    }
                    System.out.println("");
                }
                public class PaintJob {
                    // write your code here
                    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){

                        if((width <=0) || (height <=0)|| (areaPerBucket <=0)|| (extraBuckets < 0))
                            return -1;
                        return (int) Math.ceil((width*height-(areaPerBucket*extraBuckets))/areaPerBucket);
                    }
                    public static int getBucketCount(double width, double height, double areaPerBucket){

                        if((width <=0) || (height <=0)|| (areaPerBucket <=0))
                            return -1;
                        return (int) Math.ceil(width*height/areaPerBucket);
                    }
                    public static int getBucketCount(double area, double areaPerBucket){

                        if((area <=0) || (areaPerBucket <=0))
                            return -1;
                        return (area<=0 || areaPerBucket<=0) ? -1 : (int) Math.ceil(area/areaPerBucket);
                    }
                }
            }
        }

    }
    public class SimpleCalculator {
        // write your code here
        private double firstNumber;
        private double secondNumber;

        public  double getFirstNumber(){
            return firstNumber;
        }
        public  double getSecondNumber(){
            return secondNumber;
        }
        public  void setFirstNumber(double number){
            this.firstNumber = number;
        }
        public  void setSecondNumber(double number){
            this.secondNumber =  number;
        }
        public  double getAdditionResult(){
            return firstNumber +  secondNumber;
        }


        public double getDivisionResult(){
            if ( secondNumber == 0)
                return 0;
            return firstNumber /secondNumber ;
        }
        public  double getSubtractionResult(){
            return firstNumber - secondNumber ;
        }
        public double getMultiplicationResult(){
            return firstNumber * secondNumber;
        }
    }
    public class Person {
        // write your code here
        private String firstName;
        private String lastName;
        private int age;

        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public int getAge(){
            return age;
        }
        public void setFirstName(String name){
            this.firstName = name;
        }
        public void setLastName(String name){
            this.lastName = name;
        }
        public void setAge(int Age){
            if((Age < 0)|| (Age > 100))
                this.age = 0;
            else
                this.age = Age;
        }
        public boolean isTeen(){
            if((age> 12)&&(age< 20))
                return true;
            return false;
        }
        public String getFullName(){

            if(firstName.isEmpty() && lastName.isEmpty()) return "";
            if(firstName.isEmpty()) return lastName;
            if(lastName.isEmpty()) return firstName;
            return firstName + " " + lastName;
            //return (firstName.isEmpty() && lastName.isEmpty()) ? "" : (firstName.isEmpty()) ? lastName : (lastName.isEmpty()) ? firstName : firstName + " " + lastName; // ternary operator

        }


    }
    public class Wall {
        // write your code here

        private double width;
        private double height;

        public Wall(){

        }
        public Wall(double width, double height){
            if (width < 0)
                this.width = 0;
            else
                this.width = width;
            if (height < 0)
                this.height = 0;
            else
                this.height = height;
        }

        public double getWidth(){
            return width;
        }
        public double getHeight(){
            return height;
        }
        public void setWidth(double width){
            if (width < 0)
                this.width = 0;
            else
                this.width = width;
        }
        public void setHeight(double height){
            if (height < 0)
                this.height = 0;
            else
                this.height =  height;
        }
        public double getArea(){
            return height* width;
        }
    }
    public class Point {
        // write your code here
        private int x;
        private int y;

        public Point(){

        }
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
        public double distance(){
            return Math.sqrt( (getX() - 0.0) * ( getX() - 0)  + (getY() - 0) * (getY() - 0));
        }
        public double distance(int x, int y){
            return Math.sqrt( (getX() - 0.0) * ( getX() - 0)  + (getY() - 0) * (getY() - 0));
        }
        public double distance(Point xy){

            return Math.sqrt( (getX() - xy.getX()) * ( getX() - xy.getX())  + (getY() - xy.getY() ) * (getY() - xy.getY()));
        }
    }
    public Floor(double width, double length)
    {
        if( width < 0)
            this.width = 0;
        else
            this.width = width;
        if (length < 0)
            this.length = 0;
        else
            this.length = length;
    }//constructor

    public double getArea()
    {
        return (this.width * this.length);
    }//getArea

}//class floor

public class Carpet
{

    private double cost;

    public Carpet(double cost)
    {
        if (cost <0)
            this.cost = 0;
        else
            this.cost = cost;
    }//cost constructor

    public double getCost()
    {
        return cost;
    }//getcost
}

public class Calculator
{
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet)
    {
        this.floor = floor;
        this.carpet =  carpet;

    }

    public double getTotalCost()
    {
        return (floor.getArea() * carpet.getCost());
    }
}
public class ComplexNumber {
    // write your code here

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal(){
        return real;
    }
    public double getImaginary(){
        return imaginary;
    }
    public void add (double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }
    public void add (ComplexNumber complexNumber){
        add(complexNumber.getReal(), complexNumber.getImaginary());
    }
    public void subtract (double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }
    public void subtract  (ComplexNumber complexNumber)
    {
        subtract(complexNumber.getReal(), complexNumber.getImaginary());

    }
}
public class Circle {
    // write your code here
    private double radius;

    public Circle (double radius){
        if (radius < 0)
            this.radius = 0;
        else
            this.radius = radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public double getArea(){
        return(radius * radius * Math.PI);
    }
}
public class Cylinder extends Circle {
    // write your code here
    private double height;

    public Cylinder(double radius, double height){
        super(radius);
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }}
    public double getVolume() {
        return getArea() * height;
    }

    public double getHeight() {
        return height;
    }

}
public class Rectangle {
    // write your code here
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if(width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }

        if(length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
    }

    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }

    public double getArea(){
        return this.width * this.length;
    }
}
public class Cuboid extends Rectangle {
    // write your code here
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);

        if(height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * this.height;
    }
}
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer( int tonerLevel, boolean duplex){
        if((tonerLevel <= -1  )||(tonerLevel>100))
            this.tonerLevel = -1;
        else
            this.tonerLevel = tonerLevel;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }
    public int addToner(int tonerAmount){
        if ((tonerAmount <=0)||(tonerAmount> 100))
            return -1;
        else
        if((tonerLevel+tonerAmount)> 100)
            return -1;
        else
            tonerLevel = tonerLevel+tonerAmount;
        return tonerLevel;
    }
    public int printPages(int pages){
        int pagesToPrint = pages;
        if (duplex){
            pagesToPrint = (pages/2) + (pages%2);
        }
        return pagesToPrint;
    }
    public int getPagesPrinted(){
        return pagesPrinted;
    }
}
//arrays
import java.util.Scanner;
public class MinimumElement {
    // write code here
    //private static Scanner scanner = new Scanner(System.in);
    private static int readInteger()
    {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();
        return count;
    }

    private static int[] readElements(int count)
    {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[count];
        for(int i=0; i<array.length; i++){
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;

        }
        return array;
    }
    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++){
            int value =  array[i];
            if(value <min){
                min = value;
            }
        }
        return min;
    }
    //reverse array
    import java.util.Arrays;
    public class ReverseArray {
        // write code here

        private static void  reverse(int[] array){
            System.out.println("Array = " + Arrays.toString(array));
            int max = array.length- 1;
            int halfLength = array.length/2;
            for(int i = 0; i < halfLength; i++){
                int temp = array[i];
                array[i] = array[max-i];
                array[max-i] = temp;
            }
            System.out.println("Reversed Array = " + Arrays.toString(array));
        }
    }
}

}
