package com.pro.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.contact.dao.ContactDao;
import com.pro.contact.model.Contact;

@Controller
public class ContactController {

	@Autowired
	private ContactDao cDao;

	@RequestMapping("/")
	public ModelAndView listContact(ModelAndView model)
	{
		List<Contact> listcontact=cDao.list();
		model.addObject("listcontacts",listcontact);
		model.setViewName("index");
		return model;

	}

	/*
	 * @RequestMapping("/") public String home() { return "index"; }
	 */
}
