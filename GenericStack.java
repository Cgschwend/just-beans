/**  ***********************************************************************************************************************
	 * GenericStack class:	Collection of stack methods to use with any kind of object.
	 * 
	 * printAll() method: 	Makes a duplicate stack of "this" stack called printlist using popAll(). Then gets an object
	 * 						from printlist, prints it using the object's toString() method, adds the object back to
	 * 						the "this" stack, then removes it from printlist stack, preserving all objects in "this" stack 
	 * 						in the original order.
	 * 
	 * 
	 * ***********************************************************************************************************************
	 */
public class GenericStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	java.util.ArrayList<E> printlist = new java.util.ArrayList<E>();

	/**  ***********************************************************************************************************************
	 * size() method: 	Returns the size of the 'list' stack.
	 * @return int size of the array list
	 * *************************************************************************************************************************
	 */	
	public int size() {
		return list.size();
	}
	/**  ***********************************************************************************************************************
	 * push() method: 	Adds the object to the 'list' stack. 
	 * @param o generic object
	 * *************************************************************************************************************************
	 */	
	public void push(E o) {
		list.add(o);
	}
	/**  ***********************************************************************************************************************
	 * pop() method: 	Returns the top object from the 'list' stack and removes it from the stack. 
	 * @return a generic object
	 * *************************************************************************************************************************
	 */	
	public E pop() {
		E o = list.get(size()-1);
		list.remove(size()-1);
		return o;
	}
	/**  ***********************************************************************************************************************
	 * isEmpty() method: 	Returns true if the list stack is empty, false if it is not empty. 
	 * @return boolean
	 * *************************************************************************************************************************
	 */		
	public boolean isEmpty() {
		return list.isEmpty();
	}
	/**  ***********************************************************************************************************************
	 * peek() method: 	Returns a copy of top object from the list stack. 
	 * @return generic object
	 * *************************************************************************************************************************
	 */	
	public E peek() {
		E o =  list.get(size()-1);
		return o;
	}
	/**  ***********************************************************************************************************************
	 * clearAll() method: 	Clears the list stack. 
	 * *************************************************************************************************************************
	 */		
	public void clearAll() {
		list.clear();
	}
	/**  ***********************************************************************************************************************
	 * popAll() method: 	Returns a copy the list stack in reverse order.
	 * @return generic stack
	 * *************************************************************************************************************************
	 */	
	public java.util.ArrayList<E> popAll() {
		java.util.ArrayList<E> poplist = new java.util.ArrayList<E>();
		while (list.isEmpty() != true)  {
			poplist.add(list.get(size()-1));
			list.remove(size()-1);
		}
		return poplist;
	}	
	/**  ***********************************************************************************************************************
	 * 
	 * printAll() method: 	Makes a duplicate stack of "this" stack called 'printlist' using popAll(). Then gets an object
	 * 						from printlist, prints it using the object's toString() method, adds the object back to
	 * 						the "this" stack, then removes it from printlist stack, preserving all objects in "this" stack 
	 * 						in the original order.
	 * 
	 * ***********************************************************************************************************************
	 */	
	public void printAll() {	
		printlist = this.popAll();	
		while (printlist.isEmpty() != true)  {
			E printIt = printlist.get(printlist.size()-1);
			list.add(printIt);
			System.out.println(printIt.toString());
			printlist.remove(printlist.size()-1);
		}	
	}
	/**  ***********************************************************************************************************************
	 * toString() method: 	Returns a copy the list stack in reverse order.
	 * @return String concatenated with <code> list.toString() </code> string.
	 * *************************************************************************************************************************
	 */		
	@Override
	public String toString() {
		return " stack: " + list.toString();
	}
	
}
