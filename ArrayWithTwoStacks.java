package algorithms;

/**
 * 一个数组实现两个栈
 * 
 * 
 * @author five
 *
 */
public class ArrayWithTwoStacks {
	private int[] dataArray;
	private int size;
	private int topOne;
	private int topTwo;
	
	public ArrayWithTwoStacks(int size){
		if (size < 2) throw new IllegalStateException("size < 2 is no permissible");
		dataArray = new int[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}
	
	public void push(int stackId, int data){
		if (topTwo == topOne + 1) throw new StackOverflowError("Array is full");
		
		if (stackId == 1){
			dataArray[++topOne] = data;
		}else if (stackId == 2){
			dataArray[--topTwo] = data;
		}else{
			return;
		}
	}
	
	@SuppressWarnings("null")
	public int pop(int stackId) throws Exception{
		if (stackId == 1){
			if (topOne == -1) throw new EmptyStackException();
			int toPop = dataArray[topOne];
			dataArray[topOne--] = (Integer) null;
			return toPop;
		}else if (stackId == 2){
			if (topTwo == this.size) throw new EmptyStackException();
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = (Integer) null;
			return toPop;
		}else
			return (Integer) null;
	}
	
	@SuppressWarnings("null")
	public int top(int stackId) throws Exception{
		if (stackId == 1){
			if (topOne == -1) throw new EmptyStackException();
			return dataArray[topOne];
		}else if (stackId == 2){
			if (topTwo == this.size) throw new EmptyStackException();
			return dataArray[topTwo];
		}else
			return (Integer) null;
	}
	
	public boolean isEmpty(int stackId){
		if (stackId == 1){
			return topOne == -1;
		}else if (stackId == 2){
			return topTwo == this.size;
		}else
			return true;
	}
}
