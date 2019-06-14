/*
 * Stack data structure
 * Stack.java
 * ICS4U
 * January 31st, 2019
 * Ryan Larkin, Dmitry Tsarapkine, Kevin Kurra
 */
package rst.datastructures;

import java.util.ArrayList;
import java.util.List;


public class Stack<E> {
	private List<E> data;

	/**
	 * constructor pre: none post: An empty stack that can hold up to maxItems has
	 * been created.
	 */

	public Stack() {
		//Stores the data
		data = new ArrayList<E>();
	}

	/**
	 * Returns the top item without removing it from the stack. pre: Stack contains
	 * at least one item. post: The top item has been returned while leaving it on
	 * the stack.
	 */
	public E top() {
		//Returns the top of the data
		return data.get(data.size() - 1);
	}

	/**
	 * Removes the top item from the stack and returns it. pre: Stack contains at
	 * least one item. post: The top item of the stack has been removed and
	 * returned.
	 */
	public E pop() {
		//Gets the top value
		E val = top();
		//Removes the top value
		data.remove(data.size() - 1);
		//Returns the top value
		return val;
	}

	/**
	 * Adds an item to the top of the stack if there is room. pre: none post: A new
	 * item has been added to the top of the stack.
	 */
	public void push(E val) {
		//Adds an item to the top of the stack
		data.add(val);
	}

	/**
	 * Determines if there are items on the stack. pre: none post: true returned if
	 * there are items on the stack, false returned otherwise.
	 */
	public boolean isEmpty() {
		//Returns whether there are items in the stack
		return data.isEmpty();
	}

	/**
	 * Returns the number of items in the stack. pre: none post: The number of items
	 * in the stack is returned.
	 */
	public int size() {
		//Returns the number of items in the stack
		return data.size();
	}

	/**
	 * Empties the stack. pre: none post: There are no items in the stack.
	 */
	public void makeEmpty() {
		//Pops every item in the stack
		while(!isEmpty()) {
			pop();
		}
	}
}
