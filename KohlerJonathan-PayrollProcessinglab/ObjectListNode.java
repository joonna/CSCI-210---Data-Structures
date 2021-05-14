/**
 * This is an implementation of an ObjectListNode of linear linked lists.
 * @author classcode
 * @version 7/27/2019
 */
public class ObjectListNode {
    private Object info;
    private ObjectListNode next;

    /**
     * ObjectListNode constructor initializes the info and next variables to null.
     */
    // Default ctor    
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * ObjectListNode constructor initializes the info field to an Object o, and next ObjectListNodes to null.
     */
    // One-arg ctor
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    /**
     * ObjectListNode constructor initializes every Object to their counterpart in the parameters.
     * @param Object o 
     * @param ObjectListNode p 
     */
    // Two-arg ctor
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * setInfo() method sets the info objects information to the Object o.
     * @param Object o 
     */
    // Sets info field
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * getInfo() method returns the information contained in the info Object.
     * @return Object info
     */
    // Returns object in info field
    public Object getInfo() {
        return info;
    }

    /**
     * setNext() method sets the next ObjectListNode's information to the ObjectListNode p.
     * @param ObjectListNode p
     */
    // Sets next field
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * getNext() method returns the ObjectListnode object that is contained within next.
     * @return ObjectListNode next
     */
    public ObjectListNode getNext() {
        return next;
    }
}
