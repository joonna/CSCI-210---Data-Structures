/**
 * This is an implementation of an ObjectListNode of linear linked lists.
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public class ObjectListNode implements ObjectListNodeInterface
{
    private Object info;
    private ObjectListNode next; 
    private ObjectListNode back;

    /**
     * ObjectListNode constructor initializes the info, next, and back variables to null.
     */

    public ObjectListNode() {
        info = null; 
        next = null;
        back = null;
    }

    /**
     * ObjectListNode constructor initializes the info field to an Object o, and the next and back ObjectListNodes to null.
     */

    public ObjectListNode(Object o) {
        info = o; 
        next = null;
        back = null; 
    }

    /**
     * ObjectListNode constructor initializes every Object to their counterpart in the parameters.
     * @param Object o 
     * @param ObjectListNode p 
     * @param ObjectListNode q 
     */

    public ObjectListNode(Object o, ObjectListNode p, ObjectListNode q) {
        info = o; 
        next = p;
        back = q;
    }

    /**
     * setInfo() method sets the info objects information to the Object o.
     * @param Object o 
     */

    public void setInfo(Object o) {
        info = o;
    }

    /**
     * getInfo() method returns the information contained in the info Object.
     * @return Object info
     */

    public Object getInfo() {
        return info;
    }

    /**
     * setNext() method sets the next ObjectListNode's information to the ObjectListNode p.
     * @param ObjectListNode p 
     */

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

    /**
     * setBack() method sets the previous ObjectListNode's information to the ObjectListNode p.
     * @param ObjectListNode p 
     */

    public void setBack(ObjectListNode q) {
        back = q;
    }

    /**
     * getBack() method returns the ObjectListnode object that is contained within back.
     * @return ObjectListNode back 
     */

    public ObjectListNode getBack() {
        return back;
    }
}