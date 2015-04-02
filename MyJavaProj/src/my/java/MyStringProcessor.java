/**
 * 
 */
package my.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chaitanya
 *
 */
public class MyStringProcessor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String searchString = "123 abc 098 770";
		Pattern compile = Pattern.compile("\\d{3}{ ,\\S}");
		System.out.println("Pattern compiled "+compile);
		Matcher matcher = compile.matcher(searchString);
		while(matcher.find()){
			System.out.print(matcher.start()+" ");
		}
	}
}