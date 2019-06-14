/*
 * Sorts stuff
 * Sorts.java
 * ICS4U
 * May 18, 2019
 * Ryan Larkin, Dmitry Tsarapkine, Kevin Kurra
 */
package rst.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Sorts {

	/**
	 * Performs a selection sort
	 * Pre :elements
	 * Post: the sort has been performed
	 */
	public static <T extends Comparable<? super T>> void selectionSort(List<T> elements) {
		// Choose an initial element to find a location for
		for (int index = 0; index < elements.size(); index++) {
			// Find an element to swap with
			for (int subIndex = index; subIndex < elements.size(); subIndex++) {
				// Check if swap is necessary
				if (elements.get(subIndex).compareTo(elements.get(index)) < 0) {
					// Swap the elements
					T temp = elements.get(index);
					elements.set(index, elements.get(subIndex));
					elements.set(subIndex, temp);
				}
			}
		}
	}

	/**
	 * Performs an insertion sort
	 * Pre: elements
	 * Post: the elements have been sorted
	 */
	public static <T extends Comparable<? super T>> void insertionSort(List<T> elements) {
		T temp;
		int previousIndex;
		for (int index = 1; index < elements.size(); index++) {
			temp = elements.get(index);
			previousIndex = index - 1;
			while ((elements.get(previousIndex).compareTo(temp) > 0) && (previousIndex > 0)) {
				elements.set(previousIndex + 1, elements.get(previousIndex));
				previousIndex -= 1; // decrease index to compare //current item with next
				// previous item
			}
			if (elements.get(previousIndex).compareTo(temp) > 0) {
				/* shift item in first element up into next element */ elements.set(previousIndex
						+ 1, elements.get(previousIndex));
				/* place current item at index 0 (first element) */
				elements.set(previousIndex, temp);
			} else {
				/*
				 * place current item at index ahead of previous item
				 */
				elements.set(previousIndex + 1, temp);
			}
		}
	}

	/**
	 * Performs a merge sort
	 * Pre: elements 
	 * Post: the merge sort has been completed
	 */
	public static <T extends Comparable<? super T>> void mergeSort(List<T> elements) {
		//Performs a mergesort
		mergesort(elements, 0, elements.size() - 1);
	}

	/**
	 * Merges two sorted portion of items array pre: items[start .. mid] is sorted.
	 * items[mid+1 .. end] sorted. start <= mid <= end post: items[start .. end] is
	 * sorted.
	 */
	private static <T extends Comparable<? super T>> void merge(List<T> items, int start, int mid, int end) {
		List<T> temp = new ArrayList<>(items.size());
		for(int i = 0; i < items.size(); i++) {
			temp.add(null);
		}
		
		//Stores critical positions
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;

		//Merges the items
		while (!(pos1 > mid && pos2 > end)) {
			if ((pos1 > mid) || ((pos2 <= end) && (items.get(pos2).compareTo(items.get(pos1))) < 0)) {
				temp.set(spot, items.get(pos2));
				pos2 += 1;
			} else {
				temp.set(spot, items.get(pos1));
				pos1 += 1;
			}
			spot += 1;
		}

		/* copy values from temp back to items */
		for (int i = start; i <= end; i++) {
			items.set(i, temp.get(i));
		}
	}

	/**
	 * Sorts items [start .. end] pre: start > 0, end > 0 post: items[start .. end]
	 * is sorted low to high
	 */
	public static <T extends Comparable<? super T>> void mergesort(List<T> items, int start, int end) {
		//If it hasn't reached the end, performs a recursive merge
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(items, start, mid);
			mergesort(items, mid + 1, end);
			merge(items, start, mid, end);
		}
	}

}
