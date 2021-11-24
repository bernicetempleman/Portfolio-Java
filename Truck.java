/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphicapp;

/**
 *
 * @author Bernice
 */
public class Truck extends Vehicle
{

    public Truck() {
    }
    
    
    @Override
    public void drive()
    {
        System.out.println("driving a truck ");
    }
}
