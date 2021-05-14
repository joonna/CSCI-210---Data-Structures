/**
 * This class is an implementation of an Object Binary Tree which implements the ObjectBinaryTreeInterface.
 * @author Jonathan Kohler
 * @version 8/14/19
 */
public class ObjectBinaryTree implements ObjectBinaryTreeInterface {
    private ObjectTreeNode root;

    /**
     * This is the default constructor for ObjectBinaryTree.
     */
    public ObjectBinaryTree() {
        root = null;
    }

    /**
     * This method returns the root of the binary tree.
     * @return root
     */
    public ObjectTreeNode getRoot() {
        return root;
    }

    /**
     * This method sets the left child of a parent node to a node.
     * @param parent
     * @param r
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }

    /**
     * This method sets the right child of a parent node to a node.
     * @param parent
     * @param r
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }

    /**
     * This method inserts an object to a binary search tree and uses TreeComparable
     * to decide where to place it.
     * @param o
     */
    public void insertBST(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }

    /**
     * This method inserts an object to the binary search tree and deals with duplicate objects.
     * @param o
     */
    public void insertBSTDup(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
        }
    }

    /**
     * This method does a search on the binary tree.
     * @param o
     * @return p
     * @return null
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if(root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                    p = p.getRight();
                else
                    return p;
            }
        }
        return null;
    }

    /**
     * This method does a pre-order traversal on the binary tree.
     * @param tree
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }

    /**
     * This method does a in-order traversal on the binary tree.
     * @param tree
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }

    /**
     * This method does a post-order traversal on the binary tree.
     * @param tree
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }
}