package algorithms;

public class Test {
	public static void main(String args[]) {
		/**
		 *        1
		 *      /   \
		 *     5     11
		 *    /     /  \
		 *   2     16  31
		 *   
		 *   
		 * 中序遍历:
		 *   2 5 1 16 11 31
		 *   
		 * 前序遍历:
		 *    1 5 2 11 16 31
		 *    
		 * 后序遍历:
		 *    2 5 16 31 11 1
		 */
		/*int data[] = {2, 5, 1, 3, 6, 4, 7, 8, 9};
		BinarySearchTreeNode root = new BinarySearchTreeMethod().createTree(data);
		new BinarySearchTreeMethod().preOrder(root);
		System.out.println();
		
		BinarySearchTreeNode node =new BinarySearchTreeMethod().FindLCA(root, new BinarySearchTreeNode(1), new BinarySearchTreeNode(5));
		System.out.println(node.getData());
		
		int inOrder[] = {1,2,5,11,16,31};
		int preOrder[] = {11,2,1,5,16,31};
		BinaryTreeNode<Integer> roo = new BinaryTreeMethod2().InitBuildBinaryTree(inOrder, preOrder, 0, 5);
		BinaryTreeNode<Integer> roo2 = new BinaryTreeMethod2().InitBuildBinaryTree(inOrder, preOrder, 0, 5);
		
		BinaryTreeMethod2 method = new BinaryTreeMethod2();
		int i = method.SumOfBT(roo);
		System.out.println(i);*/
		
		/*int data[] = {2, 5, 1, 3, 6, 4, 7, 8, 9};*/
		int data[] = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		new Sort().heapSort(data);
		//AVLTreeNode root = new AVLTreeMethod().createAVLTree(data);
		
		//System.out.println(root);
	}
}
