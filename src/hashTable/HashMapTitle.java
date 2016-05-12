/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * HashMapTitle.java
 * May 8, 2016
 * Version 2.0
 */

package hashTable;
import java.util.ArrayList;
import java.util.List;

import graphManager.BookNode;

public class HashMapTitle {
	
	private static final int TABLE_SIZE = 256;
	private List<HashEntryTitle>[] theTable;
	
	public HashMapTitle() {
		this.theTable = new List[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			this.theTable[i] = new ArrayList<HashEntryTitle>();
		}
	}
	
	/**
	 * 
	 * @param bookTitle the book to get the its key
	 * @return the value of the key of the book
	 */
	public int getTitleKey(String bookTitle) {
		return (int) bookTitle.charAt(0);
	}
	
	/**
	 * Gets a BookNode based on its key
	 * @param bookTitle the book to be get
	 * @return a BookNode
	 */
	public BookNode get(String bookTitle) {
		BookNode bookNode = null;
		int hash = (getTitleKey(bookTitle) % TABLE_SIZE);
		if (this.theTable[hash] != null) {
			for (int i = 0; i < this.theTable[hash].size(); i++) {
				if (this.theTable[hash].get(i).getBookNode().getBookTitle().equals(bookTitle)) {
					bookNode = this.theTable[hash].get(i).getBookNode();
					break;
				}
			}
		}
		return bookNode;
	}
	
	/**
	 * Puts a key value to a BookNode
	 * @param bookNode the BookNode that the key is going to be added
	 */
	public void put(BookNode bookNode) {
		HashEntryTitle tempTable = new HashEntryTitle(bookNode);
		int hash = (tempTable.getKey() % TABLE_SIZE);
		this.theTable[hash].add(tempTable);
	}
}
