package org.ds.algos.practice.ds_algos;

import java.util.Stack;

/**
 * This class uses 2 stack to implement the functionality of the queue.
 * @author pulgupta
 *
 */
class QueueUsingStackTest {
	
	private Stack<Integer> stack;
	private Stack<Integer> stack_temp;
	
	public QueueUsingStackTest() {
		stack = new Stack<>();
		stack_temp = new Stack<>();
	}
	
	/**
	 * We shift the elemet from the first stack to a new stack and then
	 * add the new element. We again shifts back the elements.Hence the added 
	 * element will be at the end
	 * @param item
	 */
	public void enqueue(Integer item) {
		if(stack.isEmpty()==true) {
			stack.push(item);
		}
		else {
			
			//Move all the item to the second stack 
			while(stack.empty()!=true) {
				stack_temp.push(stack.pop());
			}
			
			stack.push(item); //add the new item at the end
			
			while(stack_temp.empty()!=true) {
				stack.push(stack_temp.pop());
			}
		}
			
	}
	
	/**
	 * No trick as again we just have to remove the element from the 
	 * top
	 * @return
	 */
	public Integer dequeue() {
		return stack.pop();
	}
	
	public void print_top() {
		System.out.println("Element at the top is : " + stack.peek());
	}
}

public class QueueUsingStack {
	public static void main(String[] args) {
		QueueUsingStackTest qus = new QueueUsingStackTest();
		qus.enqueue(1);
		qus.enqueue(2);
		qus.enqueue(3);
		qus.print_top();
		qus.dequeue();
		qus.print_top();
		qus.dequeue();
		qus.print_top();
	}
}
