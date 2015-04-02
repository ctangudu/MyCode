/**
 * 
 */
package my.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chaitanya
 *
 */
public class MyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File myDir = new File("mydir");
		boolean exists = myDir.mkdir();
		if(exists){
			System.out.println("deleting and recreating directory");
			myDir.delete();
			myDir.mkdir();
//			File newDir = new File("newDir");
//			myDir.renameTo(newDir);
		}
		File file = new File(myDir,"test.txt");
		boolean isCreated = false;
		try {
			boolean delete = true;
			if (file.exists()) {
				System.out.println("File exists");
				System.out.println(file.getAbsolutePath());
				delete = file.delete();
			}
			if (delete) {
				isCreated = file.createNewFile();
//				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(file);
				pw.print("this is first line\nsecond line\nthird line");
				pw.flush();
				pw.close();
			}

			if (isCreated) {
				System.out.println("File created");
			}
			
			BufferedReader bfr = new BufferedReader(new FileReader(file));
			String str = null;
			while ((str = bfr.readLine())!=null) {
				System.out.println(str);
			}
			
			for (String string : myDir.list()) {
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
