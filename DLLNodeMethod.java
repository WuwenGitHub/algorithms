package algorithms;

public class DLLNodeMethod {
    
    int DLLNodeLength(DLLNode node){
    	int length = 0;
    	if (node != null)
    		length++;
    	while(node.getNext()!= null){
    		length++;
    		node = node.getNext();
    	}
    	return length;
    }
    
    DLLNode InsertDLLNode(DLLNode headNode, DLLNode nodeToInsert, int position){
    	
    	if (headNode == null){
    		return nodeToInsert;
    	}
    	
    	int size = DLLNodeLength(headNode);
    	
    	if (position < 1 || position > size + 1){
    		System.out.println("Position of the node to insert is invalid.The valid inputs are 1 to " + (size + 1));
    	}else{
    		if (position == 1){
    			nodeToInsert.setNext(headNode);
    			headNode.setPrevious(nodeToInsert);
    			return nodeToInsert;
    		}
    		DLLNode node = headNode;
    		int count = 1;
    		while(count < position - 1){
    			node = node.getNext();
    			count++;
    		}
    		nodeToInsert.setNext(node.getNext());
    		node.setNext(nodeToInsert);
    		nodeToInsert.setPrevious(node);
    	}
    	
		return headNode;
    }
    
    DLLNode DeleteNodeFromDLLNode(DLLNode headNode, int position){
    	
    	int size = DLLNodeLength(headNode);
    	
    	if (position < 1 || position > size){
    		System.out.println("Position of the node to delete is invalid.The valid inputs are 1 to " + size);
    	}else{
    		if (position == 1){
    			headNode.getNext().setPrevious(null);
    			headNode = headNode.getNext();
    			return headNode;
    		}
    		DLLNode node = headNode;
    		int count = 1;
    		while(count < position - 1){
    			node = node.getNext();
    			count++;
    		}
    		DLLNode node2 = node.getNext().getNext();
    		if (node2 != null){
    			node2.setPrevious(node);
    		}
    		node.setNext(node.getNext().getNext());
    	}
    	
    	return headNode;
    }
}