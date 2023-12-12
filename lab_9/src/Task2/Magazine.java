package Task2;

public class Magazine extends Publication {
	private String magazine_name;

	public Magazine(String title, int page_count, int publication_year, String author, double price,
			String magazine_name) {
		super(title, page_count, publication_year, author, price);
		this.magazine_name = magazine_name;
	}

	public String getMagazineName() {
		return magazine_name;
	}
}