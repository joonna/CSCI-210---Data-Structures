/**
 * Interface for ObjectQueue Class
 * @author Jonathan Kohler
 * @version 7/22/2019
 */
public interface ObjectQueueInterface {
	
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	public void insert(Object o);
	public Object remove();
	public Object query();
	
}