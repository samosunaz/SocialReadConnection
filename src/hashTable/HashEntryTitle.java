package hashTable;
import graphManager.BookNode;

public class HashEntryTitle {
	
	private int theKey;
	private BookNode bookNode;
	
	public HashEntryTitle(BookNode bookNode) {
		this.theKey = createKey(bookNode);
		this.bookNode = bookNode;
	}
	
	private int createKey(BookNode bookNode) {
		return (int) bookNode.getBookTitle().charAt(0);
	}
	
	public void setBookNode(BookNode bookNode) {
		this.bookNode = bookNode;
	}
	
	public BookNode getBookNode() {
		return this.bookNode;
	}
	
	public int getKey() {
		return this.theKey;
	}
}
