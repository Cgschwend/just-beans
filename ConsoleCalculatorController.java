	/**  ***********************************************************************************************************************
	 * ConsoleCalculatorController - Controller for the Console Calculator. 
	 * 
	 * 					This application runs a simple calculator on the
	 * 					console.  Usage instructions are displayed on the console and the user is prompted to enter a command.  
	 * 					If the command is an valid operator, the user will be prompted further to enter one or two numbers or pi.  
	 * 					If entry is valid, the calculator will compute the request and display the calculated answer.  If the user
	 * 					selected a calculator command, the command will be executed.
	 * 
	 * 
	 * 					Reads user entered input from the console via the scanner. 
	 * 					Only allows entry of specified valid commands or operators.
	 * 
	 * 					Calculator commands:
	 * 						save - saves the last answer to memory
	 * 	  				 	recall - displays the most recently saved answer
	 * 	  				 	print - prints a log of the commands and requests with calculated answers the user entered
	 * 						help - displays the initial calculator usage message again
	 * 	 				 	off - turns the console calculator off
	 * 
	 * 					Valid operators: 						Input Pattern:	 Calculation Pattern:
	 * 						+ : addition between two numbers.  		+ A B  	 -> 		A + B
	 * 						- : subtraction of two numbers			- A B  	 -> 		A - B
	 * 						* : multiplication of two numbers		* N N  	 -> 		N * N
	 * 						/ : division between two numbers			/ N D  	 -> 		N / D
	 * 						^ : to the power of						^ N e  	 -> 		N^^e
	 * 					 sqrt :	square root of a number				sqrt N  	 
	 * 					  log : log of a number						log N
	 * 
	 * 					Will allow for 5 invalid entry attempts.  After 5 attempts, view.type will be set to 'E' for error and
	 * 					scanning for user entry will stop, and the calculator will power down. 
	 * 
	 * @author Carol Gschwend
	 * @datecreated 08/26/2017
	 * @version 1.0.0
	 * 
	 *
	 * ***********************************************************************************************************************
	 */
import java.util.Scanner;


public class ConsoleCalculatorController {
	
	
	private static Scanner reader;

