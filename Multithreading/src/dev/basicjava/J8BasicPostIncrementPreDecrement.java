package dev.basicjava;

public class J8BasicPostIncrementPreDecrement {
	public static void main(String[] args) {
        int x = 7;
        int y = 8;
        int z = x++ * --y; 
        System.out.println(z);
        System.out.println(x);
        System.out.println(y);
        
        
        whichResultsQ1();
    }
	
	static void whichResultsQ1() {
		int v = 25;
		Integer pre = v;
		Long pos = ++pre == 26 ? 5 : new Long(10);
		System.out.println(pos.intValue() - pre.intValue());
	}
}
