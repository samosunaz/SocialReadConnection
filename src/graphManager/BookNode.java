/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * BookNode.java
 * May 8, 2016
 * Version 2.0
 */

package graphManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookNode {
	
	private String bookTitle;
	private String bookAuthor;
	private List<String> genreList;
	private List<BookNode> similarBookNodes;
	
	public BookNode(String bookTitle, String bookAuthor) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.genreList = new ArrayList<String>();
		this.similarBookNodes = new ArrayList<BookNode>();
	}
	
	public BookNode(String bookTitle, String bookAuthor, List<String> genreList) {
		this(bookTitle, bookAuthor);
		this.genreList = genreList;
	}
	
	public BookNode(String bookTitle, String bookAuthor, String genreStr){
		this(bookTitle, bookAuthor);
		this.genreList = Arrays.asList(genreStr.split("\\s*,\\s*"));
	}
	
	/**
	 * This method adds a related Book based of the genres it has
	 * if the book has 3 or more similar genres, then it is a related book.
	 * @param similarBookNode the book to check its genres
	 */
	public void addSimilarBookNodes(BookNode similarBookNode) {
		int genreCounter = 0;
		for (String genresSimilarBookNodes : similarBookNode.genreList) {
			for (String genresThisBookNode : this.genreList) {
				if (genresSimilarBookNodes.equals(genresThisBookNode)) {
					genreCounter++;
				}
			}
		}
		if (genreCounter >= 3) {
			this.similarBookNodes.add(similarBookNode);
			similarBookNode.getSimilarBookNodes().add(this);
		}
	}
	
	/**
	 * Sets the related books of a book
	 * @param similarBookNodes a list of the related books
	 */
	public void setSimilarBookNodes(List<BookNode> similarBookNodes) {
		this.similarBookNodes = similarBookNodes;
	}
	
	
	/**
	 * @return the related books of a specified book
	 */
	public List<BookNode> getSimilarBookNodes() {
		return this.similarBookNodes;
	}
	
	/**
	 * Sets the book title
	 * @param bookTitle the title of the book
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	/**
	 * 
	 * @return the title of the book
	 */
	public String getBookTitle() {
		return this.bookTitle;
	}
	
	/**
	 * Sets the author for the book
	 * @param bookAuthor the author of the book
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	/**
	 * 
	 * @return the author of the book
	 */
	public String getBookAuthor() {
		return this.bookAuthor;
	}
	
	/**
	 * Sets the genres for the book as a list
	 * @param genreList the genres to add
	 */
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	
	/**
	 * 
	 * @return the genres of the book
	 */
	public List<String> getGenreList() {
		return this.genreList;
	}
	

	public String toString() {
		String infoString =  "[Book]: " + this.getBookTitle() + "\n" +
								"[Author]: " + this.getBookAuthor() + "\n" +
								"[Genres]: " + "\n";
		for (String genre : this.genreList) {
			infoString += " — " + genre + "\n";
		}
		return infoString;
	}
	
}
