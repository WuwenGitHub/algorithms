package algorithms;

public class BinarySearchTreeMethod{

	/**
	 * 
	 * 根据数组构建搜索二叉树
	 * 
	 * @param data
	 *            有序数组/中序遍历结果
	 * @return
	 */
	public BinarySearchTreeNode createTree(int[] data) {

		sortArray(data, 0, data.length - 1);

		BinarySearchTreeNode root = buildTree(data, 0, data.length - 1);

		return root;
	}

	// 使用快速排序,将数组按从小到大进行排序
	private void sortArray(int[] data, int low, int height) {
		int i, j, index;

		if (low > height)
			return;

		i = low;
		j = height;
		index = data[i];

		while (i < j) {
			while (i < j && data[j] >= index)
				j--;

			if (i < j) {
				data[i++] = data[j];
				data[j] = index;
			}

			while (i < j && data[i] <= index) {
				i++;
			}

			if (i < j) {
				data[j--] = data[i];
				data[i] = index;
			}
		}

		sortArray(data, low, i - 1);
		sortArray(data, i + 1, height);
	}

	// 生成树
	private BinarySearchTreeNode buildTree(int[] data, int low, int heigh) {

		if (low > heigh)
			return null;

		int size = (heigh + low) / 2;
		BinarySearchTreeNode node = new BinarySearchTreeNode(data[size]);
		node.setLeft(buildTree(data, low, size - 1));
		node.setRight(buildTree(data, size + 1, heigh));

		return node;
	}
	
