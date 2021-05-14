/**
 * This is an implementation of an ObjectListNode of linear linked lists.
 * @author Jonathan Kohler
 * @version 8/2/2019
 */
public class ObjectListNode implements ObjectListNodeInterface{
    private Object info;
    private ObjectListNode next;

    /**
     * This is the default constructor for ObjectListNode.
     * Instantiates info and next field.
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * This is a one-argument constructor for ObjectListNode which takes in an object o.
     * @param o
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    /**
     * This is a two-argument constructor for ObjectListNode which takes in an object o and an ObjectListNode p.
     * @param o
     * @param p 
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * This method sets the info field to an object o.
     * @param o
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * This method gets the object from the info field.
     * @return info
     */
    public Object getInfo() {
        return info;
    }

    /**
     * This method sets the next field of an node to p.
     * @param p
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * This method gets the next field of an node.
     * @return next
     */
    public ObjectListNode getNext() {
        return next;
    }
}
