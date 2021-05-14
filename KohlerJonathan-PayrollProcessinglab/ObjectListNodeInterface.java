
/**
 * This is an interface which holds the signatures for ObjectListNode class.
 * 
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public interface ObjectListNodeInterface
{
    public void setinfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}
