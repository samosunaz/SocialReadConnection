/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * BookNode.java
 * May 8, 2016
 * Version 2.0
 */

package graphManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import hashTable.HashMapTitle;

public class Graph {

	private List<BookNode> bookNodeList;
	private List<AuthorNode> authorNodeList;
	private HashMapTitle hashTitle; 

	public Graph() {
		this.bookNodeList = new ArrayList<BookNode>();
		this.authorNodeList = new ArrayList<AuthorNode>();
		this.hashTitle = new HashMapTitle();
		loadBooksFromFile();
	}

	public void addBookNodeToGraph(BookNode bookNodeToAdd) {
		if (this.bookNodeList.contains(bookNodeToAdd)) {
			System.out.println("The Book Is Already In The Graph");
		}
		else {
			for (BookNode bookNode : this.bookNodeList) {
				bookNode.addSimilarBookNodes(bookNodeToAdd);
			}
			this.bookNodeList.add(bookNodeToAdd);
			this.hashTitle.put(bookNodeToAdd);
			AuthorNode tempAuthorNode = searchForAuthor(bookNodeToAdd.getBookAuthor());
			if(tempAuthorNode == null){
				tempAuthorNode = new AuthorNode(bookNodeToAdd.getBookAuthor());
				this.authorNodeList.add(tempAuthorNode);
				Collections.sort(this.authorNodeList, new AuthorNodeComparator());
			}
			tempAuthorNode.addBookNode(bookNodeToAdd);
		}
	}

	public BookNode searchByTitle(String bookTitle) {
		return this.hashTitle.get(bookTitle);
	}

	public List<BookNode> searchByGenre(String genre) {
		List<BookNode> tempBookNodeList = new ArrayList<BookNode>();
		for (BookNode bookNode : this.bookNodeList) {
			if (bookNode.getGenreList().indexOf(genre) >= 0) {
				tempBookNodeList.add(bookNode);
			}
		}
		Collections.sort(tempBookNodeList, new BookNodeComparator());
		return tempBookNodeList;
	}
	
	public List<String> getAllGenres() {
		List<String> tempGenreList = new ArrayList<String>();
		for (BookNode bookNode : this.bookNodeList) {
			for (String genre : bookNode.getGenreList()) {
				tempGenreList.add(genre);
			}
		}
		Set<String> hs = new HashSet<String>();
		hs.addAll(tempGenreList);
		tempGenreList.clear();
		tempGenreList.addAll(hs);
		Collections.sort(tempGenreList);
		return tempGenreList;
	}

	public AuthorNode searchForAuthor(String authorName) {
		int indexOfTempAuthor = Collections.binarySearch(this.authorNodeList, new AuthorNode(authorName), new AuthorNodeComparator());
		if(indexOfTempAuthor >= 0){
			return this.authorNodeList.get(indexOfTempAuthor);
		}
		return null;
		
	}
	
	public List<BookNode> getRelatedBooks(BookNode bookNode) {
		if (bookNode != null) {
			Collections.sort(bookNode.getSimilarBookNodes(), new BookNodeComparator());
			return bookNode.getSimilarBookNodes();
		}
		return new ArrayList<BookNode>();
	}
	
	public void setBookNodeList(List<BookNode> bookNodeList) {
		this.bookNodeList = bookNodeList;
	}

	public List<BookNode> getBookNodeList() {
		Collections.sort(this.bookNodeList, new BookNodeComparator());
		return this.bookNodeList;
	}
	
	public void setAuthorNodeList(List<AuthorNode> authorNodeList) {
		this.authorNodeList = authorNodeList;
	}
	
	public List<AuthorNode> getAuthorNodeList() {
		return this.authorNodeList;
	}

	public void loadBooksFromFile() {
		String jsonText = "";
		Path file = Paths.get("text/Books.json");
		try {
			jsonText = new String(Files.readAllBytes(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Gson gson = new Gson();
			List<BookNode> bookList = new ArrayList<BookNode>(Arrays.asList(gson.fromJson(jsonText, BookNode[].class)));
			for (BookNode bookNode : bookList) {
				bookNode.setSimilarBookNodes(new ArrayList<BookNode>());
				addBookNodeToGraph(bookNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


