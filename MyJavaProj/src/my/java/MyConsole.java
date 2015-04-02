/**
 * 
 */
package my.java;

import java.io.Console;

/**
 * @author Chaitanya
 *
 */
public class MyConsole {
public static void main(String[] args) {
	Console console = System.console();
	if(console == null){
		System.out.println("Console is null");
		return;
	}
	String readLine = console.readLine("enter", null);

}
	/**
	 * 
	 */
	public MyConsole() {
	}

}
