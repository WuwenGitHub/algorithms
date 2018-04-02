package algorithms;

public class ListNodeMethod {
    
	//获取链表长度
    int ListNodeLength(ListNode node){
    	int length = 0;
    	if (node != null)
    		length++;
    	while(node.getNext() != null){
    		node = node.getNext();
    		length++;
    	}
    	return length;
    }
    
    //于指定位置插入节点/链表
    ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
    	
    	if (headNode == null)
    		return nodeToInsert;
    	
    	int size = ListNodeLength(headNode);
    	if (position < 0 || position > size + 1){
    		System.out.println("Position of the node to insert is invalid.The valid inputs are 1 to " + (size + 1));
    		return headNode;
    	}
    	else{
	    	ListNode node = headNode;
	    	int count = 1;
	    	while(count < position){
	    		node = node.getNext();
	    		count++;
	    	}
	    	
	    	nodeToInsert.setNext(node.getNext());
	    	node.setNext(nodeToInsert);
    	}
    	
		return headNode;
    }
    
    //删除节点
    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
    	int size = ListNodeLength(headNode);
    	
    	if (headNode == null){
    		return null;
    	}
    	
    	if (position < 1 || position > size){
    		System.out.println("Position of the node to delete is invalib.The valib inputs are 1 to " + size);
    	}else{
    		if (position == 1){
    			headNode = headNode.getNext();
    		}else{
    			ListNode node = headNode;
    			int count = 1;
    			while(count < position - 1){
    				node = node.getNext();
    				count++;
    			}
    			node.setNext(node.getNext().getNext());
    		}
    	}
    	
    	return headNode;
    }
    
    //查找相交节点
    ListNode FindIntersectingNode(ListNode list1, ListNode list2){
    	ListNode node1 = list1, node2 = list2;
    	
    	if (list1 == null || list2 == null)
    		return null;
    	
    	while(node1.getNext() != null){
    		node1 = node1.getNext();
    	}
    	
    	if (node1.getNext() == null){
    		node1.setNext(node2);
    	}
    	
    	node1 = list1;
    	node2 = list1;
    	
    	while (node1.getNext().getNext() != null && node2.getNext() != null){
    		node2 = node2.getNext();
    		node1 = node1.getNext().getNext();
    		if (node2 == node1){
    			break;
    		}
    	}
    	
    	node2 = list1;
    	while(node2 != node1){
    		node1 = node1.getNext();
    		node2 = node2.getNext();
    	}
    	
    	return node2;
    }
    
    //逆置单向链表
    ListNode ReverseList(ListNode head){
    	ListNode temp = null, nextNode = null;
    	while(head != null){
    		nextNode = head.getNext();
    		head.setNext(temp);
    		temp = head;
    		head = nextNode;
    	}
    	
    	return temp;
    }
    
    //查找中间节点
    ListNode FindMiddleNode(ListNode head){
    	ListNode slowList = head, quickList = head;
    	
    	if (head == null)
    		return null;
    	
    	while(quickList != null && quickList.getNext() != null){
    		slowList = slowList.getNext();
    		quickList = quickList.getNext().getNext();
    	}
    	
    	slowList.setNext(null);
    	
    	return slowList;
    }
    
    //检查链表长度是奇数还是偶数    1--奇数    0--偶数
	int isLinkedListLenthEven(ListNode head){
		
		if (head == null)
			return 0;
    	
    	while(head != null && head.getNext() != null){
    		head = head.getNext().getNext();
    	}
    	
    	if (head == null)
    		return 0;
    	
    	return 1;
    }
	
	//逐对逆置链表
	ListNode ReversePairRecursive(ListNode head){
		
		//递归版本
		/*
		ListNode temp;
		if (head == null || head.getNext() == null)
			return head;
		else{
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			head = temp;
			head.getNext().setNext(ReversePairRecursive(head.getNext().getNext()));
		}
		*/
		
		//迭代版本
		ListNode temp1 = null, temp2 = null;
		
		while(head != null && head.getNext() != null){
			if (temp1 != null)
				temp1.getNext().setNext(head.getNext());//??????
			temp1 = head.getNext();
			head.setNext(temp1.getNext());
			temp1.setNext(head);
			if (temp2 == null)
				temp2 = temp1;
			head = head.getNext();
		}
		
		return temp2;
	}
	
	//将循环链表分割成两个长度相等的部分
    //如果结点数是奇数,让第一个链表的结点数比第二个多一
	void SplitList(ListNode head, ListNode head1, ListNode head2){
		head1 = head;
		ListNode slowNode = head1, fastNode = head;
		
		if (head == null){
			head1 = null;
			head2 = null;
			return;
		}
		
		//slowNode 步进1 fastNode 步进2
		while(fastNode.getNext() != null && fastNode.getNext().getNext() != null){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		
		head2 = slowNode.getNext();
		slowNode.setNext(null);
	}
	
	//判断链表是否为回文
	boolean PalindromeList(ListNode head){
		ListNode slowList = head, fastList = head;
		ListNode node1, node2;
		boolean isPalindrome = true;
		
		if (head == null)
			return false;
		
		while(fastList.getNext() != null && fastList.getNext().getNext() != null){
			slowList = slowList.getNext();
			fastList = fastList.getNext().getNext();
		}
		
		fastList = slowList.getNext();
		slowList.setNext(null);
		
		//逆置
		fastList = ReverseList(fastList);
		
		node1 = head; 
		node2 = fastList;
		
		while(node2.getNext() != null){
			if(node2.getData() != node1.getData())
				isPalindrome = false;
			node2 = node2.getNext();
			node1 = node1.getNext();
		}
		
		slowList.setNext(ReverseList(fastList));
		
		return isPalindrome;
	}
	
	//交换链表中的任意两个结点
	void exchangeNodes(ListNode head, int x, int y){
		ListNode node1 = head, node2 = head;
		int size = ListNodeLength(head);
		
		if (x > size - 1)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(x, size));
		
		if (y > size- 1)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(x, size));
		
		size = 0;
		while(size < x){
			node1 = node1.getNext();
			size++;
		}
		
		size = 0;
		while(size < y){
			node2 = node2.getNext();
			size++;
		}
		
		int data = node1.getData();
		node1.setData(node2.getData());
		node2.setData(data);
	}
	
	void exchangeAdjacentNodes(ListNode head){
		ListNode curNode = null, nextNode = null, temp = null;
		
		if (head == null || head.getNext() == null)
			return;
		
		curNode = head;
		head = curNode.getNext();
		
		while(curNode != null && curNode.getNext() != null){
			nextNode = curNode.getNext();
			curNode.setNext(nextNode.getNext());
			temp = curNode.getNext();
			nextNode.setNext(curNode);
			if(temp != null && temp.getNext() != null)
				curNode.setNext(curNode.getNext().getNext());//????????????????????????
			curNode = temp;
		}
	}
	
	//获取到第K个结点
	ListNode GetKPlusOneTheNode(int K, ListNode head){
		ListNode Kth = head;
		int i;
		
		for (i = 0; i < K && Kth != null; i++){
			Kth = Kth.getNext();
		}
		if (i == K && Kth != null)
			return Kth;
		
		return head.getNext();
	}
	
	boolean HasKnodes(ListNode head, int K){
		int i = 0;
		
		if (head == null)
			return false;
		
		while(i < K){
			if (head == null)
				return false;
			head = head.getNext();
			i++;
		}
		
		return true;
	}
	
	/*
	 * 逆置链表中包含K个结点的块
	 * 例: 
	 *    输入:1 2 3 4 5 6 7 8 9 10
	 *    对于不同的K值,输出为:
	 *    K = 2: 2 1 4 3 6 5 8 7 10 9
	 *    K = 3: 3 2 1 6 5 4 9 8 7 10
	 *    K = 4: 4 3 2 1 8 7 6 5 9 10
	 */
	ListNode ReverseBlockOfK_nodesInLinkedList(ListNode head, int k){
		ListNode temp, next, cur = head, newHead;
		
		if (head == null)
			return head;
		
		if (k == 0 || k == 1)
			return head;
		
		int size = ListNodeLength(head);
		if (k > size){
			System.out.println("The reverse block out of length.The valib inputs are 1 to " + size);
			return head;
		}
		
		/*
		//法一(耗时 > O(n²))
		//一共要交换的组数
		int couple_num = size / k;
		//逐对逆置
		for(int i = 0; i < couple_num; i++){
			//每组起始结点位置
			int position = i * k;
			//组内交换
			for (int j = 0, n = k; j < k / 2; j++,n--){
				ListNode node1 = GetKPlusOneTheNode(position + j, newHead);
				ListNode node2 = GetKPlusOneTheNode(position + n - 1, newHead);
				int data = node1.getData();
				node1.setData(node2.getData());
				node2.setData(data);
			}
		}
		*/
		
		//法二
		/**
		 * 只有第一次操作时才成功
		 *   k = 4时:
		 *    第一次时: newHead 指向 cur 的 data = 3 结点，当 cur 指向 3 结点时, 改变了该结点的后继节点,
		 *    由于newHead也指向的是 3 结点的地址,此时newHead也同时进行了更新。而后，由于cur一直向后遍历,
		 *    而newHead指向的地址依旧没有改变(即依旧指向 3 对应的地址),所以即使更改了后边结点的指向,newHead的
		 *    值依旧不会有任何变化 
		 */
		head = GetKPlusOneTheNode(k - 1, cur);
//		newHead = GetKPlusOneTheNode(k -1, cur);
		while(cur != null && HasKnodes(cur, k)){
			temp = GetKPlusOneTheNode(k, cur);
			
			if (temp == null)
				break;
			
			int i = 0;
			while(i < k){
				next = cur.getNext();
				cur.setNext(temp);
				temp = cur;
				cur = next;
				i++;
			}
		}
		
		return head;
	}
	
	/*
	 * 约瑟夫环
	 */
    ListNode GetJosephusPosition(ListNode head, int M){
    	ListNode curNode = head, nextNode;
    	int num = ListNodeLength(head);
    	
    	if (head == null)
    		return head;
    	
    	if (ListNodeLength(head) == 1)
    		return head;
    	
    	while (curNode != null && curNode.getNext() != null){
    		curNode = curNode.getNext();
    	}
    	
    	nextNode = curNode;
    	nextNode.setNext(head);
    	nextNode = nextNode.getNext();
    	
    	while(num > 1){
    		for (int i = 1; i < M; i++){
    			curNode = curNode.getNext();
    			nextNode = nextNode.getNext();
    		}
    		curNode.setNext(nextNode.getNext());
    		nextNode = curNode.getNext();
    		num--;
    	}
    	
    	return new ListNode(curNode.getData());
    }
    
    //从表头开始寻找模结点
    /*
     * 给定一个单向链表,链表的结点编号i为[1..n],其中n为链表中元素的个数,
     * 编写一个函数从表头开始找到最后一个满足i%k==0条件的元素,k为一个整数
     * 常量.例如,如果n为19,k为3,那么应该返回第18个结点.
     */
    ListNode modularNodes(ListNode head, int k){
    	ListNode curNode = null;
    	
    	if (head == null)
    		return head;
    	
    	int position = 1;
    	for (; head != null; position++){
    		if (position % k == 0)
    			curNode = head;
    		head = head.getNext();
    	}
    	
    	if (curNode == null){
    		System.out.println("Cannot found such node!");
    		return null;
    	}
    	
    	return curNode;
    }
    
    //从表尾开始找模结点
    /*
     * 从表尾开始找第一个满足 n%k == 0 条件的元素
     *   n: 链表中元素的个数
     *   k: 整数常量
     */
    ListNode modularNodesFromTheEnd(ListNode head, int k){
    	ListNode modularNode = head;
    	
    	if (head == null)
    		return null;
    	
    	if (k < 1)
    		return null;
    	
    	for(int i = 0; i < k; i++){
    		modularNode = modularNode.getNext();
    		if (modularNode == null){
    			System.out.println("Cannot find such node");
    			return null;
    		}
    	}
    	
    	while(modularNode != null){
    		modularNode = modularNode.getNext();
    		head = head.getNext();
    	}
    	
    	return head;
    }
    
    //查找分数结点
    /*
     * 查找第 n/k 个元素
     *   n: 链表中元素的个数
     */
    ListNode fractionalNodes(ListNode head, int k){
    	ListNode fractionalNode = head;
    	int i = 0;//组数
    	
    	if (head == null)
    		return null;
    	
    	if (k < 1)
    		return null;
    	
    	int j = 0;
    	while (head != null){
    		if ((j + 1) % k == 0){
    			i++;
    		}
    		head = head.getNext();
    		j++;
    	}
    	
    	while(i > 1){
    		fractionalNode = fractionalNode.getNext();
    		i--;
    	}
    	
    	return fractionalNode;
    }
	
	private String outOfBoundsMsg(int index, int size) {
        return "Index: "+index+", Size: "+size;
    }
}