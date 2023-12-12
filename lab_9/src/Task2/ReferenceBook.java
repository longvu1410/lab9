package Task2;

import java.util.List;

public class ReferenceBook extends Publication {
	private String field;
	private List<Chapter> chapters;

	public ReferenceBook(String title, int page_count, int publication_year, String author, double price, String field,
			List<Chapter> chapters) {
		super(title, page_count, publication_year, author, price);
		this.field = field;
		this.chapters = chapters;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public int getMaxChapterPageCount() {
		return chapters.stream().mapToInt(Chapter::getPageCount).max().orElse(0);
	}
}