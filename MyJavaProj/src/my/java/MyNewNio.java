/**
 * 
 */
package my.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Chaitanya
 *
 */
public class MyNewNio {

	/**
	 * 
	 */
	public MyNewNio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path path = Paths.get("testDir", "test.txt");
		try {
			Files.createDirectories(path);
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
