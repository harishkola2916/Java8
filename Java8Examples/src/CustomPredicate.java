import java.util.function.Predicate;

/**
 * 
 */

/**
 * @author haree
 *
 */
@FunctionalInterface
public interface CustomPredicate<T> extends Predicate<T> {
	@Override
	public boolean test(T t);

	public default CustomPredicate<T> andCheck(
			CustomPredicate<T> inputPredicate) {
		return (existingPredicate) -> test(existingPredicate)
				&& inputPredicate.test(existingPredicate);
	}

	public default CustomPredicate<T> orCheck(
			CustomPredicate<T> inputPredicate) {
		return (existingPredicate) -> test(existingPredicate)
				|| inputPredicate.test(existingPredicate);
	}

	public static CustomPredicate<String> isEqual(String s2) {
		return (s) -> s.equals(s2);

	}

}
