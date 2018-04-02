package algorithms;

import java.util.ArrayList;

import sun.misc.Queue;

/**
 * 
 * 通用树方法
 * 
 * @author five
 *
 */
public class TreeNodeMethod {

	/**
	 * 给定一棵树,设计算法来获取所有树的节点值之和
	 */
	public int FindSum(TreeNode root){
		if (root == null)
			return 0;
		return root.getData() + FindSum(root.getFirstChild()) + FindSum(root.getNextSibling());
	}
	
	/**
	 *   给定一个双亲节点数组P,其中P[i]是树的第i个结点的
	 * 双亲结点(假设根结点的双亲结点用-1表示).设计算法获取
	 * 树的高度或深度.
	 * 
	 * 例,如果数组P为:
	 *    -1 0 1 6 6 0 0 2 7
	 *    -------------------
	 *     0 1 2 3 4 5 6 7 8
	 *     
	 *    其对应的树为:
	 *                  0
	 *               /  |  \
	 *              5   1   6
	 *                 /   / \
	 *                2   3   4
	 *               /
	 *              7
	 *             /
	 *            8
	 */
	public int FindDepthInGenericTree(int[] P, int n){
		int maxDepth = 0, currentDepth = 0, j;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = n - 1; i > 0; i--){
			currentDepth = 0;
			
			if (list.contains(P[i]))
				continue;
			
			j = i;
			while(P[j] != -1){
				currentDepth++;
				list.add(P[j]);
				j = P[j];
			}
			
			if (currentDepth > maxDepth)
				maxDepth = currentDepth;
		}
		
		return maxDepth;
	}
	
	/**
	 * 给定通用树中的一个结点,设计算法来求其兄弟结点的个数
	 */
	public int SiblingsCount(TreeNode current){
		int count = 0;
		
		while(current.getNextSibling() != null){
			count++;
			current = current.getNextSibling();
		}
		
		return count;
	}
	
	/**
	 * 给定两棵树,判断这两棵树是否为同构树
	 */
	public boolean IsIsomorphic(TreeNode root1, TreeNode root2){
		if (root1 == root2)
			return true;
		
		if (root1 == null || root2 == null)
			return false;
		
		return (IsIsomorphic(root1.getFirstChild(), root2.getFirstChild())
				&& IsIsomorphic(root1.getNextSibling(), root2.getNextSibling()));
	}
	
	/**
	 * 给定两棵树,判断这两棵树是否为准同构树
	 */
	public boolean QuasiIsomorphic(TreeNode root1, TreeNode root2){
		if (root1 == root2)
			return true;
		
		if (root1 == null || root2 == null)
			return false;
		
		if (!QuasiIsomorphic(root1.getFirstChild(), root2.getFirstChild())){
			TreeNode node = root2;
			while (node.getNextSibling() != null){
				if (QuasiIsomorphic(root1.getFirstChild(), node.getFirstChild())){
					return true;
				}
			}
			return false;
		}
		
		return QuasiIsomorphic(root1.getFirstChild(), root2.getFirstChild())
				&& QuasiIsomorphic(root1.getNextSibling(), root2.getNextSibling());
	}
	
	/**
	 * 给定通用树中的一个结点,计算该结点的孩子节点个数
	 */
	public int ChildCount(TreeNode node){
		
		if (node == null)
			return 0;

		int count = 0;
		node = node.getFirstChild();
		
		if (node != null){
			count++;
			while(node.getNextSibling() != null){
				node = node.getNextSibling();
				count++;
			}
		}
		
		return count;
	}
}
