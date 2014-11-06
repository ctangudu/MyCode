/**
 * 
 */
package my.java;

/**
 * @author 929284
 *
 */
public class MyLoopsClass {

	public static void main(String[] args) {

		int temp = 0;
//		here:
		for (int i = 0; i < 7; i++) {
			here:
			for (int j = 0, k =0; j < 4; j++) {
				if(j == 2){
					break here;
				}
				System.out.println("Value of j "+j);
			}
			System.out.println("Value of i "+i);
		}
	}
}
