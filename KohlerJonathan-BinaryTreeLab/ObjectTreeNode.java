/**
 * This is an implementation of an Object Tree Node which implements the ObjectTreeNodeInteferace.
 * @author Jonathan Kohler
 * @version 8/12/19
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;

    /**
     * This is the default constructor for ObjectTreeNode.
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }

    /**
     * This is a constructor to create an object tree node with object o.
     * @param o
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }

    /**
     * This method sets the the info field of the node to object o.
     * @param o
     */
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * This method gets the info field on a node.
     * @return info
     */
    public Object getInfo() {
        return info;
    }

    /**
     * This method sets the left node to p.
     * @param p
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }

    /**
     * This method gets the left node.
     * @return left
     */
    public ObjectTreeNode getLeft() {
        return left;
    }

    /**
     * This method sets the right node to p.
     * @param p
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }

    /**
     * This method gets the right node.
     * @return right
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}
