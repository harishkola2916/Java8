import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

/**
 * 
 */

/**
 * @author haree
 *
 */
@FunctionalInterface
public interface CustomComparator<T> extends Comparator<T> {
	@Override
	public int compare(T p1, T p2);

	// to compare ages of person
	/*
	 * public static CustomComparator<Person> comparing( Function<Person,
	 * Integer> f) {
	 * 
	 * return (p1, p2) -> f.apply(p1) - f.apply(p2); }
	 */

	// Now to compare first name and last name we need to write another static
	// method as above method
	// can only take integers as parameters, in order to do that we will change
	// from Integer to Comparable
	// so that it can take Integers and strings as well because both Integer and
	// Strings are comparable objects

	public static <T, U extends Comparable<? super U>> CustomComparator<T> comparing(
			Function<T, U> f) {

		return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
	}

	public default CustomComparator<T> thenComparingex(CustomComparator<T> f) {
		return (p1, p2) -> compare(p1, p2) == 0
				? f.compare(p1, p2)
				: compare(p1, p2);
	}
	public default <U extends Comparable<? super U>> CustomComparator<T> thenComparingex(
			Function<T, U> f) {
		CustomComparator<T> other = comparing(f);
		return thenComparingex(other);
		/*
		 * return (p1, p2) -> { int cmp = this.compare(p1, p2); if (cmp == 0) {
		 * CustomComparator<T> other = comparing(f); return other.compare(p1,
		 * p2); } else { return cmp; } };
		 */

	}

	static <T> CustomComparator<T> nullsLast(CustomComparator<T> cmp) {
		Objects.requireNonNull(cmp);
		return (t1, t2) -> {
			if (t1 == t2) {
				return 0;
			} else if (t1 == null) {
				return 42;
			} else if (t2 == null) {
				return -41;
			} else {
				return cmp.compare(t1, t2);
			}
		};
	}
}
