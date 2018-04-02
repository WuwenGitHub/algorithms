package algorithms;

public class CLLNodeMethod {
    
    int CLLNodeLength(CLLNode headNode){
    	int length = 0;
    	
    	CLLNode node = headNode;
    	while(node.getNext()!= null){
    		length++;
    		node = node.getNext();
    		if (node == headNode)
    			break;
    	}
    	return length;
    }
    
    void PrintCircularListData(CLLNode headNode){
    	CLLNode node = headNode;
    	
    	while(node.getNext() != null){
    		if (node.getNext() == headNode)
    			break;
    		System.out.print("CLLNode [data=" + node.getData() + ",next=");
    		node = node.getNext();
    		
    	}
    	System.out.print("CLLNode [data=" + node.getData());
    	
    	int len = CLLNodeLength(headNode);
    	while(len > 0){
    		System.out.print("]");
    		len--;
    	}
    	System.out.println();
    }
    
    CLLNode InsertNoteAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert){
    	CLLNode node = headNode;
    	
    	nodeToInsert.setNext(nodeToInsert);
    	
    	if(headNode != null){
    		while(node.getNext() != headNode){
    			node = node.getNext();
    		}
    		nodeToInsert.setNext(headNode);
    		node.setNext(nodeToInsert);
    	}
    	headNode = nodeToInsert;
    	
		return headNode;
    }
    
    CLLNode InsertListAtBeginInCLL(CLLNode headNode, CLLNode listToInsert){
    	CLLNode node = headNode;
    	
    	if (listToInsert == null)
    		return headNode;
    	if (headNode == null)
    		return listToInsert;

		while (node.getNext() != headNode) {
			node = node.getNext();
		}
		node.setNext(listToInsert);
		node = listToInsert;
		
		while (node.getNext() != listToInsert) {
			node = node.getNext();
		}
		node.setNext(headNode);
		return listToInsert;
    }
    
    CLLNode InsertNodeAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert){
    	CLLNode node = headNode;
    	
    	while(node.getNext() != headNode){
    		node = node.getNext();
    	}
    	
    	nodeToInsert.setNext(nodeToInsert);
    	
    	if (headNode == null){
    		headNode = nodeToInsert;
    	}else{
    		nodeToInsert.setNext(headNode);
    		node.setNext(nodeToInsert);
    	}
    	
		return headNode;
    }
    
    CLLNode InsertListAtEndInCLL(CLLNode headNode, CLLNode listToInsert){
    	CLLNode node = headNode;
    	
    	//当自己与自己连接时，由于地址相同的关系会形成死循环
    	while(node.getNext() != null){
    		if (node.getNext() == headNode){
    			node.setNext(listToInsert);
    			node = node.getNext();
    		}
    		if (node.getNext() == listToInsert)
    			break;
    		node = node.getNext();
    	}
    	
    	node.setNext(headNode);
    	
		return headNode;
    }
    
    CLLNode DeleteLastNodeFromCLL(CLLNode headNode){
    	CLLNode node = headNode;
    	CLLNode currentNode = headNode;
    	
    	if (headNode != null){
    		while(node.getNext() != headNode){
    			currentNode = node;
    			node = node.getNext();
    		}
    		currentNode.setNext(headNode);
    		node = null;
    	}
    	return headNode;
    }
    
    CLLNode DeleteFrontNodeFromCLL(CLLNode headNode){
    	CLLNode node = headNode;
    	
    	if (headNode != null){
    		while(node.getNext() != headNode){
    			node = node.getNext();
    		}
    		headNode = headNode.getNext();
    		node.setNext(headNode);
    	}
    	
    	return headNode;
    }
    
    CLLNode DeleteNodeFromCLL(CLLNode headNode, CLLNode deleteNode){
    	CLLNode node = headNode;
    	CLLNode currentNode = node;
    	int count = 0;
    	
    	if (headNode != null){
    		while(node.getNext() != headNode){
    			count++;
    			if (deleteNode.getData() == node.getData()){
    				if (count == 1){
    					return DeleteFrontNodeFromCLL(headNode);
    				}else if (count == CLLNodeLength(headNode)){
    					return DeleteLastNodeFromCLL(headNode);
    				}else{
    					currentNode.setNext(node.getNext());
    				}
    			}
    			currentNode = node;
    			node = node.getNext();
    		}
    	}
    	
    	return headNode;
    }
    
    CLLNode DeleteListFromCLL(CLLNode headNode, CLLNode listToDelete){
    	CLLNode node = headNode;
    	CLLNode currentNode = node;
    	CLLNode node2 = listToDelete;
    	
    	if (listToDelete != null){
    		int headLen = CLLNodeLength(headNode);
    		int deleteLen = CLLNodeLength(listToDelete);
    		if (headLen < deleteLen){
    			System.out.println("The list to delete to long");
    			return headNode;
    		}
    		
    		while(node.getNext() != headNode){
    			if (node2.getData() == node.getData()){
    				while(node2.getNext() != listToDelete){
    					node = node.getNext();
    					node2 = node2.getNext();
    					if (node2.getData() != node.getData()){
    						node2 = listToDelete;
    						node = currentNode;
    						continue;
    					}
    				}
    				if (node2.getNext() == listToDelete){
    					currentNode.setNext(node.getNext());
    					break;
    				}
    				node = node.getNext();
    				currentNode = node;
    			}
    			node = node.getNext();
				currentNode = node;
    		}
    	}
    	
    	if (currentNode == headNode){
    		if (currentNode.getNext() == headNode)
    			return null;
    		node = currentNode;
    		while(node.getNext() != headNode){
    			node = node.getNext();
    		}
    		node.setNext(headNode.getNext());
    		return currentNode.getNext();
    	}
    	currentNode = DeleteFrontNodeFromCLL(currentNode);
    	
    	return headNode;
    }
    
    //将循环链表分割成两个长度相等的部分
    //如果结点数是奇数,让第一个链表的结点数比第二个多一
    void SplitList(CLLNode head, CLLNode head1, CLLNode head2){
    	CLLNode slowNode = head, fastNode = head;
    	
		if(head == null)
			return;
		
		while (fastNode.getNext() != head && fastNode.getNext().getNext() != head){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		
		if (fastNode.getNext() != head){
			fastNode = fastNode.getNext();
		}
		
		fastNode.setNext(slowNode.getNext());
		slowNode.setNext(head);
		
		head1 = head;
		head2 = fastNode.getNext();
	}
    
    //约瑟夫环
    ListNode GetJosephusPosition(CLLNode head, int M){
    	return null;
    }
}