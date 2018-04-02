package algorithms;

import java.util.Stack;

public class StackMethod {

	/*
	 * 
	 * 直方图中最大矩形
	 * 
	 * {1, 2, 3, 4, 5, 6, 7}有错,结果为0
	 * 
	 */
	long MaxRectangleArea(int[] A, int n){
		long maxArea = 0;
		if (A == null || A.length == 0)
			return maxArea;
		Stack<StackItem> S = new Stack<StackItem>();
		S.push(new StackItem(Integer.MIN_VALUE, -1));
		
		for (int i = 0; i < A.length; i++){
			StackItem cur = new StackItem(i < n ? A[i] : Integer.MIN_VALUE, i);
			if (cur.height > S.peek().height){
				S.push(cur);
				continue;
			}
			while(S.size() > 1){
				StackItem prev = S.peek();
				long area = (i - prev.index) * prev.height;
				if (area > maxArea){
					maxArea = area;
				}
				prev.height = cur.height;
				if (prev.height > S.get(S.size() - 2).height){
					break;
				}
				S.pop();
			}
		}
		return maxArea;
	}
	
	/*
	 * 
	 * 将栈中元素按照升序进行排序
	 * 
	 */
	public Stack sort(Stack s){
		Stack r = new Stack();
		while(!s.isEmpty()){
			int tmp = (Integer) s.pop();
			while(!r.isEmpty() && (Integer)r.peek() > tmp){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	/*
	 * 
	 * 删除所有相邻的重复元素:
	 *   给定一个数字数组,删除相邻的重复数字,结果数组中不能有任何相邻的重复数字
	 *   例: 
	 *   ---------------------------------------------------------------
	 *   输入:                       |  输入:
	 *     1,5,6,8,8,8,0,1,1,0,6,5  |    1,9,6,8,8,8,0,1,1,0,6,5
	 *   输出:                       |  输出:
	 *     1                        |    1,9,5
	 * 
	 */
	public void removeAdjacentDuplicates(int[] A){
		Stack<Integer> s = new Stack<Integer>();
		int tmp = -1;
		
		for (int i = 0; i < A.length; i++){
			
			while(!s.isEmpty() && (Integer)s.peek() == A[i]){
				tmp = A[i];
				s.pop();
				continue;
			}
			
			if (tmp == A[i])
				continue;
			
			s.push(A[i]);
		}
		System.out.println(s.toString());
	}
}
