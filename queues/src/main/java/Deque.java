import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first = null;
	private Node last = null;

	private int size = 0;

	// construct an empty deque
	public Deque() {

	}

	// is the deque empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// // return the number of items on the deque
	public int size() {
		return size;
	}

	// insert the item at the front
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
		final Node node = new Node(item);
		node.next = first;
		if (first != null)
			first.prev = node;
		first = node;
		
		// if there is no last, the node is also the last
		if (last == null)
			last = node;
			
		size++;
	}

	// insert the item at the end
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
	}

	// delete and return the item at the front
	public Item removeFirst() {
		if (first == null) 
			throw new NoSuchElementException();
		final Node toRemove = first;
		final Node newFirst = first.next;
		if (newFirst != null)
			newFirst.prev = null;
		first = newFirst;
		size--;
		toRemove.next = null;
		return toRemove.value;
	}

	// delete and return the item at the end
	public Item removeLast() {
		if (last == null) 
			throw new NoSuchElementException();
		final Node toRemove = last;
		final Node newLast = last.prev;
		if (newLast != null)
			newLast.next = null;
		first = newLast;
		size--;
		toRemove.prev = null;
		return toRemove.value;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return null;

	}

	private class Node {
		Node(Item value) {
			this.value = value;
		}

		Item value;
		Node prev;
		Node next;
	}

	// unit testing
	public static void main(String[] args) {
	}

}