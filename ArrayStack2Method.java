package algorithms;

/**
 * 栈的简单方法
 * 
 * @author five
 *
 */
public class ArrayStack2Method {
	
	/*
	 * 中缀表达式转后缀表达式
	 * 
	 * A+B --> AB+ A+B-C --> AB+C- (A+B)*C-D --> AB+C*D-
	 * 
	 * 仅完成简单运算
	 */
	/*
	 * 
	 *  a)创建一个栈
	 *  b)for (输入字符串中的每个字符t){
	 *       if (t是一个操作数) 输出t
	 *       else if (t是一个右括号)
	 *         出栈并输出该符号,直至一个左括号出现(但左括号不输出)
	 *       else // t是一个运算符或左括号{
	 *         出栈并输出该符号,直至出现一个比t的优先级小的符号,或者出现一个左括号,或栈空
	 *         t入栈
	 *       }
	 *   }
	 */
	public void firstMethod(String str){
		
		String str2 = "";
		char[] ch = str.toCharArray();
		ArrayStack2 stack = new ArrayStack2();
		for (char c : ch) {
			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				if (stack.isEmpty())
					stack.push(c);
				else {
					if ((char) stack.peek() != '(') {
						str2 += (char) stack.peek();
						stack.pop();
					}
					stack.push(c);
				}
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				while((char) stack.peek() != '('){
					str2 += (char) stack.peek();
					stack.pop();
				}
				stack.pop();
				break;
			default:
				str2 += c;
				break;
			}
		}

		int len = stack.getLenth();
		while (len != -1) {
			str2 += (char) stack.peek();
			stack.pop();
			len--;
		}

		System.out.println(str2);
	}
	
	/*
	 * 计算后缀表达式的值
	 * 
	 *  1)从左向右扫描后缀表达式字符串
	 *  2)初始化一个空栈
	 *  3)重复第4、5步,直至扫描完所有字符
	 *  4)如果被扫描的字符是一个操作数,将其入栈
	 *  5)如果被扫描的字符是一个运算符,并且是一个一元运算符,那么只出栈一个元素
	 *    如果是一个二元运算符,那么出栈两个元素.元素出栈后,应用运算符对其进行
	 *    运算,并将计算结果入栈
	 *  6)在所有字符扫描结束后,栈中应该只有一个元素
	 *  7)栈顶的值作为结果返回
	 *  
	 *  例: 1 2 3 * + 5 - => 2
	 * 
	 */
	public void calculatorFirst(String str){
		
	}
	
	/*
	 * 
	 * 只扫描一遍就能计算中缀表达式的值
	 * 
	 * 使用两个栈
	 * 
	 */
	public void calculatorSecond(String str){
		
	}
	
	/*
	 * 
	 * 判断回文
	 * 
	 */
	public boolean isPalindrome(String inputStr){
		char inputChar[] = inputStr.toCharArray();
		boolean isPalindrome = true;
		ArrayStack2 stack = new ArrayStack2();
		
		int i = 0;
		
		while(i < inputChar.length / 2){
			stack.push(inputChar[i]);
			i++;
		}
		
		if (inputChar.length % 2 != 0)
			i++;
		
		while(!stack.isEmpty()){
			int data = stack.peek();
			if (data != inputChar[i])
				isPalindrome = false;
			stack.pop();
			i++;
		}
		
		return isPalindrome;
	}
	
	/*
	 * 
	 * 计算跨度
	 * 
	 *   给定数组A,A[i]的跨度S[i]定义为: 满足A[j]<=A[j+1]
	 * 且在A[i]之前的连续元素A[j]的最大个数
	 * 
	 * 例:
	 *   A: 6 3 4 5 2 7 ==> S:1 1 2 3 1 2
	 * 
	 */
	int[] FindingSpans(int[] inputArray){
		int[] spans = new int[inputArray.length];
		
		for (int i = 0; i < inputArray.length; i++){
			int span = 1;
			int j = i - 1;
			while(j >= 0 && inputArray[j] <= inputArray[j + 1]){
				span++;
				j--;
			}
			spans[i] = span;
		}
		/*
		 //该方法有错
		ArrayStack2 stack = new ArrayStack2(inputArray.length);
		int p = 0;
		
		for (int i = 0; i < inputArray.length; i++){
			while(!stack.isEmpty() && inputArray[i] > inputArray[(Integer)stack.peek()]){
				stack.pop();
			}
			
			if (stack.isEmpty())
				p = -1;
			else
				p = (Integer)stack.peek();
			spans[i] = i - p;
			stack.push(i);
		}
		*/
		
		return spans;
	}
}
