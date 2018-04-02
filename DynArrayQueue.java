package algorithms;

/**
 * 
 * 基于动态循环数组实现队列
 * 
 * @author five
 *
 */

public class DynArrayQueue{

	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	private DynArrayQueue(){
		front = -1;
		rear = -1;
		capacity = 1;
		array = new int[1];
	}
	
	public static DynArrayQueue createDynArrayQueue(){
		return new DynArrayQueue();
	}
	
	public boolean isEmpty(){
		return front == -1;
	}
	
	private boolean isFull(){
		return (rear + 1) % capacity == front;
	}
	
	public int getQueueSize(){
		if (front == -1)
			return 0;
		int size = (capacity - front + rear + 1) % capacity;
		if (size == 0)
			return capacity;
		else
			return size;
	}
	
	@SuppressWarnings("null")
	private void resizeQueue(){
		int initCapacity = capacity;
		capacity *= 2;
		int[] oldArray = array;
		array = new int[this.capacity];
		for (int i = 0; i < initCapacity; i++){
			array[i] = oldArray[i];
		}
		if (rear < front){
			for (int i = 0; i < front; i++){
				array[i + initCapacity] = this.array[i];
				array[i] = (Integer) null;
			}
			rear = rear + initCapacity;
		}
	}
	
	public void enQueue(int data){
		if (isFull())
			resizeQueue();
		rear = (rear + 1) % capacity;
		array[rear] = data;
		if (front == -1)
			front = rear;
	}
	
	public int deQueue() throws EmptyQueueException{
		int data;
		if (isEmpty())
			throw new EmptyQueueException("Queue Empty");
		else{
			data = array[front];
			if (front == rear)
				front = rear - 1;
			else
				front = (front + 1) % capacity;
		}
		return data;
	}
}
