package algorithms;

import java.util.Stack;

/**
 * 
 * 使用两个栈来实现队列
 * 
 * @author five
 *
 */

public class QueueWithTwoStacks {
	
	private Stack stack1;
	private Stack stack2;
	
	public QueueWithTwoStacks(){
		stack1 = new Stack();
		stack2 = new Stack();
	}
	
	public boolean isEmpty(){
		if (stack2.isEmpty() && stack2.isEmpty())
			return true;
		return false;
	}
	
	public void enQueue(Object data){
		stack1.push(data);
	}
	
	public Object deQueue(){
		if (stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.pop();
	}
}
