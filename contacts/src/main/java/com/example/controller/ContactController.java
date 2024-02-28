package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Contact;
import com.example.service.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	// To get the homepage
	@GetMapping("/home")
	public ModelAndView Home() {
		return new ModelAndView("index");
	}

	@GetMapping("/contactHome")
	public ModelAndView contactsHome() {
		List<Contact> data = contactServiceImpl.getAllContact();
		ModelAndView mv = new ModelAndView("index");
		System.out.println("in controller");
		mv.addObject("data", data);
		return mv;
	}

	@GetMapping("/addContactForm")
	public ModelAndView addContactForm() {
		return new ModelAndView("newContactForm");
	}

	@PostMapping("/addContact")
	public ModelAndView addContact(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String company, @RequestParam String address, @RequestParam String tags,
			@RequestParam String email) {
		System.out.println("controller 1st line");
		List<Contact> entireData = contactServiceImpl.CreateContact(firstName, lastName, company, address, tags, email);
		ModelAndView mv = new ModelAndView("redirect:/contactHome");
		mv.addObject("data", entireData);
		return mv;
	}

	// Update//////////////////////////////////////////////////
	@GetMapping("/updateContactForm/{id}")
    public ModelAndView updateContactForm(@PathVariable("id") int id) {
        Contact contact = contactServiceImpl.getContactById(id);
        ModelAndView mv = new ModelAndView("updateContactForm");
        mv.addObject("contact", contact);
        return mv;
    }

    @PostMapping("/updateContact/{id}")
    public ModelAndView updateContact(@PathVariable("id") int id, @ModelAttribute Contact updatedContact) {
        Contact contact = contactServiceImpl.getContactById(id);
        contact.setCompany(updatedContact.getCompany());
        contact.setAddress(updatedContact.getAddress());
        contact.setTags(updatedContact.getTags());
        contact.setEmail(updatedContact.getEmail());
        contactServiceImpl.saveContact(contact);
        return new ModelAndView("redirect:/contactHome");
    }
	////////////////////////////////////////////////////////////
    //on delete to view the contact data
    
    @GetMapping("/changeTrash/{id}")    
	public ModelAndView changeTrash(@PathVariable int id) {
		System.out.println("transfer trash to trash module");
		contactServiceImpl.changetrash(id);
		List<Contact> contact = contactServiceImpl.getAllContact();
		ModelAndView mv = new ModelAndView("redirect:/contactHome");
		mv.addObject("data", contact);
		return mv;
	}
    
    ////////////////////////////////////////////////////////////
    //from contact client
    //////////////////////
    
    //It will move the deleted data from contact to trash
    @GetMapping("/contactTrash")
	public List<Contact> trashedDataFromContact() {
    	return contactServiceImpl.trashedData();
    }
    
    //it will get the restored data from trash to contact
    @GetMapping("retrieveTrashContact/{id}")
	public void retrieveTrashFromContact(@PathVariable int id) {
		System.out.println("get data from trash module");
		contactServiceImpl.retrieveTrash(id);
	}
    
    //Change the trash column to 0
    @DeleteMapping("/contact/{id}")
	public void deleteContact(@PathVariable int id) {
    	contactServiceImpl.deleteContactById(id);
    }
    ////////////////////////////////////////////////////////////////
}