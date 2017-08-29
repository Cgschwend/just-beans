/**  ***********************************************************************************************************************
	 * View class - The View represents a user entered command or request.
	 * 	  			The View is used by the Controller to build a Session to store on the sessionStack. 
	 * 
	 * Collection of method to manage the view attributes.  
	 * Extends Request class.	  						
	 * 	   
	 * 
	 * ***********************************************************************************************************************
	 */
public class View extends Request {
	
	private String type;
	private String operator;
	private String operand1;
	private String operand2;	
	/**  ************************************************************************************************************************  
	 * View() - default constructor.		 																					 * 						   							 
	 * **************************************************************************************************************************
	 */
	// default constructor
	public View () {			
	}
	/**  ***********************************************************************************************************************
	 * View(String type, String operator, String operand1, String operand2) - Binary View constructor.				   
	 * @param type indicates the type of session being created.
	 * @param operator represents a calculator command.
	 * @param operand1 value to be used in computation.
	 * @param operand2 value to be used in computation.
	 * *************************************************************************************************************************
	 */	
	// object constructor 
	public View (String type, String operator, String operand1, String operand2) {
			super(type, operator);
			setOperand1(operand1);
			setOperand2(operand2);
	}
	/**  ***********************************************************************************************************************
	 * setOperand1(String operand1) - Sets this.operand1 to the value of operand1 passed in as a parameter.  	 				* 		   
	 * @param operand1 to be used in computation.  	 																		* 
	 * *************************************************************************************************************************
	 */
	public void setOperand1(String operand1) {
		this.operand1 = operand1;		
	}
	/**  ***********************************************************************************************************************
	 * getOperand1() - Returns the current value of 'operand1'. 																* 		   
	 * @return operand1  																									* 
	 * *************************************************************************************************************************
	 */	
	public String getOperand1() {
			return this.operand1;	
	}
	/**  ***********************************************************************************************************************
	 * setOperand2(String operand2) - Sets this.operand2 to the value of operand2 passed in as a parameter.  	 				* 		   
	 * @param operand2 to be used in computation.  	 																		* 
	 * *************************************************************************************************************************
	 */		
	public void setOperand2(String operand2) {
		this.operand2 = operand2;		
	}
	/**  ***********************************************************************************************************************
	 * getOperand2() - Returns the current value of 'operand2'. 																* 		   
	 * @return operand2  																									* 
	 * *************************************************************************************************************************
	 */		
	public String getOperand2() {
			return this.operand2;	
	}		

}
