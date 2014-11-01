package my.java;

public class OverloadCls {

	public static void main(String[] args) {
		Adder adder = new Adder();
		System.out.println(adder.addThem(10, 20));
		System.out.println(adder.addThem(1000000000, 200));
	}
}

class Adder {

	int addThem(int x, int y) {
		System.out.println("int method");
		return x + y;
	}
	
	double addThem(double x, double y){
		System.out.println("double method");
		return x+y;
	}
}
