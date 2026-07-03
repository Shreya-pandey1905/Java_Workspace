
class Emp{

int id;
String name ;
 double sal  ;
 String dept ;




}

public class Main3 {
	
	 public void add(int... x){
		 int sum=0;
		 for (int i:x){
			 sum = sum+i;
			 
		 }
		 System.out.println(sum);
		 
	 
 }

    public static void main(String [] args){
	
	
	Main3 m = new Main3();

	m.add(3,6,8);

    }
}
