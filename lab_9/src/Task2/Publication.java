package Task2;

import java.util.Calendar;

public class Publication implements Comparable<Publication> {
	private String title;
	private int page_count;
	private int publication_year;
	private String author;
	private double price;

	public Publication(String title, int page_count, int publication_year, String author, double price) {
		this.title = title;
		this.page_count = page_count;
		this.publication_year = publication_year;
		this.author = author;
		this.price = price;
	}

	public int compareTo(Publication other) {
		int titleComparison = this.title.compareTo(other.title);
		if (titleComparison != 0) {
			return titleComparison;
		}
		return Integer.compare(other.publication_year, this.publication_year);
	}

	public double getPrice() {
		return price;
	}

	public int getPublicationYear() {
		return publication_year;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isMagazinePublishedTenYearsAgo() {
		Calendar currentYear = Calendar.getInstance();
		int yearDifference = currentYear.get(Calendar.YEAR) - this.publication_year;
		return (this instanceof Magazine) && (yearDifference >= 10);
	}

	public boolean hasSameTypeAndAuthor(Publication other) {
		return this.getClass() == other.getClass() && this.author.equals(other.author);
	}
}