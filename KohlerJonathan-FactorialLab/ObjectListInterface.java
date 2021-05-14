/**
 *  This is the interface that holds the signatures for ObjectList class. 
 * 
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public interface ObjectListInterface {
    public ObjectListNode getFirstNode();
    public ObjectListNode getLastNode();
    public Object getFirst();
    public Object getLast();
    public void addFirst(Object o);
    public void addFirst(ObjectListNode p);
    public void addLast(Object o);
    public Object remove(ObjectListNode p);
    public void insertLeft(ObjectListNode p, Object o);
    public void insertRight(ObjectListNode p, Object o);
    public boolean isEmpty();
    public void clear();
    public int size();
    public ObjectList copyList();
}
