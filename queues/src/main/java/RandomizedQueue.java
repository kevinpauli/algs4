import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {

	private int tail = 0;
	private int head = 0;
	private int N = 0;
	private Item[] items;

	// construct an empty randomized queue
	public RandomizedQueue() {
		items = (Item[]) new Object[1];
	}

	// is the queue empty?
	public boolean isEmpty() {
		return N == 0;
	}

	// return the number of items on the queue
	public int size() {
		return N;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		if (head >= items.length)
			resize(items.length * 2);
		items[head] = item;
		head++;
		N++;
	}

	private void resize(int capacity) {
		final Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = items[i];
		items = copy;
	}

	// delete and return a random item
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		final Item item = items[tail];
		
	}

	// return (but do not delete) a random item
	public Item sample() {
		return null;
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return null;
	}

	// unit testing
	public static void main(String[] args) {

	}
}