/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * AuthorNode.java
 * May 8, 2016
 * Version 2.0
 */

package graphManager;
import java.util.ArrayList;
import java.util.List;

public class AuthorNode  {
	
	private String authorName;
	private List<BookNode> bookNodeReference;
	
	public AuthorNode(String authorName) {
		this.authorName = authorName;
		this.bookNodeReference = new ArrayList<BookNode>();
	}
	
	/**
	 * Adds a reference of a BookNode object to this calss
	 * @param bookNode the object that will be the reference
	 */
	public void addBookNode(BookNode bookNode) {
		this.bookNodeReference.add(bookNode);
	}
	
	/**
	 * Sets the author name
	 * @param authorName the name of the author
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	/**
	 * 
	 * @return the name of the author
	 */
	public String getAuthorName() {
		return this.authorName;
	}
	
	/**
	 * Sets a list of the books that an author has
	 * @param bookNodeReference
	 */
	public void setBookNodeReference(List<BookNode> bookNodeReference) {	
	}
	
	/**
	 * 
	 * @return the books that an author has
	 */
	public List<BookNode> getBookNodeReference() {
		return this.bookNodeReference;
	}
	
	public String toString() {
		return "[Author Name]: " + getAuthorName();
	}
	
	
	
}
