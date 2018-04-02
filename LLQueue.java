package algorithms;

/**
 * 
 * 链表实现队列
 * 
 * @author five
 *
 */

public class LLQueue {

	private ListNode frontNode;
	private ListNode rearNode;
	private int size = 0;
	
	public LLQueue(){
		this.frontNode = null;
		this.rearNode = null;
		this.size = 0;
	}
	
	public static LLQueue createQueue(){
		return new LLQueue();
	}
	
	public boolean isEmpty(){
		return frontNode == null;
	}
	
	public void enQueue(int data){
		ListNode newNode = new ListNode(data);
		
		if (rearNode != null){
			rearNode.setNext(newNode);
		}
		rearNode = newNode;
		if (frontNode == null){
			frontNode = rearNode;
		}
	}
	
	public int deQueue() throws EmptyQueueException{
		int data;
		
		if (isEmpty()){
			throw new EmptyQueueException("Queue Empty");
		}else{
			data = frontNode.getData();
			frontNode = frontNode.getNext();
		}
		
		return data;
	}
	
	public int getQueueSize(){
		ListNode node = frontNode;
		int size = 1;
		
		if (frontNode == null)
			return 0;
		else if (frontNode == rearNode)
			return size;
		else{
			while (node.getNext() != rearNode){
				++size;
				node = node.getNext();
			}
			++size;
		}
		
		return size;
	}
}
