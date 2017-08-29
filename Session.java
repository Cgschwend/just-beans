/**  ***********************************************************************************************************************
	 * Session class - Represents the user entered command or request with operator, operands, and calculated answer.
	 * 
	 * Collection of methods to manage the session attributes and compute and display the answer, given the user entered 
	 * 		operand1, operator, and operand2.  The Session object represents a single, complete calculator request.
	 *  
	 * setAnswer() calls Calculator.operation() method with double operand1, String operator, double operand2						   
	 * 
	 * constructor: (String type, String operator) constructor for command type session
	 * constructor: (String type, String operator, String operand1) constructor for unary session
	 * constructor: (String type, String operator, String operand1, String operand2) constructor for binary session
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
	/**  ***********************************************************************************************************************
	 * Session(String type, String operator) - Command Session constructor.				   
	 * @param type indicates the type of session being created.
	 * @param operator represents a calculator command.
	 * *************************************************************************************************************************
	 */		
	// Command Session constructor 
	public Session (String type, String operator) {
		setType(type);
		setOperator(operator);
		setOperand1("");
		setOperand2("");
		this.answer = 0;	
	}
	/**  ***********************************************************************************************************************
	 * Session(String type, String operator, String operand1) - Unary Session constructor.				   
	 * @param type indicates the type of session being created.
	 * @param operator represents a calculator command.
	 * @param operand1 value to be used in computation.
	 * *************************************************************************************************************************
	 */
	// Unary Session constructor 
	public Session (String type, String operator, String operand1) {
		setType(type);
		setOperator(operator);
		setOperand1(operand1);
		setOperand2("0");
		setAnswer();
	}
	/**  ***********************************************************************************************************************
	 * Session(String type, String operator, String operand1, String operand2) - Binary Session constructor.				   
	 * @param type indicates the type of session being created.
	 * @param operator represents a calculator command.
	 * @param operand1 value to be used in computation.
	 * @param operand2 value to be used in computation.
	 * *************************************************************************************************************************
	 */
	// Binary Session constructor
	public Session (String type, String operator, String operand1, String operand2) {
		setType(type);
		setOperator(operator);
		setOperand1(operand1);
		setOperand2(operand2);
		setAnswer();
	}
	/**  ***********************************************************************************************************************
	 * setType(String type) - Sets this.type to the value of type passed in as parameter.			   
	 * @param type indicates the type of session being created.
	 * *************************************************************************************************************************
	 */
	private void setType(String type) {
		this.type = type;
	}
	/**  ***********************************************************************************************************************
	 * setOperator(String operator) - Sets this.operator to the value of operator passed in as a parameter.			   
	 * @param operator indicates the type of operation to be used in computation.
	 * *************************************************************************************************************************
	 */
	public void setOperator (String operator) {
		this.operator = operator;
	}
	/**  ***********************************************************************************************************************
	 * setOperand1(String operand1) - Sets this.operand1 to the value of operand1 passed in as a parameter.  If the value
	 * passed in is "pi", the numeric value of pi will be used. 
	 * 		   
	 * @param operand1 to be used in computation.  
	 * 
	 * *************************************************************************************************************************
	 */
	private void setOperand1(String operand1) {
		this.operand1 = operand1;
		if (this.operand1.toLowerCase().equals("pi")){											// Allow for pi 
			this.operand1 = String.valueOf(Math.PI);												// for unit testing bypass
		}
	}
	/**  ***********************************************************************************************************************
	 * setOperand2(String operand2) - Sets this.operand2 to the value of operand2 passed in as a parameter.  If the value
	 * passed in is "pi", the numeric value of pi will be used. 
	 * 		   
	 * @param operand2 to be used in computation.  																			  
	 * *************************************************************************************************************************
	 */	
	private void setOperand2(String operand2) {
		this.operand2 = operand2;
		if (this.operand2.toLowerCase().equals("pi")){											// Allow for pi 
			this.operand2 = String.valueOf(Math.PI);												// for unit testing bypass
		}
	}
	/**  ***********************************************************************************************************************
	 * getType() - Returns the current value of 'type'. 																		* 		   
	 * @return type   																										* 
	 * *************************************************************************************************************************
	 */	
	public String getType () {
		return this.type;
	}
	/**  ***********************************************************************************************************************
	 * getOperator() - Returns the current value of 'operator'. 																* 		   
	 * @return operator   																									* 
	 * *************************************************************************************************************************
	 */	
	public String getOperator () {
		return this.operator;
	}
	/**  ***********************************************************************************************************************
	 * getOperand1() - Returns the current value of 'operand1'. 																* 		   
	 * @return operand1  																									* 
	 * *************************************************************************************************************************
	 */		
	public String getOperand1 () {
		return this.operand1;
	}
	/**  ***********************************************************************************************************************
	 * getOperand2() - Returns the current value of 'operand2'. 																* 		   
	 * @return operand2  																									* 
	 * *************************************************************************************************************************
	 */		
	public String getOperand2 () {
		return this.operand2;
	}
	/**  ***********************************************************************************************************************
	 * getAnswer() - Returns the current value of 'answer'. 																	* 		   
	 * @return answer  																									* 
	 * *************************************************************************************************************************
	 */	
	public double getAnswer() {
		return this.answer;
	}
	/**  ***********************************************************************************************************************
	 * print() - Displays the message "Created Session" 																		* 		   																									* 
	 * *************************************************************************************************************************
	 */		
	public void print () {
		System.out.println("Created Session");
	}
	/**  ***********************************************************************************************************************
	 * toString() method - Prints a session in the correct format given it's type as either a command, or a unary or binary
	 * 					  calculator request.  If 'pi' was entered by the user as a number, 'pi' is used in the toString()
	 * 					  method as response to the user entered 'print' command.					   
	 * @return String message formated to display the saved calculator sessions.
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
	
																						// Format Binary session for print
			if (getType().equals("B")) {
				tempString += String.format("%s %s %s %s %s", 
						  tempOperand1,
						  getOperator(), 
						  tempOperand2, 
					"=" , getAnswer());
			} else {
																						// Format Command session for print
			if (getType().equals("C")) {
				tempString += String.format("%s", getOperator());
			} else {
																						// Format Unary session for print
			if (getType().equals("U")) {
				tempString += String.format("%s %s %s %s %s", 
					    getOperator(),
				"  " ,  tempOperand1, 
				" = " , getAnswer());
			}
																						// Else format session object for print
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
		 * @return value: double
		 * *************************************************************************************************************************
		 */
		
		public double setAnswer () {		
			double passOperand1 = Double.parseDouble(getOperand1());
			double passOperand2 = Double.parseDouble(getOperand2());
			this.answer = Calculator.computation(passOperand1, getOperator(), passOperand2);
			return this.answer;
		}
	
}
