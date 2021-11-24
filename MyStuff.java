/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystuff;

public class MyStuff 
{

    MyStuff(String n) 
    { 
        name = n; 
    } 
    
    String name;

    public static void main(String[] args) 
    {
        MyStuff m1 = new MyStuff("guitar");
        MyStuff m2 = new MyStuff("tv"); 
        //System.out.println(MyStuff.name);
        System.out.println(m1.name);
        System.out.println(m2.name);
        System.out.println(m2.equals(m1));
}
public boolean equals(MyStuff o) 
{
    String m = this.name;
    //if(m.name != null)
    
    if(name.equals(o.name))
    {
        return true;
    }
    return false;
}
}

