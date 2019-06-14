/*
 * Performs searches
 * Searches.java
 * ICS4U
 * May 18, 2019
 * Ryan Larkin, Dmitry Tsarapkine, Kevin Kurra
 */
package rst.datastructures;

import java.util.Objects;

public class Searches {
	public static final int NOT_FOUND = -1;
	
	/**
	 * Search result
	 * Pre: items and goal
	 * Post: the result has been returned
	 */
	public static <T extends Number & Comparable<? super T>> int interpolationSearchNonRecursive(T[] items, T goal) {
		//Stores the start position
		int start = 0;
		//Stores the end position
		int end = items.length - 1;
		
		//Loops through each element
		while (start <= end && goal.compareTo(items[start]) <= 0 & goal.compareTo(items[end]) >= 0) {
			//Determines index
			int index = (int)(start + (end - start) * (goal.doubleValue() - items[start].doubleValue()) / (items[end].doubleValue() - items[start].doubleValue()));
			
			//Executes based on the relative comparison of the goal
			if (goal.compareTo(items[index]) == 0) {
				return index;
			} else if (goal.compareTo(items[index]) < 0) {
				end = index - 1;
			} else {
				start = index + 1;
			}
		}
		
		//Returns the search result
		return NOT_FOUND;
	}
	
	/**
	 * Returns search result
	 * Pre: items, and the goal
	 * Post: search result has been returned
	 */
	public static <T extends Number & Comparable<? super T>> int interpolationSearchRecursive(T[] items, T goal) {
		//Returns the interpolation search result
		return interpolationSearch(items, 0, items.length - 1, goal, 0);
	}
	
	/**
	 * Searches items array for goal pre: items is sorted from low to high post:
	 * Position of goal has been returned, or -1 has been returned if goal not
	 * found.
	 */
	private static <T extends Number & Comparable<? super T>> int interpolationSearch(T[] items, int start, int end, T goal, int count) {
		//The end has been reached
		if (start > end || goal.compareTo(items[start]) > 0 || goal.compareTo(items[end]) < 0) {
			return NOT_FOUND;
		} else {
			//Determines index
			int index = (int)(start + (end - start) * (goal.doubleValue() - items[start].doubleValue()) / (items[end].doubleValue() - items[start].doubleValue()));
			
			//Determines the position 
			if (goal.compareTo(items[index]) == 0) {
				return index;
			} else if (goal.compareTo(items[index]) < 0) {
				return (interpolationSearch(items, start, index - 1, goal, count + 1));
			} else {
				return (interpolationSearch(items, index + 1, end, goal, count + 1));
			}
		}
	}
	
	/**
	 * Search result
	 * Pre: items and a goal
	 * Post: the search result has been returned
	 */
	public static <T extends Comparable<? super T>> int binarySearchRecursive(T[] items, T goal) {
		//Returns binary search result
		return binarySearch(items, 0, items.length - 1, goal, 0);
	}
	
	/**
	 * Searches items array for goal pre: items is sorted from low to high post:
	 * Position of goal has been returned, or -1 has been returned if goal not
	 * found.
	 */
	private static <T extends Comparable<? super T>> int binarySearch(T[] items, int start, int end, T goal, int count) {
		//Not found
		if (start > end) {
			return NOT_FOUND;
		} 
		//Uses binary search to determine the location
		else {
			//Determines middle
			int mid = (start + end) / 2;

			//Compares goal to the middle
			if (goal.compareTo(items[mid]) == 0) {
				return mid;
			} else if (goal.compareTo(items[mid]) < 0) {
				return (binarySearch(items, start, mid - 1, goal, count + 1));
			} else {
				return (binarySearch(items, mid + 1, end, goal, count + 1));
			}
		}
	}
	
	/**
	 * Searches items array for goal pre: items is sorted from low to high post:
	 * Position of goal has been returned, or -1 has been returned if goal not
	 * found.
	 */
	public static <T extends Comparable<? super T>> int binarySearchNonRecursive(T[] items, T goal) {
		//Stores the start
		int start = 0;
		//Stores the end
		int end = items.length - 1;
		
		//Determines position if end has not been reached
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (goal.compareTo(items[mid]) == 0) {
				return mid;
			} else if (goal.compareTo(items[mid]) < 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return NOT_FOUND;
	}
	
	/**
	 * Determines search result
	 * Pre: elements and the item to search for
	 * Post: the result has been returned
	 */
	public static <T extends Comparable<? super T>> int linearSearch(T[] elements, T search) {
		int i;
		//Loops through each element
		for(i = 0; i < elements.length; i++) {
			if(Objects.equals(elements[i], search)) {
				return i;
			}
		}
		
		//Returns the result
		return NOT_FOUND;
	}
}
