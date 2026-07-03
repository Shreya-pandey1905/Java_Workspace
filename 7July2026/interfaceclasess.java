interface A {
	
void test();
	
}

class B implements A {
	
	@Override
	public void test(){
		System.out.println("demo ");
	}
}

class interfaceclasess {
	 public static void main(String[] args){
		// lamda use kar rhe hai idhar jo B class ke similar hai 
		 A ref = () ->  System.out.println("demo ");
		 ref.test();
		 
	 }
}