package algorithms;

/**
 * 
 * 使用两个队列来高效地实现一个栈
 * 
 * @author five
 *
 */

public class StackWithTwoQueues {
	
	private LLQueue queue1;
	private LLQueue queue2;
	
	public StackWithTwoQueues(){
		queue1 = new LLQueue();
		queue2 = new LLQueue();
	}
	
	public boolean isEmpty(){
		if (queue1.isEmpty() && queue2.isEmpty())
			return true;
		return false;
	}
	
	public void push(int data){
		if (queue1.isEmpty())
			queue2.enQueue(data);
		else
			queue1.enQueue(data);
	}
	
	public int pop(){
		int data = 0;
		int size = 0;
		
		if (queue2.isEmpty()){
			int i = 0;
			size = queue1.getQueueSize();
			try {
				while (i < size - 1) {
					queue2.enQueue(queue1.deQueue());
					i++;
				}
				data = queue1.deQueue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			int i = 0;
			size = queue2.getQueueSize();
			try {
				while (i < size - 1) {
					queue1.enQueue(queue2.deQueue());
					i++;
				}
				data = queue2.deQueue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return data;
	}
}
