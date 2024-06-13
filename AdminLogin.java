package VClass;

import java.util.HashMap;
import java.util.Map;

public class AdminLogin {
 
	
	private String username;
	private String password;
	private static Map<String,String> AdminCredentials = new HashMap<>();
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public static Map<String, String> getAdminCredentials() {
		return AdminCredentials;
	}

	public static void setAdminCredentials(Map<String, String> adminCredentials) {
		AdminCredentials = adminCredentials;
	}

	public static boolean adminlogin(String username,String password)
	{
		if(checkUsername(username)){
			if(AdminCredentials.get(username).equals(password))
				System.out.println("Admin has successfully logged in!");
			else
				return false;
		}
		else {
			adminsignUp(username,password);
			System.out.println("Admin has successfully logged in!");
		}
		return true;
	}
	private static void adminsignUp(String username, String password) {
		
		AdminCredentials.put(username, password);   
		
	}
	
	private static boolean checkUsername(String username) {
		
		if(AdminCredentials.containsKey(username))
		     return true;
		
		return false;
	}
	
	
}
