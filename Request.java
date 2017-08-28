/**  ***********************************************************************************************************************
	 * Request class - The Request represents a user request.  It is the parent class of View. 
	 * 	  			The View is used by the Controller to build a Session to store on the sessionStack. 
	 * 
	 * Collection of method to manage the Request attributes of type and operator.  
	 *  
	 * Constructor (type, operator)	
	 * 						   
	 * @param type	representing the type of request the user has given: C - Command, U - Unary, B - Binary, E - Error
	 * 																	
	 * @param operator	user entered operator: +, -, *, /, ^, %, sqrt, log, save, recall, print, off
	 * 
	 * ***********************************************************************************************************************
	 */
public class Request {
		
	protected String type;	
	protected String operator;

	public Request () {
		
	}
	
	public Request (String type, String operator) {
		setType(type);
		setOperator(operator);
	}
		public void setType(String type) {
			this.type = type;
			//System.out.println("Request: " + type);
		}

		public void setOperator (String operator) {
			this.operator = operator;
			//System.out.println("Request: " + operator);
		}
		
		public String getType () {
			return this.type;
		}
		
		public String getOperator () {
			return this.operator;
		}
		
		// override method
				@Override
				public String toString() {
					String tempString = "";
					tempString = String.format("%s %s", "Request: ", getOperator());
					return tempString;
				}
	}