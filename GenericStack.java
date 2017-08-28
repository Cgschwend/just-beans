/**  ***********************************************************************************************************************
	 * GenericStack<E> class:	Collection of stack methods. 
	 * 
	 * printAll() method: 	Makes a duplicate stack of "this" stack called printlist using popAll(). Then gets an object
	 * 						from printlist, prints it using the object's toString() method, adds the object back to
	 * 						the "this" stack, then removes it from printlist stack, preserving all objects in "this" stack 
	 * 						in the original order.
	 * 
	 * 						<code> public void printAll() {	
	 *									printlist = this.popAll();											
	 *									while (printlist.isEmpty() != true)  {	
	 *											E printIt = printlist.get(printlist.size()-1);	
	 *											list.add(printIt);
	 *											System.out.println(printIt.toString());
	 *											printlist.remove(printlist.size()-1);
 	 *									}	 
	 * 								} <code>
	 * 
	 * 
	 * ***********************************************************************************************************************
	 */

public class GenericStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	java.util.ArrayList<E> printlist = new java.util.ArrayList<E>();

	
	public int size() {
		return list.size();
	}
	public void push(E o) {
		list.add(o);
	}
	public E pop() {
		E o = list.get(size()-1);
		list.remove(size()-1);
		return o;
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public E peek() {
		E o =  list.get(size()-1);
		return o;
	}
	public void clearAll() {
		list.clear();
	}
	
	public java.util.ArrayList<E> popAll() {
		java.util.ArrayList<E> poplist = new java.util.ArrayList<E>();
		while (list.isEmpty() != true)  {
			poplist.add(list.get(size()-1));
			list.remove(size()-1);
		}
		return poplist;
	}
	
	public void printAll() {	
		printlist = this.popAll();	
		while (printlist.isEmpty() != true)  {
			E printIt = printlist.get(printlist.size()-1);
			list.add(printIt);
			System.out.println(printIt.toString());
			printlist.remove(printlist.size()-1);
		}	
	}
	
	@Override
	public String toString() {
		return " stack: " + list.toString();
	}
	
}
