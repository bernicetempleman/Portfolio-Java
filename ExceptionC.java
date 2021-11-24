/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 7
Name:                       Bernice Templeman

Description: 11.16 (Catching Exceptions with Superclasses) 
Use inheritance to create 
an exception superclass (called ExceptionA) 
and exception subclasses ExceptionB and ExceptionC, 
where ExceptionB inherits from ExceptionA 
and ExceptionC inherits from ExceptionB. 
Write a program to demonstrate that the catch block for type ExceptionA 
catches exceptions of types ExceptionB and ExceptionC.
 */
package project.pkg7;

import project.pkg7.ExceptionB;

public class ExceptionC extends ExceptionB 
{    
    // no-argument constructor
    public ExceptionC()
    {
        super(); 
    } 

    // one-argument constructor
    public ExceptionC( String name )
    {
        super( name );   
    }   
}
