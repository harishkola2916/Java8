import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author haree
 *
 */
public class DriverCollection {
	public static void main(String args[]) {
		Movie m1 = new Movie("titanic", 9);
		Movie m2 = new Movie("Terminator", 8);
		Movie m3 = new Movie("ring", 7);
		Movie m4 = new Movie("It", 8);
		Movie m5 = new Movie("Avengers", 8);

		List<Movie> movieList = new ArrayList<Movie>(
				Arrays.asList(m1, m2, m3, m4, m5));
		movieList.forEach((m) -> System.out.println(m));

		// remove the movie with rating <8 using removeIf predicate
		movieList.removeIf(movie -> movie.getRating() < 8);

		System.out.println("After removal of movie with rating <8 ");
		// By Using method reference
		movieList.forEach(System.out::println);

		// Replace all movie names with upper case
		movieList.replaceAll(
				(m) -> new Movie(m.getName().toUpperCase(), m.getRating()));
		movieList.forEach(System.out::println);

	}
}
