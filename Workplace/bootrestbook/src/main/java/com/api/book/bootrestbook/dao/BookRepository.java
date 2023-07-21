package com.api.book.bootrestbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.book.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);
	
	@Query(value = "select * from api_book_db.books", nativeQuery=true)
	public List<Book> getBookNative();
	
	@Query(value = "select * from api_book_db.books where book_id =:id", nativeQuery=true)
	public Book getBookNativebyId(@Param("id") int id);
}
