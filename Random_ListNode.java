package algorithms;

public class Random_ListNode {
	
	private int data;
	//相邻结点
	private Random_ListNode next;
	//随机节点
	private Random_ListNode random;
	
	Random_ListNode(){
		
	}
	
	Random_ListNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Random_ListNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Random_ListNode next) {
		this.next = next;
	}

	/**
	 * @return the random
	 */
	public Random_ListNode getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(Random_ListNode random) {
		this.random = random;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
//		return "Random_ListNode [data=" + data + ", next=" + next + ", random=" + random + ", toString()=" + super.toString() + "]";
		return "Random_ListNode [data=" + data
				+ ", next=" + next
				+ ", random=" + "(Random_ListNode: " + (random != null ? random.getData() : random) + ")"
				+ ", toString()=" + super.toString()
				+ "]";
//		return "Random_ListNode [data=" + data + ", next=" + next + ", toString()=" + super.toString() + "]";
//		return "Random_ListNode [data=" + data + ", toString()=" + super.toString() + "]";
		
	}
	
}
