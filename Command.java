	/**  ***********************************************************************************************************************
	 * Command class:	Executes user entered calculator commands using the Command.operation method. 
	 * Abstract class implements Execute interface.
	 * 
	 * operation method uses String operator,  GenericStack sessionStack, GenericStack  memoryStack  
	 * 				
	 * 					print - prints the contents of the sessionStack.
	 *   				save - saves the last answer in the sessionStack to the memoryStack.
	 *   				recall - displays the last saved answer from the memoryStack.
	 *   				help - shows the initial calculator usage message.
	 *   				off - prepares the calculator to turn off.  
	 * 
	 * *************************************************************************************************************************
	 */

public abstract class Command implements Execute {
	/**  ***********************************************************************************************************************  
	 * Command() - default constructor.		 																				* 						   							* 
	 * *************************************************************************************************************************
	 */	     
		private Command() {
																									// empty constructor for abstract class
		}
	
		/**  *********************************************************************************************************************** 
		 * operation method:  (String operator, GenericStack sessionStack, GenericStack memoryStack )  
		 * 				
		 * 					print - prints the contents of the sessionStack.
		 *   				save - saves the last answer in the sessionStack to the memoryStack.
		 *   				recall - displays the last saved answer from the memoryStack.
		 *   				help - show the initial calculator usage message
		 *   				off - prepares the calculator to turn off.  
		 * @param operator String
		 * @param sessionStack Session object
		 * @param memoryStack  Double type
		 * *************************************************************************************************************************
		 */	
				
	    public static void operation(String operator, GenericStack<Session> sessionStack, GenericStack<Double> memoryStack) {
	        switch (operator) {
	            case "print":																		// Print: display the sessionStack.
	                sessionStack.printAll();															// Show each entry on separate line.
	                break;
	            case "save":																			// Save the last answer to memory.	            		
	            		Session Object = sessionStack.peek();											// If last entry was not a computation,
	            		if (Object.getType() == "C") {													// cannot save, display a message.
	            			System.out.println("can not save last command: " + Object.getOperator());
	            		} else {
	            			Double lastAnswer = Object.getAnswer();										// Otherwise save to memoryStack.
	            			System.out.println("Will save to memory --> " + lastAnswer);
	            			memoryStack.push(lastAnswer);
	            		}	            
	            		break;
	            case "recall": 																		// Print last answer on memoryStack.
	            		if (memoryStack.isEmpty() == false) {
	            			Double recall = memoryStack.peek();
	            			System.out.println("recalled --> " + recall);
	            		} else {
	            			System.out.println("Nothing saved.");										// If nothing to recall, display message.
	            		}
	            		break;
	            case "help":																			// Display usage message 
            			ConsoleCalculatorController.showInitialView();
	            		break;
	            case "off":																			// Will power off calculator	 
	            		break;
	            	default:
	            		String msg = "Command.operation 06: Usage Error, please choose an keyword from the following list: off, save, recall, print.";
	            		System.out.println(msg);
	        }
	    }
}