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
	
	public int getTitleKey(String bookTitle) {
		return (int) bookTitle.charAt(0);
	}
	
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
	
	public void put(BookNode bookNode) {
		HashEntryTitle tempTable = new HashEntryTitle(bookNode);
		int hash = (tempTable.getKey() % TABLE_SIZE);
		this.theTable[hash].add(tempTable);
	}
}
