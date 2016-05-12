/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * HashEntryTitle.java
 * May 8, 2016
 * Version 2.0
 */

package hashTable;
import graphManager.BookNode;

public class HashEntryTitle {
	
	private int theKey;
	private BookNode bookNode;
	
	public HashEntryTitle(BookNode bookNode) {
		this.theKey = createKey(bookNode);
		this.bookNode = bookNode;
	}
	
	/**
	 * Creates a key for a BookNode object
	 * @param bookNode the BookNode that the key is going to be created
	 * @return a value of the key
	 */
	private int createKey(BookNode bookNode) {
		return (int) bookNode.getBookTitle().charAt(0);
	}
	
	/**
	 * Sets a BookNode
	 * @param bookNode the BookNode to set
	 */
	public void setBookNode(BookNode bookNode) {
		this.bookNode = bookNode;
	}
	
	/**
	 * 
	 * @return a BookNode
	 */
	public BookNode getBookNode() {
		return this.bookNode;
	}
	
	/**
	 * 
	 * @return the value of the key
	 */
	public int getKey() {
		return this.theKey;
	}
}
