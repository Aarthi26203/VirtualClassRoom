package VClass;
import java.time.LocalDate;

import java.util.*;
public class VirtualclassMain {

	static final Map<String,ClassRoom> ListOfClass = new HashMap<>();

	public static void main(String[] args){
		// TODO Auto-generated method stub 
		
	    Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.Create Classroom");
			System.out.println("2.Add Student");
			System.out.println("3.Schedule Assignment");
			System.out.println("4.Submit Assignment");
			System.out.println("5.Display");
			System.out.println("6.Exit");
			int input = sc.nextInt();
			
			switch(input)
			{
			    case 1:
			    	System.out.println("enter user name");
			    	String username = sc.next();
			    	System.out.println("enter password");
			    	String password = sc.next();
			    	String classname;
			    	if(AdminLogin.adminlogin(username,password))
			    	{
			    	System.out.println("enter class name");
			    	classname = sc.next();
			    	ListOfClass.put(classname, new ClassRoom(classname));
			    	System.out.println("ClassRoom ["+classname+"] has been created.");
			    	}
			    	else
			    		System.out.println("Your Password is incorrect!");
			    	break;
			    
			    case 2:
			    	System.out.println("enter user name");
			    	username = sc.next();
			    	System.out.println("enter password");
			    	password = sc.next();
			    	int ID;
			    	try {
			    	if(AdminLogin.adminlogin(username,password))
			    	{
			    	System.out.println("enter the class name to join:");
			    	classname =sc.next();
			    	System.out.println("enter the student ID:");
			    	ID = sc.nextInt();
			    	try {
			    	if(ListOfClass.containsKey(classname))
			    	{ 
			    		StudentEnrollThread senroll = new StudentEnrollThread(classname,ID);
			    		senroll.start();
			            
			    	}
			    	else
			    		throw new ClassNotFoundException("class name not found!");
			    	}
			    	
			    	catch(ClassNotFoundException e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	}
			    	else
			    		throw new Exception("Your Password is incorrect!");
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	break;
			    	
			    case 3:
			    	System.out.println("enter user name");
			    	username = sc.next();
			    	System.out.println("enter password");
			    	password = sc.next();
			    	try
			    	{
			    	if(AdminLogin.adminlogin(username,password)) 
			    	{
			    	System.out.println("Enter the class name:");
			    	classname = sc.next();
			    	
			    	try {
			    	if(ListOfClass.containsKey(classname))
			    	{
			        System.out.println("Enter the Assignment ID:");
					int AssignmentID = sc.nextInt(); 
					System.out.println("Enter the subject:");
			    	String subject = sc.next();
			    	System.out.println("Enter the Topic: ");
			    	String topic =sc.next();
			    	System.out.println("Enter the DeadLine(YYYY-MM-DD): ");
			    	String deadLinestr =sc.next();
			    	LocalDate deadLine = LocalDate.parse(deadLinestr);
			    	AssignmentList assignmentlist = new AssignmentList(AssignmentID,subject,topic,deadLine);
			    	AssignmentList.AssignmentDateChecker.put(AssignmentID,deadLine.toString());
			    	AssignmentListThread assignmentListThead = new AssignmentListThread(classname,assignmentlist);
			    	assignmentListThead.start();
			    	}
			    	else
			    	{
			    		throw new ClassNotFoundException("class name not found!");
			    	}
			    	}
			    	catch(ClassNotFoundException e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	}
			    	else
			    		throw new Exception("Your Password is incorrect!");
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	break;
			    case 4:
			    	System.out.println("enter user name");
			    	username = sc.next();
			    	System.out.println("enter password");
			    	password = sc.next();
			    	try
			    	{
			    	if(StudentLogin.studentlogin(username,password))
			    	{
			    	System.out.println("enter class name:");
			    	classname = sc.next();
			    	try {
			    	if(ListOfClass.containsKey(classname))
			    	{
			    	System.out.println("enter your stuid:");
			    	ID = sc.nextInt();
			    	System.out.println("enter the assignmentID you finished:");
			    	int AssignmentID  = sc.nextInt();    
			    	SubmitAssignmentThread submitAssignmentThread = new SubmitAssignmentThread(AssignmentID,ID);
			    	submitAssignmentThread.start();
			    	System.out.println("Assignment submitted by Student ["+ID+"] in ["+classname+"]" );
			    	}
			    	else
			    	{
			    		throw new ClassNotFoundException("class name not found!");
			    	}
			    	}
			    	catch(ClassNotFoundException e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	}
			    	else
			    		throw new Exception("Your Password is incorrect!");
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    	}
			    	  
			    	break;
			    case 5:
			    	DisplayThread display = new DisplayThread(ListOfClass);
			    	display.start();
			    	break;
			    case 6:
			    	System.exit(0);
			    	
			}
		}
		

			
	}

}
