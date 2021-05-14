// ObjectQueue.java class
// Class given code
/**
 * @author Class(not my code)
 * @version 7/24/19
 */
public class ObjectQueue {
    private Object[] item;
    private int front;
    private int rear;
    private int count;

    /**
     * This method is the default constructor for ObjectQueue.
     */
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * This method checks to see if the Queue is Empty.
     * @return count == 0
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * This method checks to see if the Queue is Full.
     * @return count == item.length
     */
    public boolean isFull() {
        return count == item.length;
    }

    /**
     * This method clears the object queue.
     */
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * This method inserts (pushes) an object into the rear of the queue.
     * @param o
     */
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }

    /**
     * This method removes(pops) an object at the front of the queue.
     * @return temp
     */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }

    /**
     * This method returns the object that is in front of the queue.
     * @return item[front]
     */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }

    /**
     * This method resizes the queue when full.
     * @param size
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}

