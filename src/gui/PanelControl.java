/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * PanelControl.java
 * May 8, 2016
 * Version 2.0
 */

package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import graphManager.AuthorNode;
import graphManager.BookNode;
import graphManager.BookNodeComparator;
import graphManager.Graph;

public class PanelControl extends JPanel implements ActionListener, ListSelectionListener, FocusListener {
	
	private Graph theGraph;
	private BookNode actualBookNode;
	
	private boolean functionSearchByTitle;
	private boolean functionSearchByAuthor;
	private boolean functionSearchByGenre;
	
	private JPanel jPanelInput;
	private JPanel jPanelOutput;
	private JPanel jPanelSelector;
	
	private JButton jButtonAddBook;
	private JButton jButtonSearchByTitle;
	private JButton jButtonSearchByAuthor;
	private JButton jButtonSearchByGenre;
	private JButton jButtonClear;
	
	private JLabel jLabelTitle;
	private JLabel jLabelAuthor;
	private JLabel jLabelGenre;
	private JLabel jLabelConsole;
	private JLabel jLabelSelectorInfo;
	
	private JList<String> jListSelector;
	
	private JTextArea jTextAreaInfo;
	private JTextArea jTextAreaConsole;
	
	private JTextField jTextFieldTitle;
	private JTextField jTextFieldAuthor;
	private JTextField jTextFieldGenre;
	
	private JScrollPane jScrollInfo;
	private JScrollPane jScrollConsole;	
	private JScrollPane jScrollSelector;
	
	private DefaultListModel<String> dlModelSelector;
	
	
	public PanelControl() {
		this.theGraph = new Graph();
		this.actualBookNode = null;
		this.functionSearchByAuthor = false;
		this.functionSearchByTitle = false;
		this.functionSearchByGenre = false;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		addComponentsToPanel();
		setBoundsToComponents();
		setComponentCharacteristics();
		addActionsToComponents();
	}
	
	/**
	 * Adds the components to the panel
	 */
	private void addComponentsToPanel() {
		this.jPanelInput = new JPanel();
		this.jPanelOutput = new JPanel();
		this.jPanelSelector = new JPanel();
		this.jButtonAddBook = new JButton("Add Book");
		this.jButtonSearchByTitle = new JButton("Search By Title");
		this.jButtonSearchByAuthor = new JButton("Search By Author");
		this.jButtonSearchByGenre = new JButton("Search By Genre");
		this.jButtonClear = new JButton("Clear");
		this.jLabelTitle = new JLabel("Title:");
		this.jLabelAuthor = new JLabel("Author:");
		this.jLabelGenre = new JLabel("Genres:");
		this.jLabelConsole = new JLabel("Console");
		this.jLabelSelectorInfo = new JLabel("Info:");
		this.jListSelector = new JList<String>();
		this.jTextAreaInfo = new JTextArea();
		this.jTextAreaConsole = new JTextArea();
		this.jTextFieldTitle = new JTextField();
		this.jTextFieldAuthor = new JTextField();
		this.jTextFieldGenre = new JTextField("Genre1,Genre2,. . .,GenreN");
		this.jScrollInfo = new JScrollPane(this.jTextAreaInfo);
		this.jScrollConsole = new JScrollPane(this.jTextAreaConsole);
		this.jScrollSelector = new JScrollPane(this.jListSelector);
		this.add(jPanelInput);
		this.add(jPanelOutput);
		this.add(jPanelSelector);
		this.jPanelInput.add(this.jButtonAddBook);
		this.jPanelInput.add(this.jButtonSearchByTitle);
		this.jPanelInput.add(this.jButtonSearchByAuthor);
		this.jPanelInput.add(this.jButtonSearchByGenre);
		this.jPanelInput.add(this.jButtonClear);
		this.jPanelInput.add(this.jLabelTitle);
		this.jPanelInput.add(this.jLabelAuthor);
		this.jPanelInput.add(this.jLabelGenre);
		this.jPanelInput.add(this.jTextFieldTitle);
		this.jPanelInput.add(this.jTextFieldAuthor);
		this.jPanelInput.add(this.jTextFieldGenre);
		this.jPanelOutput.add(this.jLabelConsole);
		this.jPanelOutput.add(this.jScrollInfo);
		this.jPanelOutput.add(this.jScrollConsole);
		this.jPanelSelector.add(this.jLabelSelectorInfo);
		this.jPanelSelector.add(this.jScrollSelector);	
		this.dlModelSelector = new DefaultListModel<>();
	}
	
