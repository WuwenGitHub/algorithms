package algorithms;

public class AVLTreeMethod{
	
	/**
	 * 求AVL树的高度
	 * 
	 * @param root
	 * @return
	 */
	public int height(AVLTreeNode root){
		/*if (root == null)
			return -1;
		else
			return root.getHeight();*/
		int deep = 0;
		
		if (root != null){
			int left = height(root.getLeft());
			int right = height(root.getRight());
			deep = left > right ? left : right;
			deep++;
		}
		
		return deep;
	}
	
	/**
	 * 
	 * 构建AVL树
	 * 
	 * @param data
	 * @return
	 */
	public AVLTreeNode createAVLTree(int[] data){
		
		AVLTreeNode root = null;
		
		for (int i : data){
			root = insert(root, null, i);
		}
		
		return root;
	}
	
	/**
	 * 
	 * 插入新节点
	 * 
	 * @param root
	 * @param parent
	 * @param data
	 * @return
	 */
	public AVLTreeNode insert(AVLTreeNode root, AVLTreeNode parent, int data){
		
		if (root == null){
			root = new AVLTreeNode(data);
		}else if(data < root.getData()) {
			root.setLeft(insert(root.getLeft(), root, data));
			
			int weight = height(root.getLeft()) - height(root.getRight());
			if (weight == 2){
				if (data < root.getLeft().getData()){
					root = SingleRotateLeft(root);
				}else{
					root = DoubleRotateLeft(root);
				}
			}
			
		}else if (data > root.getData()){
			root.setRight(insert(root.getRight(), root, data));
			
			int weight = height(root.getRight()) - height(root.getLeft());
			if (weight == 2){
				if (data > root.getRight().getData()){
					root = SingleRotateRight(root);
				}else{
					root = DoubleRotateRight(root);
				}
			}
		}
		
		return root;
	}
	
	private AVLTreeNode SingleRotateLeft(AVLTreeNode X){
		AVLTreeNode W = X.getLeft();
		
		X.setLeft(W.getRight());
		W.setRight(X);
		
		//X.setHeight(Math.max(height(X.getLeft()), height(X.getRight()) + 1));
		//W.setHeight(Math.max(height(W.getLeft()), X.getHeight() + 1));
		
		return W;
	}
	
	private AVLTreeNode SingleRotateRight(AVLTreeNode X){
		AVLTreeNode W = X.getRight();
		
		X.setRight(W.getLeft());
		W.setLeft(X);
		//W.setHeight(Math.max(height(W.getLeft()) + 1, height(W.getRight())));
		//X.setHeight(Math.max(height(X.getRight()), W.getHeight() + 1));
		
		return W;
	}
	
	private AVLTreeNode DoubleRotateLeft(AVLTreeNode Z){
		Z.setLeft(SingleRotateRight(Z.getLeft()));
		return SingleRotateLeft(Z);
	}
	
	private AVLTreeNode DoubleRotateRight(AVLTreeNode Z){
		Z.setRight(SingleRotateLeft(Z.getRight()));
		return SingleRotateRight(Z);
	}
}