package interview.walmart;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * Example 1:
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * 		  [[],[-2],[0],[-3],[],[],[],[]]
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2);
 * minStack.push(0); 
 * minStack.push(-3); 
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top(); // return 0 
 * minStack.getMin(); // return -2
 * 
 * 
 * Constraints:
 * 
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * 
 * @author Vivek
 *
 */
public class MinStack
{
	private Stack<Integer> stack;
	private PriorityQueue<Integer> minQueue; 
	 /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minQueue = new PriorityQueue<>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	minQueue.add(x);
        
    }
    
    public void pop() {
    	Integer pop = stack.pop();
    	minQueue.remove(pop);
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minQueue.peek();
    }

}
