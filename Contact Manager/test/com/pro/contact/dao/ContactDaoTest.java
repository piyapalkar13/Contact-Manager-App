package com.pro.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.pro.contact.model.Contact;

class ContactDaoTest {

	private DriverManagerDataSource dmds;

	private ContactDao dao;

	@BeforeEach
	void setUpBeforeEach() {
		dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/contactDb");
		dmds.setUsername("root");
		dmds.setPassword("root");

		dao = new ContactDaoImp(dmds);
	}

	@Test
	public void testSave() {
		Contact c = new Contact("Anuja", "anuja@gmail.com", "mumbai", "9685417523");
		int result = dao.save(c);
		assertTrue(result > 0);
	}

	@Test
	public void testUpdate() {

		Contact c = new Contact(18,"Anuja", "anuja@gmail.com", "pune", "9685417523");
		int result = dao.update(c);
		assertTrue(result > 0);

	}

	@Test
	public void testGet() {

		Integer id = 1;
		Contact contact = dao.get(id);
		if (contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);

	}

	@Test
	public void testDelete() {

		Integer id = 10;
		int result = dao.delete(id);
		assertTrue(result>0);
	}

	@Test
	public void testList() {
		
		
		List<Contact> listContacts=dao.list();
		assertTrue(!listContacts.isEmpty());
	}

}
