package com.pro.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.pro.contact.model.Contact;

public class ContactDaoImp implements ContactDao {

	private JdbcTemplate jt;

	public ContactDaoImp(DataSource dataSource) {

		this.jt = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact contact) {
		String sql = "insert into contact(name,email,address,phone) values(?,?,?,?)";
		return jt.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
	}

	@Override
	public int update(Contact contact) {

		String sql = "UPDATE contact SET name=?,email=?,address=?,phone=? where contact_id=?";

		return jt.update(sql, contact.getName(), contact.getAddress(), contact.getEmail(), contact.getPhone(),
				contact.getId());
	}

	@Override
	public Contact get(Integer id) {

		String sql = "select * from contact where contact_id=" + id;

		ResultSetExtractor<Contact> ex = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");

					return new Contact(name, email, address, phone);
				}

				return null;
			}

		};

		return jt.query(sql, ex);
	}

	@Override
	public int delete(Integer id) {

		String sql="delete from contact where contact_id="+id;
		return jt.update(sql);
	}

	@Override
	public List<Contact> list() {

		String sql="select * from contact";

		RowMapper<Contact> rowMapper=new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id=rs.getInt("contact_id");
				String name=rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");

				return new Contact(id, name, email, address, phone);
			}
		};

		return jt.query(sql, rowMapper);
	}

}
