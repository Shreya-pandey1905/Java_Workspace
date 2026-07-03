
abstract  class Emp{
    public Emp(int x){
     x=10;
        System.out.println(x);
    }
}

class Manager  extends Emp{

    public Manager(int x) {
        super(x);
    }
}



public class Abstractclasses {

    public static void main(String[] args){

    }
}

// you should also wide the scope after overrifing not narrow it like in interfaces and abstrats