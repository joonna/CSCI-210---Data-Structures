/**
* This is an interface which holds signatures for comparing word objects in a binary tree.
* @author Jonathan Kohler
* @version 8/13/19
*/
public interface TreeComparable {
	public int compareTo(Object o);
	public void operate(Object o);
	public void visit();
}
