package algorithms;

/**
 * 栈的简单数组实现
 * 
 * 栈满时数组大小加1
 * 
 * @author five
 *
 */
public class ArrayStack {
	
	//top指向栈顶元素所在位置
	private int top;
	
	//栈大小
	private int capacity;
	
	private int[] array;
	
	public ArrayStack(){
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}
	
	public ArrayStack(int capacity){
		this.capacity = capacity;
		array = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return (top == capacity - 1);
	}
	
	public void push(int data){
		if (this.isStackFull()){
			capacity++;
			int[] newArray = new int[capacity];
			
			for (int i = 0; i < top; i++){
				newArray[i] = array[i];
			}
			newArray[++top] = data;
			array = newArray;
		}
		else
			array[++top] = data;
	}
	
	public int peek(){
		if (this.isEmpty()){
			System.out.println("Stack is Empty!");
			return 0;
		}else{
			return (array[top]);
		}
	}
	
	public int pop(){
		if (this.isEmpty()){
			System.out.println("Stack is Empty");
			return 0;
		}else
			return (array[top--]);
	}
	
	//获取栈大小
	public int getSize(){
		return capacity;
	}
	
	//获取栈中存储元素个数
	public int getLenth(){
		return top + 1;
	}
	
	public void deleteStack(){
		top = -1;
	}
}
