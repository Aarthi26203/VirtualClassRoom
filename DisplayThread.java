package VClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayThread extends Thread{
	Map<String,ClassRoom> ListOfClass = new HashMap<>();
	
	DisplayThread(Map<String,ClassRoom> ListOfClass)
	{
		this.ListOfClass = ListOfClass;
	}
	
	public void run()
	{
		System.out.println("ClassRoom List :");
		for(Map.Entry<String,ClassRoom> hm : ListOfClass.entrySet())
    	{
	   
	    System.out.println("-------------------------------------");
    	System.out.println(hm.getKey());
    	ClassRoom classroom = hm.getValue();
    	System.out.println("Students Enrolled: ");
    	System.out.println("student ID's: "+classroom.getStudentID());
    	System.out.println("Assignment List :  "+classroom.getListOfAssignment().toString());
    	
    	}
		for(Map.Entry<Integer,List<Integer>> hm : ClassRoom.getListOfSubmission().entrySet())
		{
		System.out.println("List of Submissions :");
		System.out.println("-------------------------------------");
		System.out.println("Assignment ID :"+hm.getKey());
		System.out.println("-------------------------------------");
		System.out.println("Submitted Students ID :");
	    List<Integer> studentID = hm.getValue();
	    for(int id : studentID)
	    	System.out.println("Id No :"+id);
		
		}
	}

}
