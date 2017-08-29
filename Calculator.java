	/**  ***********************************************************************************************************************
	 * Calculator class - Uses the Calculator.computation method to compute, display and return the answer attribute, 
	 * 					  given the parameters operand1, operator, and operand2.
	 * 
	 *  Abstract class implements Execute interface.
	 *  				   
	 * 
	 * @return answer	the calculated answer to the user entered request
	 * *************************************************************************************************************************
	 */
public abstract class Calculator implements Execute {
	/**  ***********************************************************************************************************************  
	 * Calculator() - default constructor.		 																				* 						   							* 
	 * *************************************************************************************************************************
	 */
		private Calculator() {												
		}																							// empty constructor
	
	    private static double answer = 0;
	    
		/**  ***********************************************************************************************************************
		 * computation method - Receives operand1, operator, operand2 parameters and computes and returns the answer attribute.   
		 * 
		 * @param double operand1, String operator, double operand2						   
		 * @return answer	the calculated answer to the user entered request
		 * *************************************************************************************************************************
		 */
	   	    
	    public static double computation(double operand1, String operator, double operand2) {
	        switch (operator) {
	            case "+":
	                answer = operand1 + operand2;
	                break;
	            case "-":
	                answer = operand1 - operand2;
	                break;
	            case "*":
	                answer = operand1 * operand2;
	                break;
	            case "/":
	                answer = operand1 / operand2;
	                break;
	            case "^"	 :		
	            		answer = Math.pow(operand1,operand2); 
		            break;
	            case "sqrt" :	
	            		answer = Math.sqrt(operand1);
                		break;
	            case "%" :		
	            		answer = operand1 % operand2;
					break;
	            case "log" :		
	            		answer = Math.log(operand1); 
	            		break;
	            default	:	
	            		String msg = "Calculator.computation: Usage Error, please choose an operator from the following list: +, -, *, /, sqrt, ^, %, log";
	            		System.out.println(msg);
	        }
	        System.out.println("Calculated answer --> " + answer);
	        return answer;
	    }	
}
