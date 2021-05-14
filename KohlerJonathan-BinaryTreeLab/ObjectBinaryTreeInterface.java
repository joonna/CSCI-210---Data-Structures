/**
* This is an interface which holds the signatures for ObjectBinaryTree class.
* @author Jonathan Kohler
* @version 8/15/19
*/
public interface ObjectBinaryTreeInterface {
	public ObjectTreeNode getRoot();
	public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void insertBST(Object o);
	public void insertBSTDup(Object o);
	public ObjectTreeNode searchBST(Object o);
	public void preTrav(ObjectTreeNode tree);
	public void inTrav(ObjectTreeNode tree);
	public void postTrav(ObjectTreeNode tree);
}
