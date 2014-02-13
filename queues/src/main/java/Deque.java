import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first = new Node();
	private Node last = new Node();

	private int size = 0;

	// construct an empty deque
	public Deque() {
		first.next = last;
		last.prev = first;
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
		final Node value = new Node(item);
		value.prev = first;
		value.next = first.next;
		first.next.prev = value;
		first.next = value;
		size++;
	}

	// insert the item at the end
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		final Node value = new Node(item);
		value.next = last;
		value.prev = last.prev;
		last.prev.next = value;
		last.prev = value;
		size++;
	}

	// delete and return the item at the front
	public Item removeFirst() {
		if (size == 0) 
			throw new NoSuchElementException();
		final Node value = first.next;
		first.next = value.next;
		value.next.prev = value.prev;
		value.prev = null;
		value.next = null;
		final Item item = value.value;
		value.value = null;
		size--;
		return item;
	}

	// delete and return the item at the end
	public Item removeLast() {
		if (size == 0) 
			throw new NoSuchElementException();
		final Node value = last.prev;
		last.prev = value.prev;
		value.prev.next = value.next;
		value.prev = null;
		value.next = null;
		final Item item = value.value;
		value.value = null;
		size--;
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			
			private Node current = first;

			@Override
			public boolean hasNext() {
				return current.next != last;
			}

			@Override
			public Item next() {
				if (!hasNext())
					throw new NoSuchElementException();
				current = current.next;
				return current.value;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}} ;

	}

	private class Node {
		Node() {
		}
		
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