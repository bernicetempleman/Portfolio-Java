/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingchainedexceptions.pkg7;

/**
 *
 * @author Bernice
 */
public class UsingChainedExceptions7 {

   // Fig. 11.7: UsingChainedExceptions.java
// Chained exceptions.


   public static void main(String[] args)
   {
      try 
      { 
         method1(); 
      } 
      catch (Exception exception) // exceptions thrown from method1
      { 
         exception.printStackTrace();
      } 
   } 

   // call method2; throw exceptions back to main
   public static void method1() throws Exception
   {
      try 
      { 
         method2(); 
      }
      catch (Exception exception) // exception thrown from method2
      {
         throw new Exception("Exception thrown in method1", exception);
      }
   } // end method method1

   // call method3; throw exceptions back to method1
   public static void method2() throws Exception
   {
      try 
      { 
         method3(); 
      } 
      catch (Exception exception) // exception thrown from method3
      {
         throw new Exception("Exception thrown in method2", exception);
      } 
   } // end method method2

   // throw Exception back to method2
   public static void method3() throws Exception
   {
      throw new Exception("Exception thrown in method3");
   } 
} // end class UsingChainedExceptions
