
/**  ***********************************************************************************************************************
* CalculatorUnitTest - Runs a series of calculator usage and entry tests, bypassing user input.
* public final class
* 									Creates all Session types. 
* 									Calls print() all types.
* 									Uses toString() on all types.
* 
* TODO allow for pi
* 
* input @param: none
* return value: none
* ***********************************************************************************************************************
*/
public final class CalculatorUnitTest {
	
	
	public CalculatorUnitTest() {
		//stub constructor
	}
	
	public static void runUnitTests() {
	
	
	Session sessionIsSqrt = new Session("U","sqrt", "4");
	//sessionIsSqrt.setAnswer();
	sessionIsSqrt.print();
	System.out.println(sessionIsSqrt.toString());
	System.out.println(" ");
	
	Session sessionIsLog = new Session("U","log", "4");
	//sessionIsLog.setAnswer();
	sessionIsLog.print();
	System.out.println(sessionIsLog.toString());
	System.out.println(" ");
	
	Session sessionIsAddition = new Session("B","+", "5", "3");
	//sessionIsAddition.setAnswer();
	sessionIsAddition.print();
	System.out.println(sessionIsAddition.toString());
	System.out.println(" ");
	
	Session sessionIsSubtraction = new Session("B","-", "4", "3");
	sessionIsSubtraction.print();
	System.out.println(sessionIsSubtraction.toString());
	System.out.println(" ");
	
	Session sessionSave = new Session("C","save");
	sessionSave.print();
	System.out.println(sessionSave.toString());	
	System.out.println(" ");
	
	Session sessionIsMultiplication = new Session("B","*", "3", "2");
	sessionIsMultiplication.print();
	System.out.println(sessionIsMultiplication.toString());
	System.out.println(" ");
	
	Session sessionIsDivision = new Session("B","/", "4", "3");
	sessionIsDivision.print();
	System.out.println(sessionIsDivision.toString());
	System.out.println(" ");
	

	Session sessionRecall = new Session("C","recall");
	sessionRecall.print();
	System.out.println(sessionRecall.toString());	
	System.out.println(" ");
	
	Session sessionIsRaiseToPower = new Session("B","^", "2", "3");
	sessionIsRaiseToPower.print();
	System.out.println(sessionIsRaiseToPower.toString());
	System.out.println(" ");
	
	Session sessionIsModulo = new Session("B","%", "5", "2");
	sessionIsModulo.print();
	System.out.println(sessionIsModulo.toString());
	System.out.println(" ");
	
		
	Session sessionIsUsingPi = new Session("B","+", "pi", "2");
	//sessionIsUsingPi.print();
	System.out.println(sessionIsUsingPi.toString());
	System.out.println(" ");
		

	Session sessionIsNegative = new Session("B","+", "-3", "2");
	sessionIsNegative.print();
	System.out.println(sessionIsNegative.toString());
	System.out.println(" ");
	

	Session sessionIsDoubleNegative = new Session("B","+", "-3", "-2");
	sessionIsDoubleNegative.print();
	System.out.println(sessionIsDoubleNegative.toString());
	System.out.println(" ");
	
	Session sessionPrint = new Session("C","print");
	sessionPrint.print();
	System.out.println(sessionPrint.toString());	
	System.out.println(" ");
	
	Session sessionOff = new Session("C","off");
	sessionOff.print();
	System.out.println(sessionOff.toString());	
	System.out.println(" ");
	
	
	}
}
