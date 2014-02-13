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
	
	@Test
	public void addAndRemove2FromLast() {
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		deque.addFirst(6);
		assertEquals(6, deque.size());
		assertEquals(1, deque.removeLast().intValue());
		assertEquals(5, deque.size());
		assertEquals(2, deque.removeLast().intValue());
		assertEquals(4, deque.size());
	}

	@Test
	public void testIterator() {
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addLast(4);
		deque.addLast(5);
		deque.addLast(6);
		
		for (Integer i : deque) {
			System.out.println(i);
		}
	}
	
}
