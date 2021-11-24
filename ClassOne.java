public class ClassOne {

 int id;

 

 public int getId(){ return id;}

 

 public void setId(int id) { this.id = id;}

 

 public static void main (String[] args){

   ClassOne c1 = new ClassOne();

   c1.setId(25);

   System.out.println(c1.getId());

 }

}

 