package VClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoom{
   
	private String classname;
	private List<Integer> studentID;
	private List<AssignmentList> ListOfAssignment;
	private static Map<Integer,List<Integer>> ListOfSubmission= new HashMap<>();
	
	ClassRoom(String classname)
	{
		this.classname = classname;
		this.studentID = new ArrayList<Integer>();
		this.ListOfAssignment = new ArrayList<AssignmentList>();
		
	}
	 public ClassRoom() {
		// TODO Auto-generated constructor stub
	}
	public String getClassname() {
			return classname;
		}
    public List<Integer> getStudentID() {
		return studentID;
	}
	public List<AssignmentList> getListOfAssignment() {
		return ListOfAssignment;
	}
	public static Map<Integer, List<Integer>> getListOfSubmission() {
		return ListOfSubmission;
	}
	
	
	void addStudent(int ID){
		
		studentID.add(ID);
		
	}
	
	void scheduleAssignment(AssignmentList assignment)
	{
		ListOfAssignment.add(assignment);
		
	}
	void submitAssignment(int AssignmentID,LocalDate deadLine,int studentID) {
		try {
		if(!assignmentDeadLineChecker(deadLine)){
			if(ListOfSubmission.containsKey(AssignmentID)) {
				ListOfSubmission.get(AssignmentID).add(studentID);
			}
			else {
				ListOfSubmission.put(AssignmentID,new ArrayList<Integer>());
				ListOfSubmission.get(AssignmentID).add(studentID);
			}
			
		}
		else
    	
    		throw new Exception("The deadline for assignment ID "+AssignmentID+" has Passed.Submission not accepted!");
    	
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	boolean assignmentDeadLineChecker(LocalDate deadLine) {
		LocalDate today = LocalDate.now();
		if(today.isAfter(deadLine))
		{
			return true;
		}
		return false;
		
	}
}
