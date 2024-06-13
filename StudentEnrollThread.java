package VClass;

import java.util.Map;

public class StudentEnrollThread extends Thread {
    
	
	private String classname;
	private int ID;
	
	public StudentEnrollThread(String classname, int ID) {
		
		this.classname=classname;
		this.ID = ID;
	}
    
	public String getClassname() {
		return classname;
	}
    
	public int getID() {
		return ID;
	}
    
	public void run()
	{
		VirtualclassMain.ListOfClass.get(getClassname()).addStudent(getID());
		System.out.println("Student ["+ID+"] has been enrolled in ["+classname+"]");
	}
	
}
