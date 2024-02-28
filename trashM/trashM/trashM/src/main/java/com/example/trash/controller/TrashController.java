package com.example.trash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.trash.AllEntity.CompanyEntity;
import com.example.trash.AllEntity.ContactEntity;
import com.example.trash.AllEntity.DocumentEntity;
import com.example.trash.service.TrashService;

@RestController
public class TrashController {

	@Autowired
	public TrashService trashService;

	@GetMapping("/home")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	//////////////////////////////////////////////////////////////////////
	// Contact Methods

	@GetMapping("/contactTrash")
	public ModelAndView getAllDeletedContacts() {
		List<ContactEntity> contactData = trashService.getContactData();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("conData", contactData);
		return mv;
	}

	@GetMapping("/restoreConData/{id}")
	public ModelAndView restoreContactData(@PathVariable int id) {
		trashService.restoreContactData(id);
		List<ContactEntity> contactData = trashService.restoreContactData();
		ModelAndView mv = new ModelAndView("redirect:/contactTrash");
		mv.addObject("conData", contactData);
		return mv;
	}

	@DeleteMapping("/deleteContact/{id}")
	public void deleteContactExp(@PathVariable int id) {
		trashService.deleteExpiredTrash();
	}

	@GetMapping("/deleteCon/{id}")
	public ModelAndView deleteContact(@PathVariable int id) {
		trashService.deleteContactById(id);
		List<ContactEntity> contactData = trashService.getContactData();
		ModelAndView mv = new ModelAndView("redirect:/contactTrash");
		mv.addObject("conData", contactData);
		return mv;
	}

	/////////////////////////////////////////////////////////////////////////////
	// Company methods
	
	@GetMapping("/companyTrash")
	public ModelAndView getAllDelCompany() {
		List<CompanyEntity> companyData = trashService.getCompanyData();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("comData", companyData);
		return mv;
	}
	
	@GetMapping("/restoreComData/{id}")
	public ModelAndView restoreCompanyData(@PathVariable long id) {
		trashService.restoreCompanyData(id);
		List<CompanyEntity> companyData = trashService.restoreCompanyData();
		ModelAndView mv = new ModelAndView("redirect:/companyTrash");
		mv.addObject("comData", companyData);
		return mv;
	}
	
	@DeleteMapping("/deleteCompany/{id}")
	public void deleteCompanyExp(@PathVariable long id) {
		trashService.deleteExpiredTrash();
	}
	
	@GetMapping("/deleteCom/{id}")
	public ModelAndView deleteCompany(@PathVariable long id) {
		trashService.deleteCompanyById(id);
		List<CompanyEntity> companyData = trashService.getCompanyData();
		ModelAndView mv = new ModelAndView("redirect:/companyTrash");
		mv.addObject("comData", companyData);
		return mv;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Document methods

	// to get the list of document trash in index page
	@GetMapping("/DocumentTrash")
	public ModelAndView getAllDeletedDocs() {
		List<DocumentEntity> docData = trashService.getDocumentData();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("docData", docData);
		return mv;
	}

	@GetMapping("/restore/{id}")
	public ModelAndView restoreData(@PathVariable long id) {
		trashService.restoreData(id);
		List<DocumentEntity> docData = trashService.restoreData();
		ModelAndView mv = new ModelAndView("redirect:/DocumentTrash");
		mv.addObject("docData", docData);
		return mv;
	}

	@DeleteMapping("/deletedocument/{id}")
	public void deleteDocument(@PathVariable long id) {
		trashService.deleteExpiredTrash();
	}

	// delete a document on click delete
	@GetMapping("/deletedoc/{id}")
	public ModelAndView deleteDoc(@PathVariable long id) {
		trashService.deleteById(id);
		List<DocumentEntity> docData = trashService.getDocumentData();
		ModelAndView mv = new ModelAndView("redirect:/DocumentTrash");
		mv.addObject("docData", docData);
		return mv;
	}

	/////////////////////////////////////////////////////////////////////

}
