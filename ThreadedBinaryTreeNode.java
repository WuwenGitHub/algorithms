package algorithms;

/**
 * 
 * 线索二叉树
 *   在二叉树空指针中存储前驱、后继节点信息
 *   
 * 分类: 
 *   左线索二叉树:
 *     在空左指针中存储前驱结点信息
 *   右线索二叉树:
 *     在空右指针中存储后继结点信息
 *   (满)线索二叉树:
 *     在空左指针中存储前驱结点信息,空右指针中存储后驱节点信息
 *   
 * 类型:
 *     前驱线索二叉树:
 *       空左指针中存储前序序列前驱信息,空右指针中存储前序序列后继信息
 *     中序线索二叉树:
 *       空左指针中存储中序序列前去信息,空右指针中存储中序序列后继信息
 *     后序线索二叉树:
 *       空左指针中存储后序序列前去信息,空右指针中存储后序序列后继信息
 *       
 *  线索二叉树结点形式:
 *    left(左) | LTag | data(数据) | RTag | Right(右)
 *    
 *  例:
 *   中序线索二叉树
 *                        LTag  data RTag
 *                          1    1    1
 *                           /       \
 *                       (1)5(0)   (1)11(1)
 *                         /         /  \
 *                     (0)2(0)  (0)16(0) (0)31(0)
 *   
 *   0  表示该结点不存在左/右孩子结点             left/right指向该结点在中序遍历中的前驱/后继结点
 *   1  表示该结点存在左/右孩子结点                 left/right指向左/右孩子结点
 *   
 *   中序遍历:
 *     2 5 1 16 11 31
 *     
 *   前序遍历:
 *     1 5 2 11 16 31
 *   
 *   后序遍历:
 *     2 5 16 31 11 1
 * 
 * @author five
 *
 */

public class ThreadedBinaryTreeNode{

	private ThreadedBinaryTreeNode left;
	
	private int LTag;
	
	private int data;
	
	private int RTag;
	
	private ThreadedBinaryTreeNode right;
	
	
	ThreadedBinaryTreeNode(){
		
	}
	
	ThreadedBinaryTreeNode(int data){
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public ThreadedBinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(ThreadedBinaryTreeNode left) {
		this.left = left;
	}

	/**
	 * @return the lTag
	 */
	public int getLTag() {
		return LTag;
	}

	/**
	 * @param lTag the lTag to set
	 */
	public void setLTag(int lTag) {
		LTag = lTag;
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
	 * @return the rTag
	 */
	public int getRTag() {
		return RTag;
	}

	/**
	 * @param rTag the rTag to set
	 */
	public void setRTag(int rTag) {
		RTag = rTag;
	}

	/**
	 * @return the right
	 */
	public ThreadedBinaryTreeNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(ThreadedBinaryTreeNode right) {
		this.right = right;
	}
	
	
}
