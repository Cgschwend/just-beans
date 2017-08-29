/**  ***********************************************************************************************************************
	 * Request class - The Request represents a user request.  It is the parent class of View. 
	 * 	  			The View is used by the Controller to build a Session to store on the sessionStack. 
	 * 
	 * Collection of methods to manage the Request attributes - type and operator.  
	 *  
	 * Constructor (String type, String operator)	
	 * 						   
	 *  type representing the type of request the user has given: C - Command, U - Unary, B - Binary, E - Error
	 * 																	
	 *  operator	 representing the user entered operator: +, -, *, /, ^, %, sqrt, log, save, recall, print, off
	 * 
	 * ***********************************************************************************************************************
	 */
public class Request {
		
	protected String type;	
	protected String operator;
	/**  ***********************************************************************************************************************  
	 * Request() - default constructor.		 																				* 						   							
	 * *************************************************************************************************************************
	 */
	public Request () {	
	}
	/**  ***********************************************************************************************************************    
	 * Request(String type, String operator) - object constructor.		 													* 						   
	 * @param type	representing the type of request the user has given.														* 																	
	 * @param operator	user entered operator.																				* 
	 * *************************************************************************************************************************
	 */
	public Request (String type, String operator) {
		setType(type);
		setOperator(operator);
	}
	/**  ***********************************************************************************************************************   
	 * setType(String type) - sets the current Request object 'type' attribute. 												* 						   
	 * @param type	representing the type of request the user has given.	 													* 
	 * *************************************************************************************************************************
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**  ***********************************************************************************************************************    
	 * setOperator(String operator) - sets the current Request object 'operator' attribute. 									* 						   
	 * @param operator																										*	
	 * *************************************************************************************************************************
	 */
	public void setOperator (String operator) {
		this.operator = operator;
	}
	/**  ***********************************************************************************************************************    
	 * getType(String type) - Returns the current value of the Request object's 'type' attribute. 								* 						   
	 * @return type																											*
	 * *************************************************************************************************************************
	 */		
	public String getType () {
		return this.type;
	}
	/**  ***********************************************************************************************************************    
	 * getOperator(String operator) - Returns the current value of the Request object's 'operator' attribute. 					* 						   
	 * @return operator																										*
	 * *************************************************************************************************************************
	 */			
	public String getOperator () {
		return this.operator;
	}
	/**  ***************************************************************************************************************************  
	 * toString method - Returns a string containing "Request: " and the current value of the Request object's operator attribute. *  						   
	 * @return String																										 	*
	 * *****************************************************************************************************************************
	 */			
	// override method
	@Override
	public String toString() {
			String tempString = "";
				   tempString = String.format("%s %s", "Request: ", getOperator());
			return tempString;
			}
	}