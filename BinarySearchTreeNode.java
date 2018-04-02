package algorithms;

/**
 * 
 * 搜索二叉树实现
 * 	节点类型为整型、浮点型
 * 
 * @author five
 *
 */

public class BinarySearchTreeNode extends BinaryTreeNode<Integer>{

	private Integer data;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	private BinarySearchTreeNode sibling = null;
	
	public BinarySearchTreeNode(){
		
	}
	
	public BinarySearchTreeNode(Integer data){
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public Integer getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Integer data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BinarySearchTreeNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinarySearchTreeNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	/**
	 * @return the sibling
	 */
	public BinarySearchTreeNode getSibling() {
		return sibling;
	}

	/**
	 * @param sibling the sibling to set
	 */
	public void setSibling(BinarySearchTreeNode sibling) {
		this.sibling = sibling;
	}
}
