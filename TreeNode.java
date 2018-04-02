package algorithms;

/**
 * 
 * 通用树
 * 
 * @author five
 *
 */
public class TreeNode {

	private int data;
	private TreeNode firstChild;
	private TreeNode nextSibling;
	
	public TreeNode(){
		
	}
	
	public TreeNode(int data){
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the firstChild
	 */
	public TreeNode getFirstChild() {
		return firstChild;
	}

	/**
	 * @param firstChild
	 *            the firstChild to set
	 */
	public void setFirstChild(TreeNode firstChild) {
		this.firstChild = firstChild;
	}

	/**
	 * @return the nextSibling
	 */
	public TreeNode getNextSibling() {
		return nextSibling;
	}

	/**
	 * @param nextSibling
	 *            the nextSibling to set
	 */
	public void setNextSibling(TreeNode nextSibling) {
		this.nextSibling = nextSibling;
	}
}
