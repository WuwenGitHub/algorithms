package algorithms;

/**
 * 
 * 二叉树实现
 * 
 * @author five
 *
 */

public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private BinaryTreeNode<T> sibling = null;
	
	public BinaryTreeNode(){
		
	}
	
	public BinaryTreeNode(T data){
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * @return the sibling
	 */
	public BinaryTreeNode<T> getSibling() {
		return sibling;
	}

	/**
	 * @param sibling the sibling to set
	 */
	public void setSibling(BinaryTreeNode<T> sibling) {
		this.sibling = sibling;
	}
	
}