	/**
	 * Sets the position an measurements of the components
	 */
	private void setBoundsToComponents() {
		this.jPanelInput.setBounds(0, 0, this.getPreferredSize().width - 300, this.getPreferredSize().height - 400);
		this.jLabelTitle.setBounds(10, 20, this.jLabelTitle.getPreferredSize().width, 30);
		this.jTextFieldTitle.setBounds(this.jLabelTitle.getX() + this.jLabelTitle.getWidth(), this.jLabelTitle.getY(), this.jPanelInput.getWidth() - this.jLabelTitle.getWidth() - 20, 30);
		this.jLabelAuthor.setBounds(this.jLabelTitle.getX(), this.jLabelTitle.getY() + this.jLabelTitle.getHeight(), this.jLabelAuthor.getPreferredSize().width, 30);
		this.jTextFieldAuthor.setBounds(this.jLabelAuthor.getX() + this.jLabelAuthor.getWidth(), this.jLabelAuthor.getY(), this.jPanelInput.getWidth() - this.jLabelAuthor.getWidth() - 20, 30);
		this.jLabelGenre.setBounds(this.jLabelAuthor.getX(), this.jLabelAuthor.getY() + this.jLabelAuthor.getHeight(), this.jLabelGenre.getPreferredSize().width, 30);
		this.jTextFieldGenre.setBounds(this.jLabelGenre.getX() + this.jLabelGenre.getWidth(), this.jLabelGenre.getY(), this.jPanelInput.getWidth() - this.jLabelGenre.getWidth() - 20, 30);
		this.jButtonAddBook.setBounds(this.jPanelInput.getWidth() / 2 - this.jButtonAddBook.getPreferredSize().width / 2, this.jLabelGenre.getY() + this.jLabelGenre.getHeight(), this.jButtonAddBook.getPreferredSize().width, 30);
		this.jButtonSearchByTitle.setBounds(this.jLabelGenre.getX() + 35, this.jButtonAddBook.getY() + this.jButtonAddBook.getHeight(), this.jButtonSearchByTitle.getPreferredSize().width, 30);
		this.jButtonSearchByAuthor.setBounds(this.jButtonSearchByTitle.getX() + this.jButtonSearchByTitle.getWidth(), this.jButtonSearchByTitle.getY(), this.jButtonSearchByTitle.getPreferredSize().width, 30);
		this.jButtonSearchByGenre.setBounds(this.jButtonSearchByAuthor.getX() + this.jButtonSearchByAuthor.getWidth(), this.jButtonSearchByTitle.getY(), this.jButtonSearchByGenre.getPreferredSize().width, 30);
		this.jButtonClear.setBounds(415, this.jButtonSearchByTitle.getY() + this.jButtonSearchByTitle.getHeight(), this.jButtonClear.getPreferredSize().width, 30);
		
		this.jPanelOutput.setBounds(this.jPanelInput.getX(), this.jPanelInput.getY() + this.jPanelInput.getHeight(), this.jPanelInput.getWidth(), this.getPreferredSize().height - this.jPanelInput.getHeight());
		this.jScrollInfo.setBounds(this.jPanelOutput.getX() + 10, 20, this.jPanelOutput.getWidth() - 22, 300);
		this.jLabelConsole.setBounds(this.jScrollInfo.getX(), this.jScrollInfo.getY() + this.jScrollInfo.getHeight(), this.jLabelConsole.getPreferredSize().width, 30);
		this.jScrollConsole.setBounds(this.jLabelConsole.getX(), this.jLabelConsole.getY() + this.jLabelConsole.getHeight(), this.jScrollInfo.getWidth(), 40);
		
		this.jPanelSelector.setBounds(this.jPanelInput.getWidth(), this.jPanelInput.getY(), this.getPreferredSize().width - this.jPanelInput.getWidth(), this.getPreferredSize().height);
		this.jLabelSelectorInfo.setBounds(10, 20, this.jPanelSelector.getWidth() - 20, 30);
		this.jScrollSelector.setBounds(this.jLabelSelectorInfo.getX(), this.jLabelSelectorInfo.getY() + this.jLabelSelectorInfo.getHeight(), this.jPanelSelector.getWidth() - 20, 540);
	}
	
