import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;


public class Deque_UT {
	
	private Deque<Integer> deque = new Deque<Integer>();
	
	@Test(expected = NullPointerException.class)
	public void throwsNullIfAddFirstNull() {
		deque.addFirst(null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeFirstWhenEmpty() {
		deque.removeFirst();
	}
	
	@Test(expected = NullPointerException.class)
	public void throwsNullIfAddLastNull() {
		deque.addLast(null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeLastWhenEmpty() {
		deque.removeLast();
	}
	
	@Test
	public void addFirstRemoveFirst() {
		assertTrue(deque.isEmpty());
		assertEquals(deque.size(), 0);
		deque.addFirst(1);
		assertFalse(deque.isEmpty()); 
		assertEquals(1, deque.removeFirst().intValue());
		assertTrue(deque.isEmpty());
		assertEquals(deque.size(), 0);
	}
	
	@Test
	public void addFirstRemoveLast() {
		deque.addFirst(1);
		assertEquals(1, deque.removeLast().intValue());
		assertTrue(deque.isEmpty());
	}
	
}
