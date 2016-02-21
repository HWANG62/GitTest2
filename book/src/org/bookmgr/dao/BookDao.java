package org.bookmgr.dao;

import java.util.ArrayList;
import java.util.List;

import org.bookmgr.entity.Book;

public class BookDao extends BaseDao implements IBookDao {

	public List<Book> getBookList() {
		List<Book> list=new ArrayList<Book>();
		String sql="select ID,Name,Author,PubilshDate from Book";
		try {
			this.getConnection();
			pstm=con.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Book book=new Book();
				book.setId(rs.getInt("Id"));
				book.setName(rs.getString("Name"));
				book.setAuthor(rs.getString("Author"));
				book.setPublishDate(rs.getDate("PubilshDate"));
				list.add(book);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, con);
		}
		return null;
	}

	public Book getBookById(String id) {
		String sql="select ID,Name,Author,PubilshDate,Price,publisher from Book where id=?";
		try {
			this.getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1, id);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Book book=new Book();
				book.setId(rs.getInt("Id"));
				book.setName(rs.getString("Name"));
				book.setAuthor(rs.getString("Author"));
				book.setPublishDate(rs.getDate("PubilshDate"));
				book.setPrice(rs.getDouble("Price"));
				book.setPublisher(rs.getString("publisher"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, con);
		}
		
		return null;
	}
	
	
}
