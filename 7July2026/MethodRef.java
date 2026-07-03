
interface B {
    void m1();
}

class A {
    public void test() {
        System.out.println("demo");
    }
}

public class MethodRef {
    public static void main(String[] args) {

        A a = new A();

        B b = a::test;   // Method Reference

        b.m1();
    }
}

//contructor ref using new operator
// lambda can be used for verifying before login
//method ref is more suggested than lambda 
