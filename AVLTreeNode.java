package algorithms;

/**
 * 
 * 平衡二叉树
 * 
 * @author five
 *
 */

public class AVLTreeNode{
	
	private int data;
	
	private int height;
	
	private AVLTreeNode left;
	
	private AVLTreeNode right;

	AVLTreeNode(){
		
	}
	
	AVLTreeNode(int data){
		this.data = data;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	
	AVLTreeNode(int data, int hight){
		this.data = data;
		this.height = height;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the left
	 */
	public AVLTreeNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public AVLTreeNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(AVLTreeNode right) {
		this.right = right;
	}
}