/**
 * Interface for ObjectStack Class
 * 
 * @author Jonathan Kohler
 * @version 7/3/2019
 */
public interface ObjectStackInterface {
    //public methods of ObjectStack class
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public void push(Object o);
    public Object pop();
    public Object top();

}