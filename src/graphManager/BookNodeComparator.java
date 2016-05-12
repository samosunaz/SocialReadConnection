/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * BookNode.java
 * May 8, 2016
 * Version 2.0
 */

package graphManager;
import java.util.Comparator;

public class BookNodeComparator implements Comparator<BookNode> {

	@Override
	public int compare(BookNode o1, BookNode o2) {
		String titleO1 = "";
		String titleO2 = "";
		if (o1.getBookTitle().substring(0, 4).equals("The ")) {
			titleO1 = o1.getBookTitle().substring(4, o1.getBookTitle().length());
		} 
		else if (o1.getBookTitle().substring(0, 2).equals("A ")) {
			titleO1 = o1.getBookTitle().substring(2, o1.getBookTitle().length());
		}
		else {
			titleO1 = o1.getBookTitle();
		}
		if (o2.getBookTitle().substring(0, 4).equals("The ")) {
			titleO2 = o2.getBookTitle().substring(4, o2.getBookTitle().length());
		}
		else if (o2.getBookTitle().substring(0, 2).equals("A ")) {
			titleO2 = o2.getBookTitle().substring(2, o2.getBookTitle().length());
		}
		else {
			titleO2 = o2.getBookTitle();
		}
		return (titleO1.compareTo(titleO2));
	}

}
