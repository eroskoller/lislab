/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.component.inputtext.InputText;




/**
 *
 * @author eros
 */



@SessionScoped
@ManagedBean(name="collectorBean")
public class CollectorBean implements Serializable{
    
    
//    private String author;
//    private String title;
    private String msg;
    private Book book;
    
    private List<Book> books;
    
    private HtmlCommandButton btnSave;
    private InputText textAuthor;
    private HtmlInputText htmlInputText;
    
    private BookService bookService = new BookServiceImpl();

    public CollectorBean() {
        
         books = new ArrayList<Book>();
//         books.add(new Book("NamNamBuLu", "DaftPunk"));
        book = new Book();
    }
    
    
    public void createNew() {
		if(books.contains(book)) {
			FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
                    
            books.add(book);
            bookService.saveBook(book);
            book = new Book();          //reset form
        }
   }

    public HtmlInputText getHtmlInputText() {
        return htmlInputText;
    }

    public void setHtmlInputText(HtmlInputText htmlInputText) {
        this.htmlInputText = htmlInputText;
    }

    public InputText getTextAuthor() {
        return textAuthor;
    }

    public void setTextAuthor(InputText textAuthor) {
        this.textAuthor = textAuthor;
    }
    

    
    
    
    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    
    
    

//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

   
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
//    public void save(){
//        if(author != null &&
//                title != null){
//            if(books == null){
//                books = new ArrayList<Book>();}
//            
//            books.add(new Book(author, title));
//            
//            System.out.println("Adding e new Book.....");
//            System.out.println(btnSave.getStyle());
//            
//        }
//    }
    
    public void cleanUpList(){
        if(books != null &&
                books.size()> 0){
            books.clear();
        }else{
            books= new ArrayList<Book>();
        }
        
        System.out.println("Inside cleanUpList");
    }
    
    public void cleanUpEveryThing(){
        if(books != null){
            books.clear();
        }else{
            books = new ArrayList<Book>();
        }
    }
    
    public String reinit() {
        if(books != null){
            for(Book b : books){
                System.out.println(b.getAuthor());
            }
        }
        
		book = new Book();
//		book.setAuthor(author);
//                    book.setTitle(title);
//                books.add(book);
//                htmlInputText.setOnkeydown(msg);
		return null;
    }
    
    
    public void removeSingleItem(ActionEvent event){
        String author =  ((HtmlCommandLink)event.getComponent()).getTitle();
        System.out.println(author);
        books.remove(books.size()-1);
        
    }
    
    
    
    
    
    
}

    
