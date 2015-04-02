/**
 * 
 */
package my.java;

/**
 * @author Chaitanya
 *
 */
public class MyExceptionHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		try{
			m1();
			m2();
		} catch(Exception e){
			System.out.println("exception in main");
		}

	}

	private static void m2() throws Exception{
		try{
			throw new Exception();
		}catch(Exception e){
			System.out.println("m2 exceptin");
		}
		
	}

	private static void m1() throws Exception{
		try{
			throw new Exception();
		}catch(Exception e){
			System.out.println("m1 exception");
		}
		
	}

}
