/**
 *This is an implementation of an ObjectList of linear linked lists.
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public class ObjectList implements ObjectListInterface{
    private ObjectListNode list;
    private ObjectListNode last;

    /**
     * ObjectList constructor initializes the list ObjectListNode to null and 
     * the last ObjectListNode to null.
     */

    public ObjectList() {
        list = null;
        last = null;
    }

    /**
     * @return ObjectListNode list - the first ObjectListNode in the ObjectList.
     */

    public ObjectListNode getFirstNode() {
        return list; 
    }

    /**
     * @return ObjectListNode last - the last ObjectListNode in the ObjectList.
     */

    public ObjectListNode getLastNode() {
        return last; 
    }

    /**
     * returns the information stored in the first ObjectListNode in the ObjectList unless the list is composed only of a null.
     * @return Object list.getInfo()
     */

    public Object getFirst() {
        if(list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * returns the information stored in the last ObjectListNode in the ObjectList unless the list is composed only of a null.
     * @return Object last.getInfo() 
     */

    public Object getLast() {
        if(list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    /**
     * stores an object into the newly created first ObjectListNode of the ObjectList.
     * If list is initially composed of only a null, then this newly created first ObjectListNode is also the last node in the list.
     * @param Object o
     */

    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list, null);
        if(list == null) last = p;
        list = p;
    }

    /**
     * adds the first ObjectListNode into the ObjectList.
     * If list is initially composed of only a null, then this newly created first ObjectListNode is also the last node in the list.
     * @param ObjectListNode p 
     */

    public void addFirst(ObjectListNode p) {
        if(p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if(list == null) last = p;
        else {
            list.setBack(p);
        }
        list = p;
    }

    /**
     * stores an object into the newly created last ObjectListNode of the ObjectList.
     * If list is initially composed of only a null, then this newly created last ObjectListNode is also the first node of the list.
     * @param Object o
     */

    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o, null, last);
        if(list == null) list = p;
        else last.setNext(p);
        last = p;
    }

    /**
     * removes the ObjectListNode from the ObjectList which contains Object o.
     * If the list does not contain o, then null is returned.
     * @param Object o 
     * @return the node which is deleted from the list, or null if the list is empty or doensn't contain o.
     */

    public Object remove(ObjectListNode p) {
        if(p == null || list == null) {
            System.out.println("Runtime Error: reove();");
            System.exit(1);
        }
        ObjectListNode q = p.getBack();
        ObjectListNode r = p.getNext();
        if(q == null) {
            list = r;
        }
        else {
            q.setNext(r);
        }
        if(r != null) {
            r.setBack(q);
        }
        else {
            last = q;
        }
        return p.getInfo();
    }

    /**
     * Inserts a newly created ObjectListNode r containing Object o to the left of the ObjectListNode p contained in the ObjectList.
     * @param ObjectListNode p
     * @param Object o
     */

    public void insertLeft(ObjectListNode p, Object o) {
        ObjectListNode r;

        if(list == null || p == null) {
            System.out.println("Runtime Erro: insertLeft()");
        }
        ObjectListNode q = new ObjectListNode(o);
        r = p.getBack();
        if(r != null) r.setNext(q);
        q.setBack(r);
        q.setNext(p);
        p.setBack(q);
        if(list == p) list = q;
    }

    /**
     * Inserts a newly created ObjectListNode r containing Object o to the right of the ObjectListNode p contained in the ObjectList.
     * @param ObjectListNode p - the reference node to which the ObjectListNode containing Object o is to be inserted right of in the ObjectList.
     * @param Object o - the Object which is to be placed in a new ObjectListNode and inserted in the ObjectList right of p.
     */

    public void insertRight(ObjectListNode p, Object o) {
        ObjectListNode r;

        if(list == null || p == null) {
            System.out.println("Runtime Error: insertRight()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o);
        r = p.getNext();
        if(r != null) r.setBack(q);
        q.setNext(r);
        q.setBack(p);
        p.setNext(q);
        if(r == null) last = q;
    }

    /**
     * determines if the ObjectList is empty depending on whether or not list = null.
     * @return boolean
     */

    public boolean isEmpty() {
        return list == null;
    }

    /**
     * sets list and last to null, thus clearing the ObjectList of all information.
     */

    public void clear() {
        list = null; 
        last = null;
    }

    /**
     * determines the number of nodes contained in the ObjectList.
     * @return int count
     */

    public int size() {
        int count = 0; 
        ObjectListNode p = list; 
        while(p != null) {
            ++count; 
            p = p.getNext();
        }
        return count;
    }

    /**
     * creates a new ObjectList object, newList, and copies the contents of the current ObjectList onto that ObjectList. 
     * @return ObjectList newList
     */

    public ObjectList copyList() {
        ObjectListNode p = null; 
        ObjectListNode q = null; 
        ObjectListNode r = list;

        if(isEmpty()) return null;
        ObjectList newList = new ObjectList();
        while(r != null) {
            p = new ObjectListNode(r.getInfo());
            if(newList.isEmpty()) newList.addFirst(p);
            else {
                q.setNext(p);
                p.setBack(q);
            }
            q = p; 
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }
}
