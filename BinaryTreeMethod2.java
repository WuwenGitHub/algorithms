package algorithms;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.Queue;

public class BinaryTreeMethod2 {

	/**
	 * 前序遍历 : 根左右 递归实现
	 * 
	 * @param binaryTreeNode
	 */
	public void preOrder(BinaryTreeNode<Integer> binaryTreeNode) {
		if (binaryTreeNode != null) {
			System.out.println(binaryTreeNode.getData());
			preOrder(binaryTreeNode.getLeft());
			preOrder(binaryTreeNode.getRight());
		}
	}

	/**
	 * 前序遍历 使用栈记录根结点
	 * 
	 * @param root
	 */
	public void preOrderNonRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();

			while (true) {
				while (root != null) {
					System.out.println(root.getData());
					s.push(root);
					root = root.getLeft();
				}
				if (s.isEmpty())
					break;
				root = s.pop();
				root = root.getRight();
			}
		}
	}

	/**
	 * 
	 * 中序遍历 递归
	 * 
	 * @param root
	 */
	public void InOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public void InOrderNonRecursive(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();

		while (true) {
			while (root != null) {
				s.push(root);
				root = root.getLeft();
			}

			if (s.isEmpty())
				break;
			root = s.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
		return;
	}

	/**
	 * 后序遍历 递归
	 * 
	 * @param root
	 */
	public void PostOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public void PostOrderNonRecursive(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();
		while (true) {
			if (root != null) {
				s.push(root);
				root = root.getLeft();
			} else {

				if (s.isEmpty()) {
					System.out.println("Stack is Empty!");
					return;
				} else {
					if (s.peek().getRight() == null) {
						root = s.pop();
						System.out.println(root.getData());

						while (root == s.peek().getRight()) {
							root = s.pop();
							System.out.println(root.getData());

							if (s.isEmpty())
								return;
						}
					}

					if (!s.isEmpty()) {
						root = s.peek().getRight();
					} else
						root = null;
				}
			}
		}
	}

	/**
	 * 层次遍历
	 * 
	 */
	public void LevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root == null)
			return;

		q.enqueue(root);
		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();
				System.out.println(temp.getData());

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找二叉树中最大元素 递归方法
	 * 
	 * @param root
	 * @return
	 */
	public int FindMax(BinaryTreeNode<Integer> root) {
		int root_val, left, right, max = Integer.MIN_VALUE;

		if (root != null) {
			root_val = root.getData();

			left = FindMax(root.getLeft());

			right = FindMax(root.getRight());

			max = (max = root_val > left ? root_val : left) > right ? max : right;
		}
		return max;
	}

	/**
	 * 查找二叉树中的最大元素 一般方法
	 * 
	 * @param root
	 * @return
	 */
	public int FindMaxUsingLevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		try {
			q.enqueue(root);
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (max < temp.getData())
					max = temp.getData();

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return max;
	}
	
	/**
	 * 查找二叉树中最小元素
	 * 
	 * @param root
	 * @return
	 */
	public int FindMin(BinaryTreeNode<Integer> root){
		int root_val, left, right, min = Integer.MAX_VALUE;
		
		if (root != null){
			root_val = root.getData();
			
			left = FindMin(root.getLeft());

			right = FindMin(root.getRight());

			min = (min = root_val < left ? root_val : left) < right ? min : right;
		}
		
		return min;
	}

	/**
	 * 在二叉树中搜索某个元素 递归法
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public Boolean FindInBinaryTreeUsingRecursion(BinaryTreeNode<Integer> root, int data) {
		Boolean temp = false;

		if (root == null)
			return false;

		if (data == root.getData())
			return true;

		if (root.getLeft() != null) {
			temp = FindInBinaryTreeUsingRecursion(root.getLeft(), data);
			if (temp == true)
				return temp;
		}

		if (root.getRight() != null)
			temp = FindInBinaryTreeUsingRecursion(root.getRight(), data);

		return temp;
	}

	/**
	 * 在二叉树中搜索某个元素 非递归法
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public Boolean SearchUsingLevelOrder(BinaryTreeNode<Integer> root, int data) {
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root == null)
			return false;
		q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getData() == data)
					return true;

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 获取二叉树结点个数 递归
	 * 
	 */
	public int SizeOfBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return SizeOfBinaryTree(root.getLeft()) + 1 + SizeOfBinaryTree(root.getRight());
	}

	/**
	 * 获取二叉树结点个数 非递归方法
	 * 
	 * @param root
	 * @return
	 */
	public int SizeOfBTusingLevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();
		int count = 0;

		if (root == null)
			return 0;

		q.enqueue(root);
		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();
				count++;

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * 逆向逐层输出树中元素
	 * 
	 * @param root
	 */
	public void LevelOrderTraversalInReverse(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();

		if (root == null)
			return;
		q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());

				s.push(temp);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (!s.isEmpty())
			System.out.println(s.pop().getData());
	}

	/**
	 * 求二叉树的高度(深度) 递归
	 * 
	 * @param root
	 * @return
	 */
	public int HeightOfBinaryTree(BinaryTreeNode<Integer> root) {
		int leftHeight = 0, rightHeight = 0;

		if (root == null)
			return 0;

		if (root.getLeft() != null)
			leftHeight = HeightOfBinaryTree(root.getLeft());

		if (root.getRight() != null)
			rightHeight = HeightOfBinaryTree(root.getRight());

		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;

	}

	/**
	 * 求二叉树的深度
	 * 
	 * @param root
	 * @return
	 */
	public int FindHeightOfBinaryTree(BinaryTreeNode<Integer> root) {
		int level = 1;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp;

		if (root == null)
			return 0;
		q.enqueue(root);
		q.enqueue(null);
		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp == null) {
					if (!q.isEmpty()) {
						q.enqueue(null);
						level++;
					}
				} else {
					if (temp.getLeft() != null)
						q.enqueue(temp.getLeft());
					if (temp.getRight() != null)
						q.enqueue(temp.getRight());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return level;
	}

	/**
	 * 查找二叉树中最深节点
	 * 
	 * @param root
	 * @return
	 */
	BinaryTreeNode<Integer> DeepestNodeinBinaryTree(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp = null;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return temp;
	}

	/**
	 * 获取二叉树中叶子节点的个数 非递归法
	 * 
	 * @param root
	 * @return
	 */
	public int NumberOfLeavesInBTusingLevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		int count = 0;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root != null)
			q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getLeft() != null) {
					q.enqueue(temp.getLeft());
				}

				if (temp.getRight() != null) {
					q.enqueue(temp.getRight());
				}
				
				if (temp.getLeft() == null && temp.getRight() == null)
					count++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * 查找二叉树中满结点的个数 非递归法
	 * 
	 * @param root
	 * @return
	 */
	public int NumberOfFullNodesInBTusingLevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		int count = 0;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root != null)
			q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());

				if (temp.getLeft() != null && temp.getRight() != null)
					count++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * 查找二叉树中的半结点 非递归法
	 * 
	 * @param root
	 * @return
	 */
	public int NumberOfHalfNodeInBTLevelOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		int count = 0;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root != null)
			q.enqueue(root);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());

				if (temp.getRight() != null)
					q.enqueue(temp.getRight());

				if ((temp.getLeft() != null && temp.getRight() == null)
						|| (temp.getLeft() == null && temp.getRight() != null))
					count++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 比较两棵树的结构是否相同 递归法
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean AreStructurullySameTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return (root1.getData() == root2.getData()) && (AreStructurullySameTrees(root1.getLeft(), root2.getLeft()))
				&& (AreStructurullySameTrees(root1.getRight(), root2.getRight()));
	}

	/**
	 * 求二叉树直径(有错) 树的直径 树中两个叶子结点之间的最长路径中的节点个数 即左子树最深结点与右子树最深结点间的结点个数
	 * 
	 * @param root
	 * @param diameter
	 * @return
	 */
	public int DiameterOfTree(BinaryTreeNode<Integer> root, int diameter) {
		int left, right;

		if (root == null)
			return 0;

		left = DiameterOfTree(root.getLeft(), diameter);
		right = DiameterOfTree(root.getRight(), diameter);

		if (left + right > diameter)
			diameter = left + right;
		return Math.max(left, right) + 1;
	}

	/**
	 * 二叉树的直径 Example: Given a binary tree 
	 *     1 
	 *    / \
	 *   2   3 
	 *  / \ 
	 * 4   5 
	 * Return 3, which is
	 * the length of the path [4,2,1,3] or [5,2,1,3].
	 * 
	 * @param root
	 * @return
	 */
	public int DiameterOfTree2(BinaryTreeNode<Integer> root) {
		int left, right;

		if (root == null)
			return 0;

		left = FindHeightOfBinaryTree(root.getLeft());
		right = FindHeightOfBinaryTree(root.getRight());

		return left + right;
	}

	/**
	 * 查找二叉树中同一层结点数据之和最大的层
	 * 
	 * @param root
	 * @return
	 */
	public int FindLevelwithMaxSum(BinaryTreeNode<Integer> root) {
		int level = 1, maxLevel = 1;
		int sum = 0, maxSum = 0;
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();

		if (root == null)
			return 0;

		q.enqueue(root);
		q.enqueue(null);

		try {
			while (!q.isEmpty()) {
				temp = q.dequeue();

				if (temp == null) {
					if (sum > maxSum) {
						maxSum = sum;
						maxLevel = level;
					}

					if (!q.isEmpty())
						q.enqueue(null);
					sum = 0;
					level++;
				} else {
					sum += temp.getData();

					if (temp.getLeft() != null)
						q.enqueue(temp.getLeft());

					if (temp.getRight() != null)
						q.enqueue(temp.getRight());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return maxLevel;
	}

	/**
	 * 输出所有从根节点到叶子节点的路径
	 * 
	 * @param node
	 */
	public void printPaths(BinaryTreeNode<Integer> node) {
		int[] path = new int[256];
		printPaths(node, path, 0);
	}

	private void printPaths(BinaryTreeNode<Integer> root, int[] path, int pathLen) {
		if (root == null)
			return;
		// 将该节点添加到路径中
		path[pathLen++] = root.getData();
		// 当前结点为叶子节点,所以输出到这里的路径
		if (root.getLeft() == null && root.getRight() == null)
			printArray(path, pathLen);
		// 否则,继续遍历两棵子树
		else {
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}
	}

	private void printArray(int[] path, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 判断是否存在路径的数据和等于给定值
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
		int[] path = new int[256];
		return hasPathSum(root, sum,  path, 0);
	}

	private boolean hasPathSum(BinaryTreeNode<Integer> root, int sum,  int[] path,int pathLen) {
		// 如果所有节点都已被访问,且sum==0,则返回true
		if (root == null) {
			if (sum == 0)
				printArray(path, pathLen);
			return (sum == 0);
		}
		// 否则,检查两棵子树
		else {
			path[pathLen++] = root.getData();
			int subSum = sum - root.getData();
			return (hasPathSum(root.getLeft(),subSum, path, pathLen) || hasPathSum(root.getRight(), subSum, path, pathLen));
		}
	}
	
	/**
	 * 求所有节点数据之和
	 *   递归求出左子树和右子树的和
	 * 
	 * @param root
	 * @return
	 */
	public int SumOfBT(BinaryTreeNode<Integer> root){
		if (root == null)
			return 0;
		return root.getData() + SumOfBT(root.getLeft()) + SumOfBT(root.getRight());
	}
	
	/**
	 * 求所有节点数据之和
	 *   非递归方法
	 * 
	 * @param root
	 * @return
	 */
	public int SumOfBTUsingLevelOrder(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();
		int sum = 0;
		
		if (root == null)
			return sum;
		q.enqueue(root);
		try{
		while(!q.isEmpty()){
			temp = q.dequeue();
			sum += temp.getData();
			if (temp.getLeft() != null)
				q.enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.enqueue(temp.getRight());
		}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return sum;
	}
	
	/**
	 * 将一棵树转化为其镜像
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode<Integer> MirrorOfBinaryTree(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> temp;
		if (root != null){
			MirrorOfBinaryTree(root.getLeft());
			MirrorOfBinaryTree(root.getRight());
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}
	
	/**
	 * 给定两棵树,判断他们是否为镜像
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public boolean AreMirrors(BinaryTreeNode<Integer> tree1, BinaryTreeNode<Integer> tree2){
		if (tree1 == null && tree2 == null)
			return true;
		if (tree1 == null || tree2 == null)
			return false;
		if (tree1.getData() != tree2.getData())
			return false;
		return (AreMirrors(tree1.getLeft(), tree2.getRight()) && AreMirrors(tree1.getRight(), tree2.getLeft()));
	}
	
	/**
	 * 根据中序遍历和前序遍历来构建二叉树
	 * 
	 */
	static int preIndex = 0;
	public BinaryTreeNode<Integer> InitBuildBinaryTree(int inOrder[], int preOrder[], int inStart, int inEnd){
		preIndex = 0;
		return BuildBinaryTree(inOrder, preOrder, inStart, inEnd);
	}
	@SuppressWarnings("unused")
	public BinaryTreeNode<Integer> BuildBinaryTree(int inOrder[], int preOrder[], int inStart, int inEnd){
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>();
		if (inStart > inEnd)
			return null;
		if (newNode == null){
			System.out.println("Memory Error");
			return null;
		}
		//利用preIndex在前序序列中选择当前结点
		newNode.setData(preOrder[preIndex]);
		preIndex++;
		//若该节点没有孩子节点则返回
		if (inStart == inEnd){
			return newNode;
		}
		//否则在中序序列中找到该节点的索引
		int inIndex = Search(inOrder, inStart, inEnd, newNode.getData());
		//利用中序序列中节点的索引分别建立左子树和右子树
		newNode.setLeft(BuildBinaryTree(inOrder, preOrder, inStart, inIndex - 1));
		newNode.setRight(BuildBinaryTree(inOrder, preOrder, inIndex + 1, inEnd));
		return newNode;
	}
	
	private int Search(int arr[], int start, int end, int data){
		for (int i = start; i <= end; i++){
			if (arr[i] == data)
				return i;
		}
		return -1;
	}
	
	/**
	 * 遍历二叉树中某节点的所有祖先节点
	 *   递归法 
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public boolean PrintAllAncestors(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node){
		if (root == null)
			return false;
		
		if (root.getData()  == node.getData()){
			System.out.println(root.getData());
			return true;
		}
		
		if ((root.getLeft() != null && root.getLeft().getData() == node.getData())
				|| (root.getRight() != null && root.getRight().getData() == node.getData())
				|| PrintAllAncestors(root.getLeft(), node)
				|| PrintAllAncestors(root.getRight(), node)){
			System.out.println(root.getData());
			return true;
		}
		
		return false;
	}
	
	/**
	 * 查找二叉树中两个节点的最近公共祖先(LCA)
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
		BinaryTreeNode<Integer> left, right;
		
		if (root == null)
			return null;
		
		if (root.getData() == node1.getData() || root.getData() == node2.getData())
			return root;
		
		left = LCA(root.getLeft(), node1, node2);
		right = LCA(root.getRight(), node1, node2);
		
		if (left != right && (left != null && right != null))
			return root;
		
		return left != null ? left : right;
	}
	
	/**
	 * Zigzag顺序遍历二叉树
	 * 例:
	 *       1
	 *     /   \
	 *    2     3
	 *   / \   / \
	 *  4   5 6   7
	 *  输出:
	 *     1 3 2 4 5 6 7
	 * 
	 * @param root
	 */
	public void ZigZagTraversal(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp;
		int leftOrRight = 1;
		Stack<BinaryTreeNode<Integer>> currentLevel = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> nextLevel = new Stack<BinaryTreeNode<Integer>>();
		
		currentLevel.push(root);

		while (!currentLevel.isEmpty()) {
			
			temp = currentLevel.pop();
			System.out.print(temp.getData() + " ");
			
			if (leftOrRight == 1) {
				if (temp.getLeft() != null)
					nextLevel.push(temp.getLeft());
				if (temp.getRight() != null)
					nextLevel.push(temp.getRight());
			} else {
				if (temp.getRight() != null)
					nextLevel.push(temp.getRight());
				if (temp.getLeft() != null)
					nextLevel.push(temp.getLeft());
			}
			
			if (currentLevel.isEmpty()) {
				leftOrRight -= 1;
				currentLevel = nextLevel;
				nextLevel = new Stack<BinaryTreeNode<Integer>>();
			}
		}
	}
	
	/**
	 * 找到二叉树的垂直和(散列表实现)
	 * 例:
	 *          1
	 *        /  \
	 *      2     3
	 *     / \   / \
	 *    4   5 6   7
	 * 输出:
	 *    4 2 12 3 7
	 * 
	 * @param root
	 * @param column
	 */
	public void VerticalSumInBinaryTree(BinaryTreeNode<Integer> root, int column){
		
	}
	
	/**
	 * 构建树
	 *   假设一棵树,叶子结点用"L"表示,内部节点用"I"表示,同时假设每个结点只能有0个或2个孩子结点.
	 * 根据这棵树的前序遍历,构建这棵树
	 * 例:
	 *   给出前序序列为 => ILILL
	 *       I
	 *      / \
	 *     L   I
	 *        / \
	 *       L   L
	 * 
	 * @param A
	 * @return
	 */
	public BinaryTreeNode<Integer> BuildTreeFormPreOrder(char[] A){
		if (A == null)
			return null;
		BinaryTreeNode<Integer> temp;
		Queue<BinaryTreeNode<Integer>> qTree = new Queue<>();
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>((int) A[0]);
		int i = 0;
		newNode.setLeft(null);
		newNode.setRight(null);
		i++;
		qTree.enqueue(newNode);
		temp = newNode;
		
		try{
			while (i < A.length) {
				BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>((int) A[i]);
				node.setLeft(null);
				node.setRight(null);
				
				if (temp.getLeft() == null)
					temp.setLeft(node);
				else
					temp.setRight(node);
				
				if (A[i] == 'L') {
					if (qTree.isEmpty())
						break;
					temp = qTree.dequeue();
				}
				
				if (A[i] == 'I'){
					qTree.enqueue(node);
					temp = node;
				}
				i++;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		return newNode;
	}
	
	public BinaryTreeNode<Integer> BuildTreeFormPreOrder(char[] A, int  i){
		if (A == null)
			return null;
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>((int) A[i]);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		//到达一个叶子节点,返回
		if (A[i] == 'L')
			return newNode;
		
		i++;
		newNode.setLeft(BuildTreeFormPreOrder(A, i));
		i++;
		newNode.setRight(BuildTreeFormPreOrder(A, i));
		
		return newNode;
	}
	
	/**
	 * 给定一个带有3个指针(左指针,右指针,下一个兄弟指针)的二叉树,
	 * 设下一个兄弟指针初始化为空,设计算法来填充下一个兄弟指针
	 * 
	 * @param root
	 */
	//书上方法,与法二有冲突
	public void FillNextSiblings1(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> qTree = new Queue<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp;
		
		if (root == null)
			return;
		
		qTree.enqueue(root);
		qTree.enqueue(null);
		
		try{
			while (!qTree.isEmpty()) {
				temp = qTree.dequeue();
				
				if (temp == null){
					if (!qTree.isEmpty())
						qTree.enqueue(null);
				}else{
					BinaryTreeNode<Integer> node = qTree.dequeue();
					Queue<BinaryTreeNode<Integer>> q =new Queue<BinaryTreeNode<Integer>>();
					temp.setSibling(node);
					q.enqueue(node);
					
					while(!qTree.isEmpty())
						q.enqueue(qTree.dequeue());
					qTree = q;
					
					if (temp.getLeft() != null)
						qTree.enqueue(temp.getLeft());
					if (temp.getRight() != null)
						qTree.enqueue(temp.getRight());
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void FillNextSiblings2(BinaryTreeNode<Integer> root){
		if (root == null)
			return;
		
		if (root.getLeft() != null)
			root.getLeft().setSibling(root.getRight());
		
		if (root.getRight() != null){
			if (root.getSibling() != null)
				root.getRight().setSibling(root.getSibling().getLeft());
			else
				root.getRight().setSibling(null);
		}
		FillNextSiblings2(root.getLeft());
		FillNextSiblings2(root.getRight());
	}
	
	public void FillNextSiblings3(BinaryTreeNode<Integer> root){
		if (root == null)
			return;
		
		Queue<BinaryTreeNode<Integer>> qTree = new Queue<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> sign = new BinaryTreeNode<Integer>(-1);
		BinaryTreeNode<Integer> temp;
		qTree.enqueue(root);
		qTree.enqueue(null);
		
		try{
			while (!qTree.isEmpty()) {
				temp = qTree.dequeue();
				if (temp != sign){

					if (temp == null) {
						if (!qTree.isEmpty()) {
							qTree.enqueue(null);
						}
					} else {
						BinaryTreeNode<Integer> left = sign;
						BinaryTreeNode<Integer> right = sign;

						BinaryTreeNode<Integer> node = qTree.dequeue();
						Queue<BinaryTreeNode<Integer>> q = new Queue<BinaryTreeNode<Integer>>();
						q.enqueue(node);

						while (!qTree.isEmpty()) {
							q.enqueue(qTree.dequeue());
						}
						qTree = q;

						if (temp.getLeft() != null) {
							left = temp.getLeft();
//							qTree.enqueue(temp.getLeft());
						}
						if (temp.getRight() != null) {
							right = temp.getRight();
//							qTree.enqueue(temp.getRight());
						}
						qTree.enqueue(left);
						qTree.enqueue(right);

						if (node == sign)
							temp.setSibling(null);
						else
							temp.setSibling(node);
					}
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 给定两棵树,判断这两棵二叉树树是否为同构树(结点的值不影响两棵树是否同构)
	 * 
	 * 例:
	 *       1                  1                     1
	 *     /   \              /   \                 /   \
	 *    2     3            5     6               5     6
	 *   / \    /             \   / \             / \   /
	 *  4   5  6               2 8   3           3   2 8
	 *     /  /                 \ \                 / /
	 *    7  8                   4 7               7 4
	 *    
	 *    树一                                               树二                                           树三
	 *    
	 *  ===>  树一、三同构
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean IsIsomorphic(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2){
		if (root1 == root2)
			return true;
		
		if (root1 == null || root2 == null)
			return false;
		
		return (IsIsomorphic(root1.getLeft(), root2.getLeft()) 
				&& IsIsomorphic(root1.getRight(), root2.getRight()));
	}
	
	/**
	 * 给定两棵树,判断这两棵二叉树树是否为准同构树(结点数据不重要,形状才是重点)
	 *  ==>交换某些节点的孩子节点,能使两棵树同构
	 * 例:
	 *       1                  1
	 *     /   \              /   \
	 *    2     3            5     6
	 *   / \    /             \   / \
	 *  4   5  6               2 8   3
	 *     /  /                 \ \
	 *    7  8                   4 7
	 *    
	 *    树一                                               树二
	 *    
	 *  ===> 为准同构
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean QuasiIsomorphic(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2){
		if (root1 == root2)
			return true;
		
		if (root1 == null || root2 == null)
			return false;
		
		return QuasiIsomorphic(root1.getLeft(), root2.getLeft())
				|| QuasiIsomorphic(root1.getLeft(), root2.getRight())
				|| QuasiIsomorphic(root1.getRight(), root2.getLeft())
				|| QuasiIsomorphic(root1.getRight(), root2.getRight());
	}
	
	/**
	 * 表达式树
	 *   用来表示表达式的树,由二元表达式组成
	 *   
	 *   叶子结点    : 操作数
	 *   非叶子节点: 操作符
	 */
	
	/**
	 * 
	 * 基于后缀表达式来构建表达式树
	 * 
	 * @param postfixExpr
	 * @param size
	 * @return
	 */
	public BinaryTreeNode<Integer> BuildExprTree(char postfixExpr[], int size){
		Stack<BinaryTreeNode<Integer>> s = new Stack<>();
		//验证是否为数字
//		String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
		String regex = "\\+|\\-|\\*|\\/";
		
		//1.编译正则表达式
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		
		for (int i = 0; i < postfixExpr.length; i++){
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>((int) postfixExpr[i]);
			matcher = pattern.matcher(postfixExpr[i] + "");
			
			if (matcher.matches()){
				BinaryTreeNode<Integer> node1 = s.pop();
				BinaryTreeNode<Integer> node2 = s.pop();
				node.setRight(node1);
				node.setLeft(node2);
				s.push(node);
			}else{
				node.setLeft(null);
				node.setRight(null);
				s.push(node);
			}
		}
		
		return s.pop();
	}
	
	/**
	 * 
	 * 判断一棵给定的二叉树是否为BST树
	 * 
	 * 判断左子树的最大值是否小于当前结点的值,且右子树的最大值是否大于当前结点的值
	 * 
	 * FindMax() 得到一棵非空二叉树的最大值
	 * FindMin() 得到一棵非空二叉树的最小值
	 * 
	 * 缺点:每个节点都将遍历多次
	 * 
	 * 时间复杂度O(n²)
	 * 空间复杂度O(n)
	 * 
	 * @param root
	 * @return
	 */
	public boolean IsBST(BinaryTreeNode<Integer> root){
		
		if (root == null)
			return true;
		
		if (root.getLeft() != null && FindMax(root.getLeft()) > root.getData())
			return false;
		
		if (root.getRight() != null && FindMin(root.getRight()) < root.getData())
				return false;
		
		return true;
	}
	
	/**
	 * 
	 * 判断一棵给定的二叉树是否为BST树
	 * 
	 * IsBSTUtil() 遍历时跟踪min和max值得变化,使每个节点只遍历一次
	 * 
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 * 
	 * @param root
	 * @param min Integer.MIN_VALUE
	 * @param max Integer.MAX_VALUE
	 * @return
	 */
	public boolean IsBST2(BinaryTreeNode<Integer> root, int min, int max){
		
		if (root == null)
			return true;
		
		return (root.getData() > min 
				&& root.getData() < max 
				&& IsBSTUtil(root.getLeft(), min, root.getData())
				&& IsBSTUtil(root.getRight(), root.getData(), max));
	}
	
	private boolean IsBSTUtil(BinaryTreeNode<Integer> root, int min, int max){
		
		if (root == null)
			return true;
		
		if (root.getData() > min && root.getData() < max){
			return IsBSTUtil(root.getLeft(), min, root.getData())
					&& IsBSTUtil(root.getRight(), root.getData(), max);
		}
		
		return false;
	}
}
