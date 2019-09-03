/**
 * 
 */

/**
 * @author haree
 *
 */
public class Movie {
	private String name;
	private int rating;

	/**
	 * @param name
	 * @param rating
	 */
	public Movie(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + "]";
	}

}
