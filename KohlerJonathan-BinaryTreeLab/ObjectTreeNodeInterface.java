/**
* This is an interface which holds the signatures for ObjectTreeNode class.
* @author Jonathan Kohler
* @version 8/14/19
*/
public interface ObjectTreeNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setLeft(ObjectTreeNode p);
	public ObjectTreeNode getLeft();
	public void setRight(ObjectTreeNode p);
	public ObjectTreeNode getRight();
}
