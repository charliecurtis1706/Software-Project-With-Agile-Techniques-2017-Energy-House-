import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sun.misc.BASE64Encoder;

public class Model {
        static boolean successfulLogin = false; 
        static String userNo = null;
}

 class Login {
		private static Connection connection = null;
		static Statement statement;
		ResultSet resultSet;
		String username;
		String password;
		public Login(String username, String password)
		{
			this.username = username;
			this.password = password;
			loadMySQLDriver();
			setUpConnection();
			signIntoApplication();
		}
	
		public static Connection getConn() throws Exception {
		    if(connection == null){
		    Class.forName("org.sqlite.JDBC").newInstance();
		    connection = DriverManager.getConnection("jdbc:sqlite:database.db");
		    }
		    return connection;
		    }
		
		public Login() //no parameter Constructor.
		{
			loadMySQLDriver();
			setUpConnection();
		}
		
		private static String encryptPassword(String passwordToEncrypt,String algorithmToBeUsed, String encoding)
		{
			MessageDigest messageDigest = null;
			String hashValue = null;
			try
			{
				messageDigest = MessageDigest.getInstance(algorithmToBeUsed);
				messageDigest.update(passwordToEncrypt.getBytes(encoding));
				byte rawByte[] = messageDigest.digest();
				hashValue = (new BASE64Encoder()).encode(rawByte);
			}
			catch(NoSuchAlgorithmException ex)
			{
				System.out.println("Unknown Algorithm.");
			}
			catch(UnsupportedEncodingException ex)
			{
				System.out.println("Unknown Encoding.");
			}
			return hashValue;
		}
		
		public void loadMySQLDriver()
		{
			try{
			getConn();
			System.out.println("Load Success");
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Load Unsuccessful");
			}
		}
		
		public void signIntoApplication()
		{
			try
			{
			String encryptedPassword = encryptPassword(password,"SHA-1","UTF-16");// What the user types in as password.
			resultSet = statement.executeQuery("SELECT * FROM users WHERE username='"+username+"'"+ "AND password='"+encryptedPassword+"'"); //username and password placeholders.
			if(resultSet.next() != false)
			{	
				Model.successfulLogin = true;
			}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Load Unsuccessful");
			}
		}
		
		public void addToUserTable(String username, String password)
		{
			try{
				PreparedStatement preparedStatement = connection.prepareStatement(
			            "insert into users values (null,?, ?);");
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, encryptPassword(password,"SHA-1","UTF-16"));
				preparedStatement.addBatch();
				connection.setAutoCommit(false);
				preparedStatement.executeBatch();
			    connection.setAutoCommit(true);
			   // Model.userNo = 
			System.out.println("Added Success");
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				System.out.println("Add Unsuccessful");
			}
		}
		
		public void setUpConnection()	
		{
			try
			{
				statement = connection.createStatement();
				if(statement.executeQuery("SELECT * FROM users;") == null)
				{
					System.out.println("Null. Created default user; username:admin password:password");
					statement.executeUpdate("DROP TABLE if exists users;");
					statement.executeUpdate("CREATE TABLE users (userid int AUTO_INCREMENT,username varchar(255), password varchar(255), PRIMARY KEY(userid));");
					PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users values(null,?, ?);");
					preparedStatement.setString(1, "admin");
					preparedStatement.setString(2, encryptPassword("password","SHA-1","UTF-16"));
					preparedStatement.addBatch();
					connection.setAutoCommit(false);
					preparedStatement.executeBatch();
				    connection.setAutoCommit(true);
				}
				System.out.println("Database connected!");
			      ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
			        while (resultSet.next()) {
			        	Model.userNo = resultSet.getString("userid");
			        	//System.out.println("username = " + resultSet.getString("userid"));
			            System.out.println("username = " + resultSet.getString("username")+Model.userNo);
			            System.out.println("password = " + resultSet.getString("password"));
			        }
			       // resultSet.close();
			      //  connection.close();
			     // NEEDED BUT NEEEDS ADAPTING FOR PULLING USER'S INFORMATION WHEN LOADING PREVIOUS DATA
			        //connection.close();
			       //  * 
			         //
			}
			catch(SQLException ex)
			{
				  System.out.println("SQLException: " + ex.getMessage());
				  System.out.println("SQLState: " + ex.getSQLState());
				  System.out.println("VendorError: " + ex.getErrorCode());
			}
			
		}
		/*public static String getNextUserNo()
		{
			try
			{
				statement = connection.createStatement();
			      ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
			        while (resultSet.next()) {
			        	Model.userNo = resultSet.getString("userid");
			            System.out.println("username = " + resultSet.getString("username")+Model.userNo);
			            System.out.println("password = " + resultSet.getString("password"));
			        }
			}
			catch(SQLException ex)
			{
				  System.out.println("SQLException: " + ex.getMessage());
				  System.out.println("SQLState: " + ex.getSQLState());
				  System.out.println("VendorError: " + ex.getErrorCode());
			}
			int nextNumberInt = Integer.parseInt(Model.userNo) + 1;
			String nextNumberString = Integer.toString(nextNumberInt);
			return nextNumberString;
		}

*/

	
}
