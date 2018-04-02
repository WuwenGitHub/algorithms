package algorithms;

/**
 * 单向链表
 * 
 * @author five
 *
 */
public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return this.next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + ", toString()=" + super.toString() + "]";
	}
	
}
