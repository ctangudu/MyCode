/**
 * 
 */
package my.java;

import my.java.MyOuter.MyInnerCls;

/**
 * @author Chaitanya
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyOuter outer = new MyOuter();
		MyInnerCls innerCls = outer.new MyInnerCls();
	}

}
