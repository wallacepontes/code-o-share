package dev.basicjava;

public class J8BasicPostIncrementPreDecrement {
	public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = x++ * --y;
        System.out.println(z);
        whichResultsQ1();
    }
	
	static void whichResultsQ1() {
		int v = 25;
		Integer pre = v;
		Long pos = ++pre == 26 ? 5 : new Long(10);
		System.out.println(pos.intValue() - pre.intValue());
	}
}
