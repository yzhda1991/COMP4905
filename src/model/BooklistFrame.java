/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author byang1
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import main.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import viewer.BookListPanel;

public class BooklistFrame extends MenuFrame{
    
    BookListPanel           mainPanel;
    ActionListener          seachButtonListener;
    MouseListener           doubleClickedonbook;
    ListSelectionListener   listSelection;
    Connecter               theConnecter;
    Controller              theController;
    ArrayList<Book>         bookCollection;
    
    /** Creates new form BookListFrame */
    public BooklistFrame() {
        super("book list");
       
        theConnecter = new Connecter();
        initComponents();
        
    }
    
     public BooklistFrame(String title,Modeling view, Controller c,Connecter conn) {
        super(title,c);
        theConnecter = conn;
        theController = c;
        initComponents();
        
        
        
    }
   
    private void initComponents(){
        mainPanel = new BookListPanel();
       
        bookCollection = theConnecter.getBookList(); 

        seachButtonListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                searchBook();
            }
        };
        doubleClickedonbook = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    JList theList =(JList) e.getSource();
                    int index =  theList.locationToIndex(e.getPoint());
                    Book selectedBook = (Book)theList.getModel().getElementAt(index);
                    if(selectedBook!= null)doubleClickedBook(selectedBook);
                }
            }

            
            
        };
        listSelection       = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBook();
            }
        
    };
        
        super.updateMainPanel(mainPanel);
      
       this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        update();
    }
    
    private void selectedBook(){
        theController.setSelectedBook((Book)mainPanel.getBookList().getSelectedValue());
        super.setStatus("selected book:"+theController.getSelectedBook());
            update();
            
    }
    
    private void doubleClickedBook(Book b){
          super.setStatus("opening book" +b.getBookName());
                    if(theController !=null){
                        theController.setSelectedBook(b);
                        theController.openPageListFrame(b);
                    }
    }
    
    private void enableListener(){
        mainPanel.getSearchButton().addActionListener(seachButtonListener);
        mainPanel.getBookList().addMouseListener(doubleClickedonbook);
        mainPanel.getBookList().addListSelectionListener(listSelection);
    }
    
    private void disableListener(){
        mainPanel.getSearchButton().removeActionListener(seachButtonListener);
        mainPanel.getBookList().removeMouseListener(doubleClickedonbook);
        mainPanel.getBookList().removeListSelectionListener(listSelection);
    }
    
    private void searchBook(){
        
        super.setStatus("searching book :");
        String searchContent = mainPanel.getSearchField().getText().trim();
        String mode  = (String)mainPanel.getSelectedType().getSelectedItem();
        ArrayList<Book> searchBook = new ArrayList<Book>();
        
        if(searchContent.equals("*") ||searchContent.equals("%") ||searchContent.equals("") )
            searchBook = theConnecter.getBookList();
       
        else if(mode.equals(BookListPanel.searchType.BookCode.toString())){
             searchBook = theConnecter.searchBook(searchContent, "code");
        }
       
        else if(mode.equals(BookListPanel.searchType.BookTitle.toString())){
            searchBook =theConnecter.searchBook(searchContent, "title");
        }
       
        else if(mode.equals(BookListPanel.searchType.BookAuthor.toString())){
             searchBook =theConnecter.searchBook(searchContent, "author");
        }
        
        bookCollection = searchBook;
        
        update();
    }
    
    private void updateList(){
        Book bookArray[] = new Book[1];
        if(bookCollection !=null && !bookCollection.isEmpty())
        mainPanel.getBookList().setListData((Book [])bookCollection.toArray(bookArray)); 
        if(bookCollection ==null || bookCollection.isEmpty())
            mainPanel.getBookList().setVisible(false);
    }
    
    @Override
    public void update(){
        disableListener();
        updateList();
        enableListener();
        super.update();
    }
            
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooklistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BooklistFrame().setVisible(true);
            }
        });
    }
}
