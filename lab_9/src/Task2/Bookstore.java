package Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Bookstore {
    private List<Publication> publications;

    public Bookstore() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public double calculateTotalPrice() {
        return publications.stream().mapToDouble(Publication::getPrice).sum();
    }

    public ReferenceBook findReferenceBookWithMostPages() {
        return (ReferenceBook) publications.stream()
                .filter(publication -> publication instanceof ReferenceBook)
                .max(Comparator.comparingInt(pub -> ((ReferenceBook) pub).getMaxChapterPageCount()))
                .orElse(null);
    }

    public boolean containsMagazineWithName(String magazineName) {
        return publications.stream()
                .anyMatch(publication -> publication instanceof Magazine && ((Magazine) publication).getMagazineName().equals(magazineName));
    }

    public List<Magazine> getMagazinesPublishedInYear(int year) {
        return publications.stream()
                .filter(publication -> publication instanceof Magazine && publication.getPublicationYear() == year)
                .map(publication -> (Magazine) publication)
                .collect(Collectors.toList());
    }

    public void sortPublications() {
        Collections.sort(publications);
    }

    public Map<Integer, Integer> countPublicationsByYear() {
        Map<Integer, Integer> countByYear = new HashMap<>();
        for (Publication publication : publications) {
            int year = publication.getPublicationYear();
            countByYear.put(year, countByYear.getOrDefault(year, 0) + 1);
        }
        return countByYear;
    }

    public List<Publication> getPublications() {
        return publications;
    }
}