/**  ***********************************************************************************************************************
	 * Session class - Represents the user entered command or request with operator, operands, and calculated answer.
	 * 
	 * Collection of method to manage the session attributes and compute and display the answer, given the user entered 
	 * 		operand1, operator, and operand2.  The Session object represents a single, complete calculator request.
	 *  
	 * setAnswer() calls Calculator.operation() method with @params: double operand1, String operator, double operand2						   
	 * 
	 * constructor: (String type, String operator) constructor for command type session
	 * constructor: (String type, String operator, String operand1) constructor for unary session
	 * constructor: (String type, String operator, String operand1, String operand2) constructor for binary session
	 *
	 * @param type	representing the type of request the user has given. 
	 * @param operator	user entered operator 
	 * @param operand1	user entered operand1 
	 * @param operand2	user entered operand2
	 *
	 * 
	 * ***********************************************************************************************************************
	 */
public class Session {
	
	protected String type;	
	protected String operator;
	protected String operand1;
	protected String operand2;
	protected double answer;
		
	// Command Session constructor 
	public Session (String type, String operator) {
		setType(type);
		setOperator(operator);
		setOperand1("");
		setOperand2("");
		this.answer = 0;	
	}
	// Unary Session constructor 
	public Session (String type, String operator, String operand1) {
		setType(type);
		setOperator(operator);
		setOperand1(operand1);
		setOperand2("0");
		setAnswer();
	}
	// Binary Session constructor
	public Session (String type, String operator, String operand1, String operand2) {
		setType(type);
		setOperator(operator);
		setOperand1(operand1);
		setOperand2(operand2);
		setAnswer();
	}
	
	private void setType(String type) {
		this.type = type;
	}

	public void setOperator (String operator) {

		this.operator = operator;
	}

	private void setOperand1(String operand1) {
		this.operand1 = operand1;			
	}
	
	private void setOperand2(String operand2) {
		this.operand2 = operand2;															
	}
	
	public String getType () {
		return this.type;
	}
	
	public String getOperator () {
		return this.operator;
	}
	
	public String getOperand1 () {
		return this.operand1;
	}
	
	public String getOperand2 () {
		return this.operand2;
	}
	
	public double getAnswer() {
		return this.answer;
	}
	
	public void print () {
		System.out.println("Created Session");
	}
	/**  ***********************************************************************************************************************
	 * toString() method - Prints a session in the correct format given it's type as either a command, or a unary or binary
	 * 					  calculator request.  If 'pi' was entered by the user as a number, 'pi' is used in the toString()
	 * 					  method as response to the user entered 'print' command.					   
	 * 
	 * *************************************************************************************************************************
	 */
	// override method
		@Override
		public String toString() {
			String tempString = "";
			String tempOperand1 = getOperand1();
			String tempOperand2 = getOperand2();
			if (tempOperand1.equals(String.valueOf(Math.PI ))) {							// If user entered pi as input,
				tempOperand1 = "pi";														// display 'pi' in the stack print out.
			} 
			if (tempOperand2.equals(String.valueOf(Math.PI ))) {
				tempOperand2 = "pi";
			} 
	
	
			if (getType().equals("B")) {
				tempString += String.format("%s %s %s %s %s", 
						  tempOperand1,
						  getOperator(), 
						  tempOperand2, 
					"=" , getAnswer());
			} else {
			if (getType().equals("C")) {
				tempString += String.format("%s", getOperator());
			} else {
			if (getType().equals("U")) {
				tempString += String.format("%s %s %s %s %s", 
					    getOperator(),
				"  " ,  tempOperand1, 
				" = " , getAnswer());
			}
			else {
			tempString += String.format("%s \t %s %s \t %s %s 	\t %s %s	 	\t %s %s 	\t %s %s", 
					" Session: ", 
					" type: ", 	getType(),
					" operand1: ", tempOperand1,
					" operator: " , getOperator(), 
					" operand2: " , tempOperand2, 
					" answer is: " , getAnswer());
			}
			}}
			return tempString;
		}
		
		/**  ***********************************************************************************************************************
		 * setAnswer() method - Method to calculate the Session attribute, answer, using attributes operator, operand1, and operand2.  
		 * 						Calls Calculator.computation(operand1, operator, operand2) to perform the calculations and
		 * 						receives the answer back as a double.						   
		 * TODO: Next Version: Make Session inherit from Request class.  Make 3 child classes of Session: SessionIsUnary, 
		 * 																				 			 	SessionIsBinary, 
		 * 																				 				SessionIsCommand.
		 * input @param: none
		 * return value: double
		 * *************************************************************************************************************************
		 */
		
		public double setAnswer () {
			//System.out.println("Session: calculateAnswer : " + getOperator() + " " +  getOperand1() + " " + getOperand2() );			
			double passOperand1 = Double.parseDouble(getOperand1());
			double passOperand2 = Double.parseDouble(getOperand2());
			this.answer = Calculator.computation(passOperand1, getOperator(), passOperand2);
			return this.answer;
		}
	
}
