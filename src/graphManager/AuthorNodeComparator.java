/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * AuthorNodeComparator.java
 * May 8, 2016
 * Version 2.0
 */

package graphManager;
import java.util.Comparator;

public class AuthorNodeComparator implements Comparator<AuthorNode>{

	@Override
	public int compare(AuthorNode author1, AuthorNode author2) {
		return author1.getAuthorName().compareTo(author2.getAuthorName());
	}
}
