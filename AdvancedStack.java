package algorithms;

/**
 * 
 * 栈的简单数组实现
 * 
 * 栈满时数组大小倍增
 * 
 * @author five
 *
 */
public class AdvancedStack{
	private ArrayStack2 stack;
	
	private ArrayStack2 minStack;
	
	private ArrayStack2 maxStack;
	
	public AdvancedStack(){
		stack = new ArrayStack2();
		minStack = new ArrayStack2();
		maxStack = new ArrayStack2();
	}
	
	public void push(int data){
		stack.push(data);
		
		if (minStack.isEmpty() || data <= minStack.peek())
			minStack.push(data);
		
		if (maxStack.isEmpty() || data >= maxStack.peek())
			maxStack.push(data);
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public void pop(){
		int data = stack.peek();
		stack.pop();
		
		if (data == minStack.peek())
			minStack.pop();
		
		if (data == maxStack.peek())
			maxStack.pop();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public int size(){
		return stack.getSize();
	}
	
	public int getSize(){
		return stack.getSize();
	}
	
	public int getMinimum(){
		return minStack.peek();
	}
	
	public int getMax(){
		return maxStack.peek();
	}
}
