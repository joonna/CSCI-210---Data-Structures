/**
 * This is an implementation of an ObjectList of linear linked lists.
 * @author classcode
 * @version 7/27/2019
 */

public class ObjectList implements ObjectListInterface{
    private ObjectListNode list;
    private ObjectListNode last;

    /**
     * This is the default constructor for ObjectList, which creates an empty list.
     */
    // Constructs an empty list
    public ObjectList() {
        list = null;
        last = null;
    }

    /**
     * This method returns the first node in the list.
     * @return list 
     */
    // Returns the first node in the list
    public ObjectListNode getFirstNode() {
        return list;
    }

    /**
     * This method returns the last node in the list.
     * @return last
     */
    // Returns the last node in the list
    public ObjectListNode getLastNode() {
        return last;
    }

    /**
     * This method returns the first object in the list.
     * if list is null, nothing is returned.
     * @return list.getInfo()
     */
    // Returns the first object in the list
    public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * This method returns the last object in the list.
     * if list is null, nothing is returned.
     * @return last.getInfo()
     */
    // Returns the last object in the list
    public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    /**
     * This method adds an object to the front of a list.
     * If list is null, last is pointed to new objectListNode p.
     * else, list points to objectListNode p.
     * @param o
     */
    // Adds an object to the front of a list
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * This method adds a node to the front of the list
     * if p is null, nothing is returned.
     * @param p
     */
    // Adds a node to the front of the list
    public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * This method adds an object to the end of the list.
     * @param o
     */
    // Adds an object to the end of the list
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) 
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * This method adds a node to the end of the list.
     * @param p
     */
    // Adds a node to the end of the list
    public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    // Removes the first object from the list
    /**
     * This method removes the first object from the list.
     * @return p.getinfo()
     */
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    // Removes the last object from the list
    /**
     * This method removes the last object from the list.
     * @return p.getInfo()
     */
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }    
        else {
            q.setNext(null);
            last = q;
        }    
        return p.getInfo();
    }

    /**
     * This method inserts an object after the node referenced by p.
     * @param p
     * @param o
     */
    // Inserts an object after the node referenced by p
    public void insertAfter (ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    /**
     * This method inserts a node after the node referenced by p.
     * @param p
     * @param q
     */
    // Inserts a node after the node referenced by p
    public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }

    /**
     * This method deletes the node after the node referenced by p.
     * @param p
     * @return q.getInfo()
     */
    // Deletes the node after the node referenced by p
    public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }

    /**
     * This method inserts an item into its correct location within an ordered list
     * using the compareTo method.
     * @param o
     */
    // Inserts an item into its correct location within an ordered list
    public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    /**
     * This method inserts a node into its correct location within an ordered list
     * using the compareTo method.
     * @param r
     */
    // Inserts a node into its correct location within an ordered list
    public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
        ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    /**
     * This method removes the first occurrence of an item in a list.
     * @param o
     * @return null
     * @return q == null ? removeFirst() : deleteAfter(q)
     */
    // Removes the first occurrence of an item in a list 
    public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
        0) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return null;
        else return q == null ? removeFirst() : deleteAfter(q);
    }

    /**
     * This method returns true if the item is found in the list.
     * @param o
     * @return p != null
     */
    // Returns true if the item is found in the list
    public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
        0)
            p = p.getNext();
        return p != null;
    }

    /**
     * This method returns a reference to the node with the requested value.
     * Otherwise, it returns null.
     * @param o
     * @return p
     * @return null
     */
    // Returns a reference to the node with the requested value
    // Returns null otherwise
    public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;
    }

    /**
     * This method determines whether or not a list is empty.
     * @return list == null
     */
    // Determines whether or not a list is empty
    public boolean isEmpty() {
        return list == null;
    }

    /**
     * This method removes all elements from a list by setting pointers to null.
     */
    // Removes all elements from a list
    public void clear() {
        list = null;
        last = null;
    }

    /**
     * This method returns the number of elements in the list by traversing and incrementing a counter.
     * @return count
     */
    // Returns the number of elements in the list
    public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    /**
     * This method makes a copy of a list.
     * @return null
     * @return newList
     */
    // Makes a copy of a list
    public ObjectList copyList() {
        ObjectListNode p = null; 
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;

        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p); 
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    /**
     * This method reverses a list by using leading and lagging pointers.
     */
    // Reverses a list
    public void reverse() {
        ObjectListNode p = list;
        ObjectListNode q = null;
        ObjectListNode r;

        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }   
}

