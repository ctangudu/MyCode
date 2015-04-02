/**
 * 
 */
package my.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Chaitanya
 *
 */
public class MyDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ctangudu";
		String user = "ctangudu";
		String pwd = "ctangudu";
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement statement = conn.createStatement();
			String query = "select * from Customer";
			ResultSet results = statement.executeQuery(query);
			if(results!= null){
				while (results.next()) {
					System.out.print(results.getInt("CustomerID") +" ");
					System.out.print(results.getString("FirstName")+" ");
					System.out.print(results.getString("LastName")+" ");
					System.out.print(results.getString("Email")+" ");
					System.out.println(results.getInt("Phone")+" ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
