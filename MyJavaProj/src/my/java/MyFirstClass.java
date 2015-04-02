package my.java;

public class MyFirstClass {
	public static void main(String[] args){
//		System.out.println("Yahoo my first class");
//		Parent parent = new Parent();
//		Child p2 = (Child)parent;
//		
//		parent.parentMethod();
//		p2.childMethod();
		
//		Upper u = new Upper();
//		String s = u.go();
//		Mid m = (Mid)u;
//		System.out.println("Yes");
				
	}
}

class A{
	void goA(){
		System.out.println("Go in A");
	}
}

class B extends A{
	void goB(){
		System.out.println("Go in B");
	}
}


class Upper{
	String go(){
		return "hi";
	}
}

class Mid extends Upper{
	
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