	/*
	 * 前序遍历(递归方式)
	 */
	public void preOrder(BinarySearchTreeNode root){
		if (root == null){
			return;
			}
		System.out.print(root.getData() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
		
	}
	
	/**
	 * 
	 * 搜寻元素(非递归方式)
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public BinarySearchTreeNode FindNonRecursive(BinarySearchTreeNode root, int data) {
		if (root == null)
			return root;

		while (root != null) {
			if (root.getData() == data)
				return root;

			if (root.getData() > data)
				root = root.getLeft();
			else
				root = root.getRight();
		}

		return null;
	}
	
	/**
	 * 
	 * 搜寻元素(递归方式)
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public BinarySearchTreeNode Find(BinarySearchTreeNode root, int data){
		if (root == null)
			return null;
		
		if (data < root.getData())
			return Find(root.getLeft(), data);
		else if (data > root.getData())
			return Find(root.getRight(), data);
		else
			return root;
	}
	
	/**
	 * 
	 * 查找最小元素(非递归)
	 * 
	 * @param root
	 * @return
	 */
	public BinarySearchTreeNode FindMinNonRecursive(BinarySearchTreeNode root){
		if (root == null)
			return null;
		
		while(root.getLeft() != null)
			root = root.getLeft();
		
		return root;
	}
	
	/**
	 * 
	 * 查找最小元素
	 * 
	 * @param root
	 * @return
	 */
	public BinarySearchTreeNode FindMin(BinarySearchTreeNode root){
		if (root == null)
			return null;
		else{
			return root.getLeft() == null ? root : FindMin(root.getLeft());
		}
	}
	
	/**
	 * 
	 * 查找最大元素(非递归)
	 * 
	 * @param root
	 * @return
	 */
	public BinarySearchTreeNode FindMaxNonRecursive(BinarySearchTreeNode root){
		if (root == null)
			return null;
		
		while(root.getRight() != null)
			root = root.getRight();
		
		return root;
	}
	
	/**
	 * 
	 * 查找最大元素
	 * 
	 * @param root
	 * @return
	 */
	public BinarySearchTreeNode FindMax(BinarySearchTreeNode root){
		if (root == null)
			return null;
		else{
			return root.getRight() == null ? root : FindMax(root.getRight());
		}
	}
	
	/**
	 * 删除元素
	 *  ① 叶子结点
	 *  ② 非叶子结点
	 *  ③ 根节点
	 */
	public BinarySearchTreeNode Delete(BinarySearchTreeNode root, int data){
		BinarySearchTreeNode temp;
		
		if (root == null){
			System.out.println("Element not there in tree!");
		}
		
		if (data < root.getData()){
			root.setLeft(Delete(root.getLeft(), data));
//			Delete(root.getLeft(), data);
		}
		else if (data > root.getData()){
			root.setRight(Delete(root.getRight(), data));
//			Delete(root.getRight(), data);
		}
		else{
			/*
			 * 左子树存在
			 *   用该节点左子树的最大结点的值替换该节点的值,并删除左子树最大结点,右子树不变
			 *   
			 * 左子树不存在
			 *   用该节点右子树的最小结点的值替换该节点的值,并删除右子树最小结点
			 *   
			 * 左右子树均不存在
			 *   直接删除该结点
			*/
			System.out.println("Element in the tree " + data);
			
			if (root.getLeft() != null){
				//该节点存在左子树-->找到左子树中最大结点进行替换
				temp = FindMax(root.getLeft());
				root.setData(temp.getData());
				root.setLeft(Delete(root.getLeft(), temp.getData()));
			}
			else if (root.getRight() != null){
				//该节点存在右子树-->找到右子树中最小结点进行替换
				temp = FindMin(root.getRight());
				root.setData(temp.getData());
				root.setRight(Delete(root.getRight(), temp.getData()));
			}else{
				//为叶子结点,直接删除
				root = null;
			}
		}
		return root;
	}
	
	/**
	 * 查找两个节点之间的最短路径(直接打印方式)
	 * 
	 */
	public void ShortestPath(BinarySearchTreeNode root, BinarySearchTreeNode node1, BinarySearchTreeNode node2){
		
		//校验二叉树中是否存在该值
		if (FindNonRecursive(root, node1.getData()) == null || FindNonRecursive(root, node2.getData()) == null){
			System.out.println("参数不存在");
			return;
		}
		/*
		 * 情况一:
		 * 	 两节点相等
		 * 
		 * 情况一:
		 *   至少有一个结点为根节点
		 *   
		 * 情况二:
		 *   两结点均位于根结点一侧
		 *   
		 * 情况三:
		 *   分别位于根结点两侧
		 */
		if (node1 == null || node2 == null)
			return;
		
		if(node1.getData() == node2.getData()){
			System.out.print(node1.getData() + " ");
			return;
		}
		
		if (node1.getData() == root.getData()){
			
			//1.位于左子树
			if (node2.getData() < root.getData()){
				ShortestPath(root.getLeft(), root.getLeft(), node2);
			}
			//2.位于右子树
			else{
				ShortestPath(root.getRight(), root.getRight(), node2);
			}
			System.out.print(root.getData() + " ");
			return;
		}
		
		if (node2.getData() == root.getData()){
			
			if(node1.getData() < root.getData()){
				ShortestPath(root.getLeft(), node1, root.getLeft());
			}
			else{
				ShortestPath(root.getRight(), node1, root.getRight());
			}
			System.out.print(root.getData() + " ");
			return;
		}
		
		if (node1.getData() < root.getData() && node2.getData() < root.getData()){
			//在左子树中
			ShortestPath(root.getLeft(), node1, node2);
			return;
		}else if(node1.getData() > root.getData() && node2.getData() > root.getData()){
			//在右子树中
			ShortestPath(root.getRight(), node1, node2);
		}else{
			//位于两侧
			ShortestPath(root.getLeft(), node1.getData() < node2.getData() ? node1 : node2, root.getLeft());
			System.out.print(root.getData() + " ");
			ShortestPath(root.getRight(), root.getRight(), node1.getData() > node2.getData() ? node1 : node2);
		}
	}
	
	/**
	 * 查找两个节点之间的最短路径(生成树方式)
	 */
	public BinarySearchTreeNode ShortestPath2(BinarySearchTreeNode root, BinarySearchTreeNode node1, BinarySearchTreeNode node2){
		
		BinarySearchTreeNode tree = null;
		
		if (FindNonRecursive(root, node1.getData()) == null || FindNonRecursive(root, node2.getData()) == null){
			System.out.println("参数不存在");
			return null;
		}
		
		if (node1 == null || node2 == null)
			return null;
		
		if (node1.getData() == node2.getData()){
			tree = new BinarySearchTreeNode(node1.getData());
			return tree;
		}
		
		if (node1.getData() == root.getData()){
			if (node2.getData() < root.getData()){
				tree = new BinarySearchTreeNode(root.getData());
				tree.setLeft(ShortestPath2(root.getLeft(), root.getLeft(), node2));
			}else{
				tree = new BinarySearchTreeNode(root.getData());
				tree.setRight(ShortestPath2(root.getRight(), root.getRight(), node2));
			}
			return tree;
		}
		
		if (node2.getData() == root.getData()){
			if (node1.getData() < root.getData()){
				tree = new BinarySearchTreeNode(root.getData());
				tree.setLeft(ShortestPath2(root.getLeft(), node1, root.getLeft()));
			}else{
				tree = new BinarySearchTreeNode(root.getData());
				tree.setRight(ShortestPath2(root.getRight(), node1, root.getRight()));
			}
			return tree;
		}
		
		if (node1.getData() > root.getData() && node2.getData() > root.getData()){
			tree = ShortestPath2(root.getRight(), node1, node2);
		}else if(node1.getData() < root.getData() && node2.getData() < root.getData()){
			tree = ShortestPath2(root.getLeft(), node1, node2);
		}else{
			tree = root;
			tree.setLeft(ShortestPath2(root.getLeft(), node1.getData() < node2.getData() ? node1 : node2, root.getLeft()));
			tree.setRight(ShortestPath2(root.getRight(), root.getRight(), node1.getData() > node2.getData() ? node1 : node2));
		}
		
		return tree;
	}
	
	/*
	 * 查找两节点的最近公共祖先
	 * 
	 */
	public BinarySearchTreeNode FindLCA(BinarySearchTreeNode root, BinarySearchTreeNode node1, BinarySearchTreeNode node2){
		
		if (node1 == null || node2 == null){
			System.out.println("The latest common ancestor not exist!");
			return null;
		}
		
		BinarySearchTreeNode node = null;
		
		if (node1.getData() == root.getData() || node2.getData() == root.getData()){
			System.out.println("One node was root!");
			return null;
		}else if (node1.getData() == node2.getData()){
			System.out.println("Same node!");
		}else{
			if ((node1.getData() > root.getData() && node2.getData() < root.getData()) || (node1.getData() < root.getData() && node2.getData() > root.getData())){
				node = root;
			}else if (node1.getData() < root.getData() && node2.getData() < root.getData()){
				node = FindLCA(root.getLeft(), node1, node2);
			}else{
				node = FindLCA(root.getRight(), node1, node2);
			}
		}
		
		return node;
	}
}
