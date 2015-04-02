/**
 * 
 */
package my.java;

/**
 * @author Chaitanya
 *
 */
class MySecondClass2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new Horse();
		Horse b = new Horse();
		try {
			a.eat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.eat();
	}
}

class Animal {
	void eat() throws Exception{
		System.out.println("Eat food");
	}
}

class Horse extends Animal{
	public void eat(){
		System.out.println("Eat grass");
	}
}

abstract public class MySecondClass{
	
}

interface testing{};