	/**
	 * Sets the components characteristics
	 */
	private void setComponentCharacteristics() {
		this.jPanelInput.setBorder(BorderFactory.createTitledBorder("Input"));
		this.jPanelOutput.setBorder(BorderFactory.createTitledBorder("Output"));
		this.jPanelSelector.setBorder(BorderFactory.createTitledBorder("Selector"));
		this.jPanelInput.setLayout(null);
		this.jPanelOutput.setLayout(null);
		this.jPanelSelector.setLayout(null);
		this.jTextAreaInfo.setEditable(false);
		this.jTextAreaConsole.setEditable(false);
	}

	/**
	 * Adds the listeners to the components
	 */
	private void addActionsToComponents() {
		this.jButtonAddBook.addActionListener(this);
		this.jButtonSearchByTitle.addActionListener(this);
		this.jButtonSearchByAuthor.addActionListener(this);
		this.jButtonSearchByGenre.addActionListener(this);
		this.jButtonClear.addActionListener(this);
		this.jListSelector.addListSelectionListener(this);
		this.jTextFieldGenre.addFocusListener(this);
	}
	
	/**
	 * Adds a BookNode to the graph
	 */
	private void addBookNodeToGraph() {
		this.jTextAreaInfo.setText("");
		this.jTextAreaConsole.setText("");
		BookNode bookNodeToAdd;
		if (!this.jTextFieldTitle.getText().equals("") && !this.jTextFieldAuthor.getText().equals("") && !this.jTextFieldGenre.getText().equals("")) {
			bookNodeToAdd = new BookNode(this.jTextFieldTitle.getText(), this.jTextFieldAuthor.getText(), this.jTextFieldGenre.getText());
			this.theGraph.addBookNodeToGraph(bookNodeToAdd);
			this.jTextAreaInfo.append(bookNodeToAdd.toString());
			this.jTextAreaConsole.append("The Book: [" + bookNodeToAdd.getBookTitle() + "]" + " has been added");
		}
		else {
			this.jTextAreaConsole.append("Invalid Inputs");
		}
	}
	
	/**
	 * Searchs a book based on its title
	 */
	private void searchByTitle() {
		this.functionSearchByTitle = true;
		this.jTextFieldAuthor.setText("");
		this.jTextFieldGenre.setText("");
		this.jTextAreaInfo.setText("");
		this.jTextAreaConsole.setText("");
		BookNode bookNodeToSearch;
		this.functionSearchByTitle = true;
		if (!this.jTextFieldTitle.getText().equals("")) {
			bookNodeToSearch = this.theGraph.searchByTitle(this.jTextFieldTitle.getText());
			this.jListSelector.setModel(this.dlModelSelector);
			this.jLabelSelectorInfo.setText("Related Books:");
			for (BookNode bookNode : this.theGraph.getRelatedBooks(bookNodeToSearch)) {
				this.dlModelSelector.addElement(bookNode.getBookTitle());
			}
			if (bookNodeToSearch != null) {
				this.jTextAreaInfo.append(this.theGraph.searchByTitle(this.jTextFieldTitle.getText()).toString());
				
			}
			else {
				this.jTextAreaConsole.append("Book Not Found");
			}
		}
		else {
			this.jLabelSelectorInfo.setText("Book List:");
			this.jListSelector.setModel(this.dlModelSelector);
			for (BookNode bookNode : this.theGraph.getBookNodeList()) {
				this.dlModelSelector.addElement(bookNode.getBookTitle());
			}
		}
	}
	
	/**
	 * Search a book based on its author
	 */
	private void searchByAuthor() {
		this.functionSearchByAuthor = true;
		this.jTextFieldTitle.setText("");
		this.jTextFieldGenre.setText("");
		this.jTextAreaConsole.setText("");
		this.jTextAreaInfo.setText("");
		AuthorNode authorNodeToSearch;
		if (!this.jTextFieldAuthor.getText().equals("")) {
			this.jListSelector.setModel(this.dlModelSelector);
			for (AuthorNode authorNode : this.theGraph.getAuthorNodeList()) {
				this.dlModelSelector.addElement(authorNode.getAuthorName());
			}
			authorNodeToSearch = this.theGraph.searchForAuthor(this.jTextFieldAuthor.getText());
			if (authorNodeToSearch != null) {
				for (BookNode bookNode : authorNodeToSearch.getBookNodeReference()) {
					this.jTextAreaInfo.append(bookNode + "\n");
				}
			}
			else {
				this.jTextAreaConsole.append("Author Not Found");
			}
		}
		else {
			this.jLabelSelectorInfo.setText("Author List:");
			this.jListSelector.setModel(this.dlModelSelector);
			for (AuthorNode authorNode : this.theGraph.getAuthorNodeList()) {
				this.dlModelSelector.addElement(authorNode.getAuthorName());
			}
		}
	}
	
