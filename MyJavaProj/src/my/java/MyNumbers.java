/**
 * 
 */
package my.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaitanya
 *
 */
public class MyNumbers {
	
	public static void main(String[] args) {
	new MyNumbers();
	}

	/**
	 * 
	 */
	public MyNumbers() {
		double testNum = 1_00_00_0.5_5;
//		System.out.println("value is "+testNum);
		
		String string = "beekeeper";
		string = string.concat("test");
//		System.out.println(string);
		
		StringBuilder strBlder = new StringBuilder("0123456789");
//		strBlder.append("yahoo");
		strBlder.delete(2, 6);
//		strBlder.insert(3, "google");
		
		List<String> test = new ArrayList<String>(2);
		test.add("0");
		test.add(1, "1");
		System.out.println(test.size());
//		System.out.println(strBlder);
		
		
	}

}
