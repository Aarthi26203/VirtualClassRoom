package VClass;

public class AssignmentListThread extends Thread {
	
	private String classname;
	private AssignmentList assignment;
	
	
	public AssignmentListThread(String classname,AssignmentList assignment) {
		// TODO Auto-generated constructor stub
		this.classname = classname;
		this.assignment = assignment;
	}

    public String getClassname() {
		return classname;
	}
    public AssignmentList getAssignment() {
		return assignment;
	}

    public void run()
	{
		    VirtualclassMain.ListOfClass.get(getClassname()).scheduleAssignment(getAssignment());
		   
    	    System.out.println("Assignment for ["+classname+"] has been scheduled");
	}
	
}
