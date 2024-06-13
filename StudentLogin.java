package VClass;

import java.util.HashMap;
import java.util.Map;

public class StudentLogin {
   
	private String username;
	private String password;
	private static Map<String,String> StudentCredentials  = new HashMap<>();
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public static boolean studentlogin(String username,String password)
	{
		if(checkUsername(username)){
			if(StudentCredentials.get(username).equals(password))
				System.out.println("Student has successfully logged in!");
			else
				return false;
		}
		else {
			studentsignUp(username,password);
			System.out.println("Student has successfully logged in!");
		}
		return true;
	}
	private static void studentsignUp(String username, String password) {
		
		StudentCredentials.put(username, password);   
		
	}
	
	private static boolean checkUsername(String username) {
		
		if(StudentCredentials.containsKey(username))
		     return true;
		
		return false;
	}
	
}
