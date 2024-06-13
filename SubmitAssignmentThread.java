package VClass;

import java.time.LocalDate;

public class SubmitAssignmentThread extends Thread {
    private int AssignmentID;
    private int studentID;
    
    
    ClassRoom classroom = new ClassRoom();
	public SubmitAssignmentThread(int AssignmentID,int studentID){
		this.AssignmentID = AssignmentID;
		this.studentID =studentID;
	}
	public void run() {
		try {
		if(AssignmentList.AssignmentDateChecker.containsKey(AssignmentID)) {
		    
		    String deadLine = AssignmentList.AssignmentDateChecker.get(AssignmentID);
		    
		    classroom.submitAssignment(AssignmentID, LocalDate.parse(deadLine),studentID);
		}
		else 
			throw new Exception("Assignment Id not found!");
		
	   }
	   catch(Exception e)
		{
		   System.out.println(e.getMessage());
		}
}
}
