package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Random_ListNodeMethod {
	int LengthOfRandom_ListNode(Random_ListNode head){
		int length = 0;
		
		while(head != null){
			head = head.getNext();
			length++;
		}
		
		return length;
	}
	
	Random_ListNode clone(Random_ListNode head){
		Random_ListNode curNode = head, finNode = null;
		Map<Random_ListNode, Random_ListNode> HT = new HashMap<Random_ListNode, Random_ListNode>();
		
		while(curNode != null){
			finNode = new  Random_ListNode();
			finNode.setData(curNode.getData());
			finNode.setNext(null);
			finNode.setRandom(null);
			HT.put(curNode, finNode);
			curNode = curNode.getNext();
		}
		
		curNode = head;
		while(curNode != null){
			finNode= HT.get(curNode);
			finNode.setNext(HT.get(curNode.getNext()));
			finNode.setRandom(HT.get(curNode.getRandom()));
			curNode = curNode.getNext();
		}
		
		return HT.get(head);
	}
}
