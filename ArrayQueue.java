package algorithms;

/**
 * 
 * 简单循环数组方式实现队列
 * 
 * @author five
 *
 */

public class ArrayQueue{

	//头
	private int front;
	
	//尾
	private int rear;
	
	//长度
	private int capacity;
	
	private int[] array;
	
	private ArrayQueue(int size){
		capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}
	
	public static ArrayQueue createQueue(int size){
		return new ArrayQueue(size);
	}
	
	/*
	 * 不完善
	 * 	例: 先入1，再出1,然后再入2,再出2,此时队列应为空,实际判断为非空
	 */
	public boolean isEmpty(){
//		return (front == -1 || getQueueSize() == 0);
		return (front == -1);
	}
	
	public boolean isFull(){
		return ((rear + 1) % capacity == front);
	}
	
	/*
	 * 判断有误
	 * 例:  数组大小为10,先入,再出,此时大小判断为2,实际应为0
	 */
	public int getQueueSize(){
		return ((capacity - front + rear + 1) % capacity);
	}
	
	public void enQueue(int data) throws Exception{
		if (isFull()){
			throw new QueueOverflowException("Queue Overflow");
		}else{
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if (front == -1){
				front = rear;
			}
		}
	}

	public int deQueue() throws Exception{
		int data;
		if (isEmpty()){
			throw new EmptyQueueException("Queue Empty");
		}else{
			data = array[front];
			if (front == rear){
				front = rear - 1;
			}else{
				front = (front + 1) % capacity;
			}
		}
		return data;
	}
}