	/**
	 * Search books based on its genre
	 */
	private void searchByGenre() {
		this.functionSearchByGenre = true;
		this.jLabelSelectorInfo.setText("Select a Genre:");
		this.jListSelector.setModel(this.dlModelSelector);
		for (String genre : this.theGraph.getAllGenres()) {
			this.dlModelSelector.addElement(genre);
		}
	}
	
	/**
	 * Clears the TextFields, TextsAreas and Lists.
	 */
	private void clearComponents() {
		this.jTextFieldTitle.setText("");
		this.jTextFieldAuthor.setText("");
		this.jTextFieldGenre.setText("");
		this.jTextAreaInfo.setText("");
		this.jTextAreaConsole.setText("");
		this.jLabelSelectorInfo.setText("Info:");
	}
	
	
	@Override
	
	/**
	 * Depending on the Button pressed, it is the function called
	 */
	public void actionPerformed(ActionEvent e) {
		this.functionSearchByTitle = false;
		this.functionSearchByAuthor = false;
		this.functionSearchByGenre = false;
		this.dlModelSelector.clear();
		this.jListSelector.removeAll();
		this.jLabelSelectorInfo.setText("Info:");
		
		if (e.getSource().equals(this.jButtonAddBook)) {
			addBookNodeToGraph();
		}
		else if (e.getSource().equals(this.jButtonSearchByTitle)) {
			searchByTitle();
		}
		else if (e.getSource().equals(this.jButtonSearchByAuthor)) {
			searchByAuthor();
		}
		else if (e.getSource().equals(this.jButtonSearchByGenre)) {
			searchByGenre();
		}
		else if (e.getSource().equals(this.jButtonClear)) {
			clearComponents();
		}
	}

	@Override
	/**
	 * Adds to the JList the items depending on the function selected
	 * The function selected is depending of the boolean
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object selectedValue = this.jListSelector.getSelectedValue();
		if (!e.getValueIsAdjusting() && selectedValue != null) {
			this.jTextAreaInfo.setText("");
			if (this.functionSearchByTitle) {
				this.actualBookNode = theGraph.searchByTitle((String) selectedValue);
				this.jTextAreaInfo.append(this.actualBookNode.toString());
				this.dlModelSelector.clear();
				this.jListSelector.removeAll();
				for (BookNode bookNode : this.theGraph.getRelatedBooks(this.actualBookNode)) {
					this.dlModelSelector.addElement(bookNode.getBookTitle());
				}				
			}
			else if (this.functionSearchByAuthor) {
				this.jLabelSelectorInfo.setText("Select an Author:");
				List<BookNode> tempBookNodeList = this.theGraph.searchForAuthor((String) selectedValue).getBookNodeReference();
				for (BookNode bookNode : tempBookNodeList) {
					this.jTextAreaInfo.append(bookNode.toString() + "\n–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n\n");
				}
			}
			else if (this.functionSearchByGenre) {
				this.jLabelSelectorInfo.setText("Select a Genre:");
				List<BookNode> tempBookNodeList = this.theGraph.searchByGenre((String) selectedValue);
				for (BookNode bookNode : tempBookNodeList) {
					this.jTextAreaInfo.append(bookNode.toString() + "\n–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n\n");
				}
			}
		}
	}

	/**
	 * Clears the JTextField of genres if it is selected
	 */
	@Override
	public void focusGained(FocusEvent e) {
		if (this.jTextFieldGenre.getText().trim().equals("Genre1,Genre2,. . .,GenreN")) {
			this.jTextFieldGenre.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.jTextFieldGenre.getText().trim().equals("")) {
			this.jTextFieldGenre.setText("Genre1,Genre2,. . .,GenreN");
		}
	}	
}
