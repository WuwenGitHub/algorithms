package algorithms;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * 中序线索二叉树方法
 * 
 * @author five
 *
 */

public class ThreadedBinaryTreeMethod {
	
	/**
	 * 
	 * 根据二叉树生成中序线索二叉树
	 * 
	 *  1.根据二叉树生成具有相同结构的线索二叉树
	 *  
	 *  2.根据二叉树的中序遍历结果,对各结点的left、LTag、right、RTag进行更改
	 *     当某结点的左右孩子结点存在时,left、right分别指向该结点的左右孩子结点,LTag、RTag均为1
	 *     当某结点的左右孩子结点不存在时,left、right将分别指向该结点在中序遍历结果中的前驱、后继结点
	 * 
	 * @param root
	 * @return
	 * 
	 */
	public ThreadedBinaryTreeNode createThreadedBinaryTree(BinaryTreeNodeOfInteger root){
		
		/*
		 * 线索二叉树的起始节点哑结点Dummy
		 * 
		 *        右标签(RTag)    右孩子指针
		 *  所有                1                              自身
		 *  
		 *        左标签(LTag)    左孩子指针
		 *  空树                0                              自身
		 *  非空                1                            头结点
		 */
		ThreadedBinaryTreeNode dummy = new ThreadedBinaryTreeNode();
		dummy.setRight(dummy);
		dummy.setRTag(1);
		
		if (root == null){
			dummy.setLeft(dummy);
			dummy.setLTag(0);
			return dummy;
		}
		
		//第一步:复制
		ThreadedBinaryTreeNode tbTree = new ThreadedBinaryTreeNode(root.getData());
		tbTree.setLTag(root.getLeft() != null ? 1 : 0);
		tbTree.setLeft(method1(root.getLeft()));
		tbTree.setRTag(root.getRight() != null ? 1 : 0);
		tbTree.setRight(method1(root.getRight()));
		
		//第二步:更改左右结点,及LTag、RTag
//		LinkedList<ThreadedBinaryTreeNode> treeList = InOrderNonRecursive(tbTree);
		method2(tbTree, dummy);
		dummy.setLTag(1);
		dummy.setLeft(tbTree);
		
//		return tbTree;
		return dummy;
	}
	
	//1.复制
	private ThreadedBinaryTreeNode method1(BinaryTreeNodeOfInteger root){
		if (root == null)
			return null;
		
		ThreadedBinaryTreeNode node = new ThreadedBinaryTreeNode(root.getData());
		node.setLTag(root.getLeft() != null ? 1 : 0);
		node.setLeft(method1(root.getLeft()));
		node.setRTag(root.getRight() != null ? 1 : 0);
		node.setRight(method1(root.getRight()));
		
		return node;
	}
	
	//2.更改
	private void method2(ThreadedBinaryTreeNode tbNode, ThreadedBinaryTreeNode dummy){
		if (tbNode == null)
			return;
		ThreadedBinaryTreeNode node = null;
		
		Stack<ThreadedBinaryTreeNode> s = new Stack<ThreadedBinaryTreeNode>();
		LinkedList<ThreadedBinaryTreeNode> list = new LinkedList<ThreadedBinaryTreeNode>();
		
		while (true) {
			while (tbNode != null) {
				s.push(tbNode);
				tbNode = tbNode.getLTag() == 1 ? tbNode.getLeft() : null;
			}
			
			if (s.isEmpty())
				break;
			tbNode = s.pop();
			
			if (tbNode.getLTag() == 0)
				tbNode.setLeft(node);
			node = tbNode;
			
			if (tbNode.getRTag() == 1)
				tbNode = tbNode.getRight();
			else{
				//到最后一个结点时栈为空
				if (s.isEmpty())
					break;
				tbNode.setRight(s.peek());
				tbNode = null;
			}
		}
		
		node = tbNode;
		while(node.getLTag() == 1){
			node = node.getLeft();
		}
		node.setLeft(dummy);
		
		node = tbNode;
		while(node.getRTag() == 1){
			node = node.getRight();
		}
		node.setRight(dummy);
	}
	
	/**
	 * 
	 * 找到给定结点中序序列后继结点
	 * 
	 * @param P
	 * @return
	 * 
	 */
	public ThreadedBinaryTreeNode InorderSuccessor(ThreadedBinaryTreeNode P){
		
		if (P == null)
			return null;
		
		if (P.getRTag() == 0)
			return P.getRight();
		else{
			P = P.getRight();
			while(P.getLTag() == 1)
				P = P.getLeft();
			return P;
		}
	}
	
	/**
	 * 
	 * 中序索引二叉树的中序遍历(方式一)
	 * 
	 * @param root
	 * 
	 */
	public void InorderTraversal(ThreadedBinaryTreeNode root){
		ThreadedBinaryTreeNode P = InorderSuccessor(root);
		
		while(P != root){
			System.out.println(P.getData());
			P = InorderSuccessor(P);
		}
	}
	
	/**
	 * 
	 * 中序线索二叉树中查找前序后继(前序遍历后继结点)
	 *
	 * @param P
	 * @return
	 * 
	 */
	public ThreadedBinaryTreeNode PreorderSuccessor(ThreadedBinaryTreeNode P){
		
		if (P.getLTag() == 1)
			return P.getLeft();
		
		while (P.getRTag() == 0)
			P = P.getRight();
		return P.getRight();
	}
	
	/**
	 * 
	 * 中序遍历二叉树的前序遍历
	 * 
	 * @param root
	 */
	public void PreorderTraversal(ThreadedBinaryTreeNode root){
		ThreadedBinaryTreeNode P;
		P = PreorderSuccessor(root);
		
		while(P != root){
			System.out.println(P.getData());
			P = PreorderSuccessor(P);
		}
	}
	
	/**
	 * 
	 * 在中序二叉树中插入结点(右侧插入)
	 *   1. P没有右孩子结点
	 *        ==>直接插入,并改变P、Q的左右孩子结点和标签
	 * 
	 *   2. P有孩子结点R
	 *        ==>将Q结点插入到P、R结点之间
	 * 
	 * @param P  被插入结点
	 * @param Q  插入结点
	 */
	public void InsertRightInInorderTBT(ThreadedBinaryTreeNode P, ThreadedBinaryTreeNode Q){
		if (Q == null)
			return;
		
		//空树  ==> 仅有哑结点Dummy
		if (P.getRTag() == 1 && P.getRight() == P){
			P.setLTag(1);
			P.setLeft(Q);
			
			Q.setLeft(P);
			Q.setLTag(0);
			
			Q.setRight(P);
			Q.setRTag(0);
			return;
		}
		
		ThreadedBinaryTreeNode node = P.getRight();
		P.setRTag(1);
		P.setRight(Q);
		
		Q.setLTag(0);
		Q.setLeft(P);
		Q.setRTag(P.getRTag());
		Q.setRight(P.getRight());
		
		while (node.getLTag() == 1) {
			node = node.getLeft();
		}
		node.setLeft(Q);
	}
}
