package VClass;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentList {
    
	private int AssID;
	private String Subject;
	private String topic;
	private LocalDate deadLine;
	static Map<Integer,String> AssignmentDateChecker = new HashMap<>();
	
	AssignmentList(){
		
	}
	AssignmentList(int AssID,String Subject,String topic,LocalDate deadLine)
	{
		this.AssID =AssID;
		this.Subject=Subject;
		this.topic = topic;
		this.deadLine= deadLine;
		
		
	}
	public int getAssID() {
		return AssID;
	}
	
	public String getSubject() {
		return Subject;
	}
	
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	public LocalDate getDeadLine() {
		return deadLine;
	}
	@Override
	public String toString() {
		return "[AssID=" + AssID + ", Subject=" + Subject + ", topic=" + topic + ", deadLine=" + deadLine
				+ "]";
	}
	
	
	
	
	
}
