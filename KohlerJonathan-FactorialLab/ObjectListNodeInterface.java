/**
 *  This is the interface that holds the signatures for ObjectList class. 
 * 
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public interface ObjectListNodeInterface 
{
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
    public void setBack(ObjectListNode q);
    public ObjectListNode getBack();
}

