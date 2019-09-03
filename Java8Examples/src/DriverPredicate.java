/**
 * 
 */

/**
 * @author haree
 *
 */
public class DriverPredicate {
	public static void main(String args[]) {

		CustomPredicate<String> s1 = p -> p.length() > 5; // first predicate
		CustomPredicate<String> s2 = p -> p.length() < 15; // second predicate
		boolean b = s1.test("MyLaptop");
		System.out.println("B is true or false?? --" + b);

		// For and condition of two predicates
		CustomPredicate<String> result = s1.andCheck(s2);

		CustomPredicate<String> orResult = s1.orCheck(s2);

		CustomPredicate<String> eqResult = CustomPredicate.isEqual("Hello");

		// Now test the predicate by passing a second string to the predicate
		// p3(which contains predicate of p1 and p2)

		System.out.println("Predicate for Lenovo --" + result.test(" Lenovo"));

		System.out.println("Predicate for mzcbook --"
				+ orResult.test("Apple Macbook Pro"));

		System.out.println("Predicate isequals --" + result.test("Hello"));

	}

}
