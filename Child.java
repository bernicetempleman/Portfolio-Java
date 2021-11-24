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

public class Child extends Parent {    
    {
        System.out.println("Child initialisation block");
    }
    static {
        System.out.println("Child static block");
    }

    public Child() {
        System.out.println("Child Constructor");
    }    
    public static void main(String[] args) {
        new Child();    
    }
}