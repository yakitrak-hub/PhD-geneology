import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PhDTest {

	@Test
	public void testConstructor1() {
		PhD p = new PhD("Bob", 6, 2015);
		assertEquals("Bob", p.name());
		assertEquals(6, p.month());
		assertEquals(2015, p.year());
		assertEquals(null, p.advisor1());
		assertEquals(null, p.advisor2());
		assertEquals(0, p.numAdvisees());
		// Testing assert statements of Constructor1
		assertThrows(AssertionError.class, () -> {
			new PhD(null, 2, 2014);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("", 2, 2014);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 15, 2014);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014);
		});
	}

	@Test
	public void testSetters() {
		PhD p = new PhD("Sam", 5, 2012);
		PhD b = new PhD("Rob", 2, 2011);
		PhD c = new PhD("Martin", 1, 1960);
		PhD n = new PhD("Neo", 2, 1987);
		PhD m = null;
		p.setAdvisor1(b);
		assertEquals(1, b.numAdvisees());
		assertEquals(b, p.advisor1());
		p.setAdvisor2(c);
		assertEquals(1, c.numAdvisees());
		assertEquals(c, p.advisor2());
		// Testing assert statements of setters
		assertThrows(AssertionError.class, () -> {
			p.setAdvisor1(n);
		});
		assertThrows(AssertionError.class, () -> {
			n.setAdvisor1(m);
		});
		assertThrows(AssertionError.class, () -> {
			n.setAdvisor2(c);
		});
		assertThrows(AssertionError.class, () -> {
			p.setAdvisor2(n);
		});
		assertThrows(AssertionError.class, () -> {
			p.setAdvisor2(m);
		});
		assertThrows(AssertionError.class, () -> {
			p.setAdvisor2(b);
		});
	}

	@Test
	public void testC() {
		PhD b = new PhD("Rob", 2, 2011);
		PhD p = new PhD("Bob", 6, 2015, b);
		assertEquals("Bob", p.name());
		assertEquals(6, p.month());
		assertEquals(2015, p.year());
		assertEquals(b, p.advisor1());
		assertEquals(null, p.advisor2());
		assertEquals(0, p.numAdvisees());
		assertEquals(1, b.numAdvisees());
		PhD c = new PhD("Martin", 1, 2010);
		PhD h = new PhD("Sam", 5, 2012, b, c);
		assertEquals("Sam", h.name());
		assertEquals(5, h.month());
		assertEquals(2012, h.year());
		assertEquals(b, h.advisor1());
		assertEquals(c, h.advisor2());
		assertEquals(0, h.numAdvisees());
		assertEquals(2, b.numAdvisees());
		assertEquals(1, c.numAdvisees());
		// testing assert statements of new constructors
		assertThrows(AssertionError.class, () -> {
			new PhD(null, 2, 2014, b);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("", 2, 2014, b);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 15, 2014, b);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, b);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, null);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD(null, 2, 2014, b, p);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("", 2, 2014, b, p);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 15, 2014, b, p);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, b, p);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, null, p);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, b, null);
		});
		assertThrows(AssertionError.class, () -> {
			new PhD("Rob", 0, 2014, p, p);
		});
	}

	@Test
	public void testD() {
		PhD b = new PhD("Rob", 2, 2011);
		PhD l = new PhD("Rob", 2, 2011);
		PhD p = new PhD("Bob", 6, 2015, b);
		PhD c = new PhD("Martin", 1, 2010);
		PhD h = new PhD("Sam", 5, 2012, b, c);
		PhD o = new PhD("Matt", 5, 2012, c);
		PhD s = new PhD("Suarin", 6, 2011, p, c);
		assertEquals(false, b.hasAdvisee());
		assertEquals(true, p.hasAdvisee());
		assertEquals(true, h.hasAdvisee());
		PhD d = null;
		assertEquals(false, b.gotAfter(d));
		PhD z = new PhD("feb77", 2, 1977);
		PhD y = new PhD("feb77", 2, 1977);
		assertEquals(false, y.gotAfter(z));
		PhD mar24 = new PhD("mar24", 3, 1924);
		PhD june24 = new PhD("june24", 6, 1924);
		assertEquals(false, mar24.gotAfter(june24));
		PhD july24 = new PhD("july24", 7, 1924);
		assertEquals(true, july24.gotAfter(june24));
		PhD feb99 = new PhD("feb99", 2, 1999);
		PhD feb00 = new PhD("feb00", 2, 2000);
		assertEquals(false, feb99.gotAfter(feb00));
		PhD mar99 = new PhD("mar99", 3, 1999);
		assertEquals(false, mar99.gotAfter(feb00));
		PhD jan99 = new PhD("jan99", 1, 1999);
		assertEquals(false, jan99.gotAfter(feb00));
		assertEquals(true, feb00.gotAfter(feb99));
		assertEquals(true, feb00.gotAfter(mar24));
		assertEquals(true, feb00.gotAfter(jan99));
		assertEquals(false, l.areSiblings(l));
		assertEquals(false, b.areSiblings(c));
		assertEquals(true, h.areSiblings(p));
		assertEquals(true, o.areSiblings(h));
		assertEquals(true, h.areSiblings(o));
		assertEquals(true, s.areSiblings(h));
		// testing assert statements of part D methods
		assertThrows(AssertionError.class, () -> {
			s.areSiblings(null);
		});

	}
}
