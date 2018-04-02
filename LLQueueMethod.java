package algorithms;

import java.util.Stack;

/**
 * 
 * 链表实现队列相关方法
 * 
 * @author five
 *
 */

public class LLQueueMethod {
	
	//逆置队列元素
	public static LLQueue reverseLLQueue(LLQueue queue){
		Stack stack = new Stack();
		
		while(!queue.isEmpty()){
			try {
				stack.push(queue.deQueue());
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(!stack.isEmpty()){
			queue.enQueue((int)stack.pop());
		}
		
		return queue;
	}
}
