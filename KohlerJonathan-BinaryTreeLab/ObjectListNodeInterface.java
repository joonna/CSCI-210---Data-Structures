/**
* This is an interface which holds the signatures for ObjectListNode class.
* @author Jonathan Kohler
* @version 8/13/19
*/
public interface ObjectListNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setNext(ObjectListNode p);
	public ObjectListNode getNext();
}
