/**
 * ObjectStack Class is a single stack class that can hold objects
 *
 * @author Jonathan Kohler
 * @version 7/3/2019
 */
public class ObjectStack implements ObjectStackInterface{

    private Object[] item;
    private int top;

    /**
     * Constructor for objects of class ObjectStack
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }

    /**
     * Checks if the stack is empty
     * @return false if top does not equal -1 
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * isFull evaluates if the stack is full
     * @return false if top does not equal item array max size     
     */
    public boolean isFull()
    {
        return top == item.length-1;
    }

    /**
     * Clears all of the elements from the stack
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }

    /**
     * Pushes a new element on top of the stack
     * @param temp Object to be pushed onto stack
     */
    public void push(Object o) {
        if (top == item.length-1) {
            resize(2 * item.length);
        }
        item[++top] = o;
    }

    /**
     * resize method doubles the array once the stack is filled 
     * 
     * @param size size of the array
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++) {
            temp[i] = item[i];
        }
        item = temp;
    }

    /**
     * Pops last element from the end of the stack
     * @return temp 
     */
    public Object pop() {
        if (isEmpty()) { 
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null; 
        if (top == item.length/4) {
            resize(item.length/2); 
        }
        return temp;
    }

    /**
     * Extracts the top of stack
     * @return item[top] this is the top of the stack
     */
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }

        return item[top];
    }

}
