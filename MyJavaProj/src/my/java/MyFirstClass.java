package my.java;

public class MyFirstClass {
	public static void main(){
		System.out.println("Yahoo my first class");
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
	
}

