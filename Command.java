	/**  ***********************************************************************************************************************
	 * Command class:	Executes user entered calculator commands using the Command.operation method. 
	 * Abstract class implements Execute interface.
	 * 
	 * operation method @params: String operator, GenericStack<Session> sessionStack, GenericStack<Double> memoryStack  
	 * 				
	 * 					print - prints the contents of the sessionStack.
	 *   				save - saves the last answer in the sessionStack to the memoryStack.
	 *   				recall - displays the last saved answer from the memoryStack.
	 *   				off - prepares the calculator to turn off.  TODO Possible options: show error log, popAll() stacks.
	 * 
	 * *************************************************************************************************************************
	 */

public abstract class Command implements Execute {
		     
		private Command() {
																									// empty constructor for abstract class
		}
	
	    public static void operation(String operator, GenericStack<Session> sessionStack, GenericStack<Double> memoryStack) {
	        switch (operator) {
	            case "print":																		// print: display the sessionStack
	                //System.out.println("Command.operation 01: " + operator);
	                //System.out.println(sessionStack.toString());
	                sessionStack.printAll();															// show each entry on separate line
	                break;
	            case "save":																			// save the last answer to memory
	            		//System.out.println("Command.operation 02: " + operator );
	            		
	            		Session Object = sessionStack.peek();											// if last entry was not a computation
	            		//System.out.println("peeked at : " + Object.getAnswer());
	            		if (Object.getType() == "C") {													// cannot save, display a message
	            			System.out.println("can not save last command: " + Object.getOperator());
	            		} else {
	            			Double lastAnswer = Object.getAnswer();										// otherwise save to memoryStack
	            			System.out.println("Will save to memory --> " + lastAnswer);
	            			memoryStack.push(lastAnswer);
	            			//System.out.println(memoryStack.toString());
	            		}	            
	            		break;
	            case "recall": 																		// print last answer on memoryStack
	            		//System.out.println("Command.operation 04: " + operator );
	            		if (memoryStack.isEmpty() == false) {
	            			Double recall = memoryStack.peek();
	            			System.out.println("recalled --> " + recall);
	            		} else {
	            			System.out.println("Nothing saved.");										// if nothing to recall, display message
	            		}
	            		break;
	            case "off":
	            		//System.out.println("Command.operation 05: " + operator);	 
	            		break;
	            	default:
	            		String msg = "Command.operation 06: Usage Error, please choose an keyword from the following list: off, save, recall, print.";
	            		System.out.println(msg);
	        }
	    }
}