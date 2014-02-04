

import static org.junit.Assert.*;

import org.junit.Test;

public class Percolation_UT {
	
	@Test
	public void test1By1() {
		Percolation p = new Percolation(1);
		assertFalse(p.percolates());
		assertFalse(p.isOpen(1, 1));
		p.open(1, 1);
		assertTrue(p.isOpen(1,1));
		assertTrue(p.isFull(1,1));
		assertTrue(p.percolates());
	}

	@Test
	public void test2By2DownLeft() {
		Percolation p = new Percolation(2);
		assertFalse(p.percolates());
		p.open(1, 1);
		assertTrue(p.isFull(1,1));
		assertFalse(p.isFull(1,2));
		assertFalse(p.percolates());
		p.open(2, 1);
		assertTrue(p.isFull(2,1));
		assertTrue(p.percolates());
	}
	
	@Test
	public void test2By2UpLeft() {
		Percolation p = new Percolation(2);
		assertFalse(p.percolates());
		p.open(2, 1);
		assertFalse(p.isFull(1,1));
		assertFalse(p.percolates());
		p.open(1, 1);
		assertTrue(p.isFull(1,1));
		assertTrue(p.isFull(2,1));
		assertTrue(p.percolates());
	}
	
	@Test
	public void test3By3DownRightDown() {
		Percolation p = new Percolation(3);
		assertFalse(p.percolates());
		p.open(1,1);
		assertFalse(p.percolates());
		p.open(2, 1);
		assertFalse(p.percolates());
		p.open(2, 2);
		assertFalse(p.percolates());
		p.open(3, 2);
		assertTrue(p.percolates());
	}

	@Test
	public void test3By3DownLeftDown() {
		Percolation p = new Percolation(3);
		assertFalse(p.percolates());
		p.open(1,3);
		assertFalse(p.percolates());
		p.open(2, 3);
		assertFalse(p.percolates());
		p.open(2, 2);
		assertFalse(p.percolates());
		p.open(3, 2);
		assertTrue(p.percolates());
	}
}