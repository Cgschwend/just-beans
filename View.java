/**  ***********************************************************************************************************************
	 * View class - The View represents a user entered command or request.
	 * 	  			The View is used by the Controller to build a Session to store on the sessionStack. 
	 * 
	 * Collection of method to manage the view attributes.  
	 * Extends Request class.
	 * 						
	 * TODO Next Version: Make 4 child classes of View.  ViewIsError, ViewIsCommand, ViewIsUnary, ViewIsBinary
	 * 	   
	 * @param type	representing the type of request the user has given. 
	 * @param operator	user entered operator 
	 * @param operand1	user entered operand1 
	 * @param operand2	user entered operand2
	 * 
	 * ***********************************************************************************************************************
	 */
public class View extends Request {
	
	private String type;
	private String operator;
	private String operand1;
	private String operand2;

	
	// object constructor 
	/*
		public View (String type, String operator, String operand1, String operand2) {
			setType(type);
			setOperator(operator);
			setOperand1(operand1);
			setOperand2(operand2);
		}
	*/
		//  default constructor
			public View () {
			
		}
		// object constructor 
			public View (String type, String operator, String operand1, String operand2) {
					super(type, operator);
					setOperand1(operand1);
					setOperand2(operand2);
				}

	public void setOperand1(String operand1) {
		this.operand1 = operand1;
		//System.out.println("setting operand1: " + operand1);
		
	}
	
	public String getOperand1() {
			return this.operand1;
		
	}
	
	public void setOperand2(String operand2) {
		this.operand2 = operand2;
		//System.out.println("setting operand2: " + operand2);
		
	}
	
	public String getOperand2() {
			return this.operand2;
		
	}
		
	//public void setOperator(String operator) {
	//		this.operator = operator;
	//		System.out.println("View: setting operator " + operator);
			
	//	}

	//public String getOperator() {
	//	return this.operator;
		
	//}
	
	//public void setType(String type) {
	//	this.type = type;
		
	//}
	
	//String getType() {
	//	return this.type;
		
	//}
}
