// I checked the Javadoc ouput and it was OK.
/**
 * NetId: kj295. Time spent: 6 hours, 47 minutes. An instance maintains info
 * about the PhD of a person.
 */
public class PhD {
	private String name; // Name of the person with a PhD, with length > 0
	private int month; // Month PhD awarded, in 1..12 with 1 being January
	private int year; // Year PhD awarded, can be any integer
	private PhD advisor1; // First PhD advisor of the person, null if unknown
	private PhD advisor2; // Second PhD advisor of the person, null if unknown
							// or if the person has less than two advisors.
	private int advisees; // Number of PhD advisees of this person

	/**
	 * Constructor: an instance for a person with name n, PhD month m, PhD year
	 * y. Its advisors are unknown, and it has no advisees. Precondition: n has
	 * at least 1 char and m is in 1..12.
	 */
	public PhD(String n, int m, int y) {
		assert n != null && n.length() >= 1;
		assert 12 >= m && m >= 1;
		name = n;
		month = m;
		year = y;
		advisor1 = null;
		advisor2 = null;
		advisees = 0;
	}

	/** Return the name of this person. */
	public String name() {
		return name;
	}

	/** Return the month this person got their PhD. */
	public int month() {
		return month;
	}

	/** Return the year this person got their PhD. */
	public int year() {
		return year;
	}

	/** Return the first advisor of this PhD (null if unknown). */
	public PhD advisor1() {
		return advisor1;
	}

	/**
	 * Return the second advisor of this PhD (null if unknown or non-existent).
	 */
	public PhD advisor2() {
		return advisor2;
	}

	/** Return the number of PhD advisees of this person. */
	public int numAdvisees() {
		return advisees;
	}

	/**
	 * Add p as the first advisor of this person. Precondition: the first
	 * advisor is unknown and p is not null.
	 */
	public void setAdvisor1(PhD p) {
		assert advisor1 == null && p != null;
		advisor1 = p;
		p.advisees += 1;

	}

	/**
	 * Add p as the second advisor of this person. Precondition: The first
	 * advisor (of this person) is known, the second advisor is unknown, p is
	 * not null, and p is different from the first advisor.
	 */
	public void setAdvisor2(PhD p) {
		assert advisor1 != null;
		assert advisor2 == null;
		assert p != null;
		assert p != advisor1;
		advisor2 = p;
		p.advisees += 1;
	}

	/**
	 * Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	 * adv1, and no second advisor. Precondition: n has at least 1 char, m is in
	 * 1..12, and adv1 is not null.
	 */
	public PhD(String n, int m, int y, PhD adv1) {
		assert n != null && n.length() >= 1;
		assert 12 >= m && m >= 1;
		assert adv1 != null;
		name = n;
		month = m;
		year = y;
		advisor1 = adv1;
		advisor2 = null;
		advisees = 0;
		adv1.advisees += 1;
	}

	/**
	 * Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	 * adv1, and second advisor adv2. Precondition: n has at least 1 char, m is
	 * in 1..12, adv1 and adv2 are not null, and adv1 and adv2 are different.
	 */
	public PhD(String n, int m, int y, PhD adv1, PhD adv2) {
		assert n != null && n.length() >= 1;
		assert 12 >= m && m >= 1;
		assert adv1 != null && adv2 != null;
		assert adv1 != adv2;
		name = n;
		month = m;
		year = y;
		advisor1 = adv1;
		advisor2 = adv2;
		advisees = 0;
		adv1.advisees += 1;
		adv2.advisees += 1;
	}

	/**
	 * Return value of "this PhD has at least one advisee", i.e. true if this
	 * PhD has at least one advisee and false otherwise
	 */
	public boolean hasAdvisee() {
		if (advisor1 != null || advisor2 != null)
			return true;
		return false;
	}

	/** Return value of "p is not null and this person got the PhD after p.”*/
	public boolean gotAfter(PhD p) {
		if (p != null && this.year != p.year() && this.year > p.year())
			return true;
		if (p != null && this.year != p.year() && this.year < p.year())
			return false;
		if (p != null && this.year == p.year() && this.month > p.month())
			return true;
		return false;
	}

	/**
	 * Return value of "this person and p are intellectual siblings."
	 * Precondition: p is not null.
	 */
	public boolean areSiblings(PhD p) {
		assert p != null;
		if (this != p && this.advisor1 != null && p.advisor1() != null
				&& this.advisor1 == p.advisor1())
			return true;
		if (this != p && this.advisor1 != null && p.advisor2() != null
				&& this.advisor1 == p.advisor2())
			return true;
		if (this != p && this.advisor2 != null && p.advisor1() != null
				&& this.advisor2 == p.advisor1())
			return true;
		if (this != p && this.advisor2 != null && p.advisor2() != null
				&& this.advisor2 == p.advisor2())
			return true;
		return false;
	}
}
