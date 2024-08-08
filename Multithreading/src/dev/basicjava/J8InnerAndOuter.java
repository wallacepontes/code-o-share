package dev.basicjava;

public class J8InnerAndOuter {

	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.accessOuter();
        
        outer.method();
        inner.accessVars();
        outer.method2();
	}

}

class OuterClass {
    private int outerVar = 10;
    private static int outerStaticVar = 20;
    private int var = 50;
    
    class InnerClass {
    	private int var = 60; // This shadows the outer class's 'var'
    	public int var2 = 12;
        public void accessOuter() {
        	//1. The inner class can access private variables of Outer Class
            System.out.println("Outer variable: " + outerVar);
            //2. The inner classes can access Outer Class's Static Variables and Methods:
            System.out.println("Outer static variable: " + outerStaticVar);
        }
        public void accessVars() {
            System.out.println("Inner class variable: " + var);
            System.out.println("Outer class variable: " + OuterClass.this.var);
        }
    }
    public void method() {
        final int localVar = 30;

        class InnerClass {
            public void accessLocal() {
            	//3. Access to Local Variables in Methods:
                System.out.println("Local variable: " + localVar);
            }
        }

        InnerClass inner = new InnerClass();
        inner.accessLocal();
        
        //4. Lambda Expressions and Effectively Final Variables:
        Runnable r = () -> {
            System.out.println("Local variable in lambda: " + localVar);
        };

        r.run();
    }
    public void method2() {
        InnerClass inner = new InnerClass();
        System.out.println(inner.var); // the outer can access private variables of the inner
        System.out.println(inner.var2); // the outer can access public variables of the inner 
    	
    }
}