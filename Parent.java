/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package child;

/**
 *
 * @author Bernice
 */
class Parent {
    public Parent() {
        System.out.println("Parent Constructor");
    }    
    static {
        System.out.println("Parent static block");    
    }    
    {
        System.out.println("Parent initialisation  block");
    }
}