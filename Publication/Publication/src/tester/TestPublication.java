package tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import static utils.publicationUtils.populatePublication;
import static utils.publicationUtils.validateBooks;
import static utils.publicationUtils.validateTapes;
import com.app.core.Publication;
import com.app.core.*;
public class TestPublication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				HashMap<Integer, Publication> publications = populatePublication();
				try {
					System.out.println(
							"Choose from the following:\r\n 1.Publish a new book\r\n 2.Publish new tape\r\n 3.List all by descending order\r\n"
									+ " 4.Top 5 based on rating\r\n 5.Remove 5year old\r\n 6.Display\r\n 0.exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the followin details to publish a book:  title, price, publishingDate,rating, pages");
						   Book book = validateBooks(sc.next(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), publications); 
						   publications.put(book.getId(), book);
						   System.out.println("book added sucessifully11");
						break;
						
					case 2:
						System.out.println("Enter the followin details to publish a Tape:  title, price, publishingDate,rating, Playing time");
						Tape tape = validateTapes(sc.next(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), publications);
						publications.put(tape.getId(), tape);
						break;
						
					case 3://3.List all by descending order\r\n"
						publications.values().stream().filter(p -> p instanceof Book) // Filter only books
				        .map(p -> (Book) p) // Cast to Book
				        .sorted(Comparator.comparing(Book::getPublishingDate).reversed()) // Sort by publishing date
				        .forEach(System.out::println);
						break;
						
					case 4://Top 5 based on rating
						publications.values().stream().sorted(Comparator.comparing(Publication::getRating).reversed()).limit(5).forEach(System.out::println);
						break;
						
					case 5://5.Remove 5year old
						Iterator<Publication> itr = publications.values().iterator();
						while(itr.hasNext()) {
							Period period = Period.between(itr.next().getPublishingDate(), LocalDate.now());
							int years = period.getYears();
							if(years>5) {
								itr.remove();
							}
						}
						break;
					case 6:
						publications.values().forEach(System.out::println);
						
						break;
					case 0:
						exit=true;
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		}

	}

}