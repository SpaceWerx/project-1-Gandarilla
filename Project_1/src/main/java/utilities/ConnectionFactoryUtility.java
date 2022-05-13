package utilities;
import java.sql.Connection;  
import java.security.*;
import java.sql.DriverManager;  
public class ConnectionFactoryUtility {

	private static ConnectionFactoryUtility CFU;

	   private ConnectionFactoryUtility(){
	    }
	     
	 
	   //we create the getInstance() to return the instance of this class.
	    public static ConnectionFactoryUtility getInstance(){
	             if (CFU == null) {
	                        synchronized (ConnectionFactoryUtility.class){
	                               // the following if block will be executed when the first object is created or else it will keep returning the previously created object
	                                 if (CFU == null) {
	                                        CFU = new ConnectionFactoryUtility ();
	                                }
	                      }
	                }
	                return CFU;
	    }	
	
	
	public static void connection(String args[]) {

	
	String url;
	Connection con = null;
      try {  
          Class.forName("com.mysql.jdbc.Driver");  
      url="jdbc:mysql://localhost:3306/spring";  
          con = DriverManager.getConnection(url);  
          System.out.println("Connection created");  
          con.close();  
          System.out.println("Connection closed");  
          }  
          catch (Exception e) {  
          System.out.println(e.toString());  
      }  
	}
	
	public static void instance(String[] argv){
        try {
            // creating the object of Signature and getting instance
            // By using getInstance() method
            Signature sr = Signature.getInstance("SHA1WithRSA");
 
            // getting the status of signature object
            String str = sr.toString();
 
            // printing the status
            System.out.println("Status : " + str);
        }
 
        catch (NoSuchAlgorithmException e) {
 
            System.out.println("Exception thrown : " + e);
        }
        catch (ProviderException e) {
 
            System.out.println("Exception thrown : " + e);
        }
    }
}
