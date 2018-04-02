package algorithms;

/**
 * 
 * 二叉树实现
 * 	暂定节点类型为整型
 * 
 * @author five
 *
 */

public class BinaryTreeNodeOfInteger extends BinaryTreeNode<Integer>{

	private Integer data;
	private BinaryTreeNodeOfInteger left;
	private BinaryTreeNodeOfInteger right;
	private BinaryTreeNodeOfInteger sibling = null;
	
	public BinaryTreeNodeOfInteger(){
		
	}
	
	public BinaryTreeNodeOfInteger(Integer data){
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
	public BinaryTreeNodeOfInteger getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNodeOfInteger left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinaryTreeNodeOfInteger getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNodeOfInteger right) {
		this.right = right;
	}

	/**
	 * @return the sibling
	 */
	public BinaryTreeNodeOfInteger getSibling() {
		return sibling;
	}

	/**
	 * @param sibling the sibling to set
	 */
	public void setSibling(BinaryTreeNodeOfInteger sibling) {
		this.sibling = sibling;
	}
	
}
