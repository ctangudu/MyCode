/**
 * 
 */
package my.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 929284
 *
 */
public class MyLoopsClass {

	final static int x1 = 2;
	final static int x2 = 4;
	
	private String world;
	
	MyLoopsClass(String world){
		this.world = world;
	}
	
	public static void main(String[] args) {

		int temp = 0;
//		here:
//		for (int i = 0; i < 7; i++) {
//			here:
//			for (int j = 0, k =0; j < 4; j++) {
//				if(j == 2){
//					break here;
//				}
//				System.out.println("Value of j "+j);
//			}
//			System.out.println("Value of i "+i);
//		}
		
//		int x4 = 4;
//		String s1  = "test";
//		
//		switch (x4) {
//		case x2: System.out.println("yes1");
//		default:System.out.println("default");
//		case x1: System.out.println("yes2");
//		}
//		boolean b1 = true;
//		boolean b2 = false;
//		System.out.println(b1^b2);
		
//		MyLoopsClass cls1 = new MyLoopsClass("yes");
//		MyLoopsClass cls2 = new MyLoopsClass("yes");
//		if(cls1.equals(cls2)){
//			System.out.println(cls1 == cls2);
//		}
		
		String str1 = "test";
		String str2 = "test";// new String("test");
		System.out.println("equals "+str1.equals(str2));
		System.out.println(":: "+str1 == str2);
		
		List<String> list = new ArrayList<String>();
		list.add(null);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(((MyLoopsClass)obj).world == world){
			System.out.println("Equals ");
			return true;
		}else{
			System.out.println("Not equals ");
			return false;
		}
	}
}
