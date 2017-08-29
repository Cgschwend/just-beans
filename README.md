# just-beans
## IT Readiness Program - Java Development

### Console Calculator Project

This simple console calculator provides basic functionality.  The user may enter one of the following operations/commands to perform:
* '+'  for addition

* '-'  for subtraction

* '*'  for multiplication

* '/'  for division

* 'sqrt'  for square root

* 'log'  for log function

* '^'  for raise to the power of

* '%'  for modulo

* 'save'  to save the last computed answer to history

* 'recall'  to display the last answer from history

* 'print'  to display a list of all calculator computations and commands made in the current calculator session

* 'help' to display calculator usage message.

* 'off'  to power the calculator off.  Resets all calculator session memory by ending the current calculator session

If the user requests an operation, they will be prompted to enter the required numeric operand(s).  'Pi' may be entered as a 
valid numeric.

Console Calculator will allow up to 5 invalid entries before powering itself off.

### Design Elements

The ConsoleCalculatorController class:
* evaluates user input and creates a View object. 
* creates a Session object which uses the Calculate.computation method to calculate the answer.
* uses the Command.operation method to perform calculator commands.  

The Execute interface is implemented by the Calculator and Command abstract classes.

The Calculator abstract class performs the simple calculator computations.

The Command abstract class performs the simple calculator commands.

The View class inherits from Request class.  Currently, Session class does not inherit from Request but can, and may in future versions.

