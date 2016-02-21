package org.bookmgr.dao;

import java.util.List;

import org.bookmgr.entity.Book;

public interface IBookDao {
	
	List<Book> getBookList();
	
	Book getBookById(String id);
}
