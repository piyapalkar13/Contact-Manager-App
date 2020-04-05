package com.pro.contact.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pro.contact.model.Contact;

public class ContactDaoImp implements ContactDao{

	private JdbcTemplate jt;
	
	
	public ContactDaoImp(DataSource dataSource) {
		
		this.jt = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact contact) {
		String sql="insert into contact(name,email,address,phone) values(?,?,?,?)";
		return jt.update(contact.getName(),contact.getEmail(),contact.getAddress(),contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
