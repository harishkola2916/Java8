import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * 
 */

/**
 * @author haree
 *
 */
public class DriverComparator {

	public static void main(String args[]) {

		Person p11 = new Person(24, "Joseph", "Matt");
		Person p21 = new Person(36, "Matt", "Thomas");
		Person p31 = new Person(21, "Charlie", "Thomas");

		// List<Person> personList = new ArrayList<Person>();
		// personList.add(p11); // personList.add(p21); // personList.add(p31);
		List<Person> personList = Arrays.asList(p11, p21, p31);
		cmprePersonsByAgeUsingLmbda(personList);
		cmprePersonsByFirstNameUsingLmbda(personList);
		cmprePersonsByLastNameUsingLmbda(personList);

		// Instead of writing 3 comparators why can't we use one compartor to
		// compare persons using one field by supplying what field we can
		// to compare them on.
		// To get the field you have to write lambdaexpresions by passing person
		// object
		Function<Person, Integer> f1 = (p) -> p.getAge();
		Function<Person, String> f2 = (p) -> p.getFirstName();
		Function<Person, String> f3 = (p) -> p.getLastName();

		// CustomComparator.comparing(f1);
		// CustomComparator.comparing(f2);
		// We can write this one using method reference as well instead of f1
		CustomComparator<Person> persage = CustomComparator
				.comparing(Person::getAge);
		CustomComparator<Person> persfname = CustomComparator
				.comparing(Person::getFirstName);

		// Comparator<Person> persComp = persage.thenComparing(persfname);
		// above call compares age, if they are equal it compares by firstname
		// using default method.. here in the above method i am passing
		// customcomparator<Person> type to thencomparing method but whatif
		// if i wanted to pass method references like below

		// CustomComparator<Person> persComparing = (CustomComparator<Person>)
		// CustomComparator
		// .comparing(Person::getAge).thenComparingex(Person::getFirstName)
		// .thenComparing(Person::getLastName);
		// CustomComparator<Person> nullCheck = CustomComparator
		// .nullsLast(persComparing);
		//
		Function<Person, String> getLastName = p -> p.getLastName();
		Function<Person, String> getFirstName = p -> p.getFirstName();
		Function<Person, Integer> getAge = p -> p.getAge();

		CustomComparator<Person> cmp = CustomComparator
				.comparing(Person::getLastName).thenComparingex(getFirstName)
				.thenComparingex(getAge);

		CustomComparator<Person> cmpNull = CustomComparator.nullsLast(cmp);

		Collections.sort(personList, cmpNull);
		// personList.sort(cmpNull);
		System.out.println(personList.toString());
	}

	public static void cmprePersonsByAgeUsingLmbda(List<Person> list) {
		System.out.println("Before Sorting ");
		System.out.println(list.toString());
		/*
		 * CustomComparator<Person> persComp = (p1, p2) -> p1.getAge() -
		 * p2.getAge(); personList.sort(persComp); // Cannot work because of
		 * type persComp
		 */
		list.sort((p1, p2) -> p1.getAge() - p2.getAge());
		System.out.println(
				"Using Lamdaexpression and creating custom comparator to sort based on person age");
		System.out.println(list.toString());

	}

	public static void cmprePersonsByFirstNameUsingLmbda(List<Person> list) {
		System.out.println("Before Sorting ");
		System.out.println(list.toString());
		// As both firstnames and lastnames are string we have to use compareTo
		// method
		list.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		System.out.println(
				"Using Lamdaexpression and creating custom comparator to sort based on person firstName");
		System.out.println(list.toString());

	}

	public static void cmprePersonsByLastNameUsingLmbda(List<Person> list) {
		System.out.println("Before Sorting ");
		System.out.println(list.toString());
		// As both firstnames and lastnames are string we have to use compareTo
		// method
		list.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		System.out.println(
				"Using Lamdaexpression and creating custom comparator to sort based on person LastName");
		System.out.println(list.toString());

	}

}
