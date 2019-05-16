package com.gz.manager.dao;

import com.gz.manager.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository public class UserDao {

	@Autowired private JdbcTemplate jdbcTemplate;

	@Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean addUser(Book book) {
		String sql = "insert into spring (title, author, create_time) values(?, ?, now())";

		Object[] args = { "springboot", "hooking" };

		int result = jdbcTemplate.update(sql, args);

		System.out.println("result = " + result);

		return true;
	}

	public Book query(String title) {
		String sql = "select * from spring where title = ?";
		List<Object> args = new ArrayList<Object>();
		args.add(title);
		RowMapper<Book> rowMapper = new RowMapper<Book>() {
			@Override public Book mapRow(ResultSet resultSet, int i) throws SQLException {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				/*book.setCreateTime(resultSet.getTimestamp("create_time"));*/
				return book;
			}
		};

		return jdbcTemplate.queryForObject(sql, args.toArray(), rowMapper);
	}
}