	public static void main(String[] args) {
	
		GenericStack<Session> sessionStack = new GenericStack<Session>();							// print operation stack
		GenericStack<Double> memoryStack = new GenericStack<Double>();							// save/recall operation stack
		
		
	    boolean isPowerOn = true;																// isPowerOn switch for control flow.
		reader = new Scanner(System.in);  														// Scanner for console user input. 
	    									
		  showInitialView();																		// Display usage instructions.
		  while (isPowerOn) {																	// Run while isPowerOn is true.
			showPromptView("");																	// Display calculator prompt.
			View view = getUserInput();															// Get user input in a view.
			
			
			if (view.getType() == "C") {															// User entered a Command.
				Command.operation(view.getOperator(),sessionStack,memoryStack);					// Execute the command.
				Session session = new Session(view.getType(), view.getOperator());				// Create a session.
				sessionStack.push(session);														// Save the session.
				if (view.getOperator().equals("off")) {											// If the Command was 'off',
						isPowerOn = false;														// set isPowerOn switch to false.
						System.out.println("Will power off.");									// Display power off message.
				}
			}
			
			if (view.getType() == "U") { 														// User entered a Unary operator. 
				view.setOperand1(getUserInputNumeric());											// Prompt user to enter a number.
				if (view.getOperand1() == "E") {													// If user doesn't enter properly 
					view.setType("E");															// within MaxTries,
					System.out.println("");														// prepare to power off.
					System.out.println("Usage Error 50.  Too many invalid input attemps. Calculator will power off.");
				} else {																					// Otherwise
				Session session = new Session(view.getType(), view.getOperator(), view.getOperand1());		// Build a session.
				sessionStack.push(session);																// Save a session.
				}
			}
			
			if (view.getType() == "B") {															// User entered a Binary operator.
				view.setOperand1(getUserInputNumeric());											// Prompt user to enter a number.
				if (view.getOperand1() == "E") {													// If user doesn't enter properly
					view.setType("E");															// within MaxTries,
					System.out.println("");														// prepare to power off.
					System.out.println("Usage Error 60.  Too many invalid input attemps. Calculator will power off.");
				} else {																			// Otherwise
					view.setOperand2(getUserInputNumeric());										// Prompt user to enter a number.
					if (view.getOperand2() == "E") {												// If user doesn't enter properly
						view.setType("E");														// within MaxTries,
						System.out.println("");													// prepare to power off.
						System.out.println("Usage Error 70:  Too many invalid input attempts. Calculator will power off.");
					} else {																		// Otherwise, create a session.
						Session session = new Session(view.getType(), view.getOperator(), view.getOperand1(), view.getOperand2());
						sessionStack.push(session);												// Save the session.
					}
				}
			  
			}
			
			if (view.getType() == "E") {															// If user entry error, 
				isPowerOn = false;																// set IsPowerOn switch to false,						
				System.out.println("Usage Error 80:  Too many invalid input attempts. Calculator will power off.");
				showPromptView("");																// display error to the view.	
			} 
		  
		  } //end while																			// End (while IsPowerOn) loop.
		  
		  System.out.println("Console Calculator off.");											// Display Calculator off message.
		  reader.close();																		// Close the scanner.
		} // end main																			// End main.
	
	
	/**  ***********************************************************************************************************************
	 * getUserInput() - 	Read user entered input from the console via the scanner. Only allow for valid commands or operators:
	 * 
	 * 					commands: save, print, recall, help, off
	 * 					operators: +, -, *, /, ^, sqrt, log
	 * 
	 * 					Will allow for 5 invalid entry attempts.  After 5 attempts, view.type will be set to 'E' for error and
	 * 					scanning will stop. 
	 *  
	 * @return View object 	(type, operator, operand1, operand2) created from console user entered input
	 * @exception Exception  if exception error on user entry input, catch error, print message, readnext entry.
	 * *************************************************************************************************************************
	 */
	public static View getUserInput() {															// Get user input, return a view.
		String firstToken = ""; 																	
		String token = "";
		boolean isValidEntry = false;															// User entry switch. On when valid input.
		int invalidEntryCounter = 1;																// Counts invalid user entry.
		String tempType = "";
		String msg = "";
		int MaxTries = 5;																		// Maximum number of invalid user entries.
		String validEntries = "Valid commands or operations: print, save, recall, help, off, +, -, *, /, ^, %, sqrt, log.";
		
	while ((invalidEntryCounter <= MaxTries) && (isValidEntry==false)) {							// Let user try to enter properly 
																								// up to MaxTries times.
		try {
			
			token = reader.nextLine(); 															// Get user input from scanner.							
            
            }
           		
            catch (Exception ime)																// Catch and count exceptions as
            {																					// invalid entry attempts.
                System.err.println("Incorrect entry.");											// Display error message.
                invalidEntryCounter ++;															// Count as an invalid entry attempt.
                token = reader.nextLine();														// Give user another try.
            }
	
			
			if (token.isEmpty()) {       														// No input entered.    
				msg = "Usage Error 10: getUserInput: No Input Entered.  Please enter a valid command or operation.";
				tempType = "E";																	// Flag as an error.
			} else {							
				String[] array = token.trim().split("\\s+");										// User entered something.
				firstToken = array[0].toLowerCase();												// Look at only first token.
				if (firstToken.equals("+") || 													// See if valid token.
						firstToken.equals("-") || 
					firstToken.equals("*") || 
					firstToken.equals("/") ||
					firstToken.equals("^") ||
					firstToken.equals("%")) {
						tempType = "B";															// User entered a Binary operator.
						isValidEntry = true;
				} else {																				
					if (firstToken.equals("log") ||												
						firstToken.equals("sqrt")) {
							tempType = "U";														// User entered a Unary operator.
							isValidEntry = true;
					} else {										
						if (firstToken.equals("print") || 
							firstToken.equals("save") || 
							firstToken.equals("recall") || 
							firstToken.equals("help") ||
							firstToken.equals("off")) {	
								tempType = "C";													// User entered a Command.
								isValidEntry = true;
							} 
						}
					}	
			}
			if (isValidEntry==false) {															// When user entered invalid input,
				invalidEntryCounter ++;															// increment invalid entry counter.
				if (msg.isEmpty()) {
					msg = "Usage Error 15: getUserInput: Invalid Input Entered.  Please enter a valid command or operation.";
					tempType = "E";																// Set type to "E" for error.
				}
				showPromptView(msg);																// Prompt User for valid input.
				showPromptView(validEntries);													// Show valid entry options.
				msg = "";
			}

		}//while																					// Exit while loop.
		View view = new View(tempType,firstToken,"0","0");										// Create a view.
		return view;																				// Return the view.
	} // end getUserInput


