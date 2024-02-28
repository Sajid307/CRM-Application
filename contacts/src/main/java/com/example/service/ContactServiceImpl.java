package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;
@Service
public class ContactServiceImpl {

	@Autowired
	private ContactRepository contactRepository;
	
	Contact contactData = new Contact();

	public List<Contact> getAllContact() {
		List<Contact> presentData = contactRepository.findAll();
		List<Contact> updated = new ArrayList<>();
		
		for(Contact i : presentData) {
			if(i.getcTrash()==0) {
				updated.add(i);
			}
		}
		return updated;
	}
	
	public List<Contact> CreateContact( String firstName,String lastName,String company,String address,String tags, String email) {
		Optional<Contact> optionalTagData = contactRepository.findByFirstName(firstName);
		if(optionalTagData.isPresent()) {
			System.out.println("contact is available");
		}
		else {
			Contact contactData = new Contact();
			//contactData.setId();
			contactData.setFirstName(firstName);
			contactData.setLastName(lastName);
			contactData.setCompany(company);
			contactData.setAddress(address);
			contactData.setTags(tags);
			contactData.setEmail(email);
			
			contactRepository.save(contactData);
		}
		return contactRepository.findAll();
	}
	
	//THIS IS FROM C
	public Contact getContactById(int id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID: " + id));
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

	//IN BETWEEN

	public Contact getById(int id) {
		Optional<Contact> optional = contactRepository.findById(id);
		Contact contact = null;
		if (optional.isPresent()) {
			contact = optional.get();
		} else {
			throw new RuntimeException(" Contact not found for id :: " + id);
		}
		return contact;
	}

	
	
	public List<Contact> saveOrUpdate(int id, String email, String company, String address, String tags){
		Optional<Contact> optionalContact = contactRepository.findById(id);
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			contact.setEmail(email);
			contact.setCompany(company);
			contact.setAddress(address);
			contact.setTags(tags);
			contactRepository.save(contact);
		}
		return contactRepository.findAll();
	}
	
	public void changetrash(int id) {
		List<Contact> data = contactRepository.findAll();
		for(Contact i : data) {
			
			if(i.getId()==(long)id) {
				i.setcTrash((int)1);
				contactRepository.save(i);
			}
		}
	}

	public void retrieveTrash(int id) {
		List<Contact> data = contactRepository.findAll();
		for(Contact i : data) {
			
			if(i.getId()==(long)id) {
				i.setcTrash((int)0);
				contactRepository.save(i);
			}
		}
		
	}

	public List<Contact> trashedData() {
		List<Contact> data = contactRepository.findAll();
		List<Contact> trasheddata = new ArrayList<>();
		for (Contact i : data) {
			if(i.getcTrash()==1)
				trasheddata.add(i);
		}
		return trasheddata;
	}
	
	public void deleteContactById(int id) {
		this.contactRepository.deleteById(id);
	}
}