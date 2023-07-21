package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	//private static List<Book> list = new ArrayList<>();
	
//	static{
//		list.add( new Book(13,"How to?","Sohini Babu"));
//		list.add( new Book(15,"How to do?","Shivanshu"));
//		list.add( new Book(19,"How to make love?","Raghav Agrawal"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//get all books
//	public List<Book> getAllBooks(){
//		List<Book> list = (List<Book>) this.bookRepository.findAll();
//		return list;
//	}
	
	
	//get all books native query method
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) this.bookRepository.getBookNative();
		return list;
	}
	

	
//	//get single book by id
//	public Book getBookById(int id) {
//		Book book = null;
//		try {
//			//book = list.stream().filter(e->e.getId()==id).findFirst().get();
//			book = this.bookRepository.findById(id);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return book;
//	}
	
	//get single book by id native query
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.getBookNativebyId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) {
		//list.add(book);
		Book result = this.bookRepository.save(book);
		return result;
	}

	public void deleteBook(int bookId) {
//		list = list.stream().filter(book -> {
//			if(book.getId()!=bookId) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		this.bookRepository.deleteById(bookId);
	}

	public void updateBook(Book book, int bookId) {
//		list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		} ).collect(Collectors.toList());
		
		book.setId(bookId);
		this.bookRepository.save(book);
	}
}