	/**  ***********************************************************************************************************************
	 * getUserInputNumeric() - Get next line of console input. 
	 * 						   Returns the FIRST entry only, trimmed of spaces.
	 * 						   Returns null if no input entered.
	 * 
	 * @return tempString 	String entered by the user.
	 * *************************************************************************************************************************
	 */
	public static String getUserInputNumeric() {													
		int MaxTries = 5;
		int invalidEntryCounter = 1;
		boolean isValidEntry = false;
		String tempString = "";
		String msg;	

		while ((invalidEntryCounter <= MaxTries) && (isValidEntry==false)) {						// Allow MaxTries user entries
																								// to enter a valid numeric.
			msg = "Please enter a valid number. ";												// Prompt user for input.
			showPromptView(msg);

			String token = reader.nextLine(); 													// Read user input as a string.
		
			if (token.isEmpty()) {           													// No input entered.
				invalidEntryCounter ++;															// Increment invalid entry counter.
				msg = "Usage Error 25: getUserInputNumeric: Invalid Input Entered. ";
				showPromptView(msg);																// Display error message to the view.
				msg = "";
			} else {																				// Otherwise
				String[] array = token.trim().split("\\s+");										// Look at only first token
				if (isValidNumeric(array[0]) ) {													// Is token a valid numeric?
					isValidEntry = true;															// Set isValidEntry to true;
					if (array[0].toLowerCase().equals("pi")){
						array[0] = String.valueOf(Math.PI);										// Allow for pi
					}
					tempString = array[0];														// Save valid numeric in tempString.
				} else {																			// Otherwise	
					invalidEntryCounter ++;														// Increment invalid entry counter.
					msg = "Usage Error 27: getUserInputNumeric: Invalid Input Entered. ";
					showPromptView(msg);															// Display error message to the view.
					msg = "";
				}
			}
			
		} //end while																			// End while loop.
		if (isValidEntry==false) {																// If too many tries, set "E" for error.
			tempString = "E";
		}
		return tempString;																		// Return the valid number or "E" for error.
	}	//end getUserInputNumeric																// Exit getUserInputNumeric().
		
	
	/**  ***********************************************************************************************************************
	 * showInitialView() - Displays Calculator Initial View to the console.  Includes usage instructions.
	 * 													
	 * 
	 * *************************************************************************************************************************
	 */
	
	public static void showInitialView() {
		
		System.out.println(" " );
		System.out.println("This is a simple console calculator. It will prompt the user for input, one entry at a time.");
		System.out.println("When prompted, enter a valid operator from the choices below and press 'return'.");
		System.out.println("Follow the prompts for entering the numbers needed for your calculation, then press 'return'."); 
		System.out.println(" ");
		System.out.println("Possible valid operators include:");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  '+' for addition.");
		System.out.println("  '-' for subtraction.");
		System.out.println("  '*' for multiplication.");
		System.out.println("  '/' for division.");
		System.out.println("  '^' for raising a number to a power.");
		System.out.println("  'sqrt' for square root.");
		System.out.println("  'log' for log function.");
		System.out.println("  '%' for modulo.");
		System.out.println("  'pi' can be entered in place of a number.");
		System.out.println("  ");
		System.out.println("Other possible valid user entry options include: ");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  'print' to list history.");
		System.out.println("  'save' to save to memory.");
		System.out.println("  'help' to display this message again.");
		System.out.println("  'recall' to recall from memory.");
		System.out.println("  'off' to turn calculator off.");
	}//end showInitialView
	

	/**  ***********************************************************************************************************************
	 * showPromptView() - Displays Calculator prompt to the console as: "Console Calculator on. ".  
	 * 					 Another line displays below with an optional message passed in, followed by @code" --> ".
	 * 													
	 * @param msg	a string for usage error messages or user prompts.
	 * *************************************************************************************************************************
	 */
	
	public static void showPromptView(String msg) {													
		System.out.println("  ");
		System.out.print("Console Calculator on. ");												// Normal usage console prompt.
		System.out.print(msg + " --> " );														// msg to pass messages between methods.
	}//end showPromptView
	

	/**  ***********************************************************************************************************************
	 * isValidNumeric(String field) - Returns true if 'entry' is a valid numeric (+ or -), else returns false. 
	 * 	
	 * 										
	 * @param field		String field to check if user entered a valid numeric or the string 'pi'
	 * @return boolean value		indicates whether 'field' qualifies as valid numeric
	 * *************************************************************************************************************************
	 */
	
	public static boolean isValidNumeric(String field) {
		
		if (field.toLowerCase().equals("pi")){														// Allow for pi to pass
			field = String.valueOf(Math.PI);															// Reset to Math.pi here temporarily
		}																							// Make real change in calling method
		if (field.matches(".*\\d+.*")) {																// Check user input for numerics.
			try {
				Double tempNumber = Double.parseDouble(field);										// Try Double.parseDouble here.
			}
			catch	
				(NumberFormatException e)															// Catch Number Format Exception.
			{
				System.out.println("Incorrect input, please enter an integer.");
		         return false;																		// Return false, non-numeric.
			}
			
			return true;																				// Return true, valid number found.
		} else {
			System.out.println("ConsoleCalculatorController.isValidNumeric: non numeric found: " + field);
			return false;																			// Return false, non-numeric.
		}
	} // end isValidNumeric																			// End method. 					
	
} //end ConsoleCalculatorController Class																// Exit Class.

