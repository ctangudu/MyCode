package my.java;

public class MyFirstClass {
	public static void main(String[] args){
		System.out.println("Yahoo my first class");
		Parent parent = new Parent();
		Child p2 = new Child();
		parent.parentMethod();
		p2.childMethod();
	}
}

class Parent{
	void parentMethod(){
		System.out.println("Parent method");
	}
}  

class Child extends Parent{
	void childMethod(){
		System.out.println("Child method");
	}
}

