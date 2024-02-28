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

import com.example.model.Company;
import com.example.service.CompaniesServiceImpl;

@RestController
public class CompaniesController {

	@Autowired
	private CompaniesServiceImpl companyService;

	@GetMapping("/home")
	public ModelAndView viewHomePage() {
		List<Company> data = companyService.getAllCompanies();
		System.out.println("data");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("data", data);
		return mv;
	}

	@GetMapping("/companiesForm")
	public ModelAndView companiesForm() {
		return new ModelAndView("new_company");
	}

	@PostMapping("/saveCompany")
	public ModelAndView saveCompany(@RequestParam String name, @RequestParam String website, @RequestParam String email,
			@RequestParam String address, @RequestParam String tags) {
		List<Company> entireData = companyService.createCompany(name, website, email, address, tags);
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("data", entireData);
		return mv;
	}

	@GetMapping("/showFormForUpdate/{id}")
	public ModelAndView showFormUpdate(@PathVariable("id") long id) {
		Company company = companyService.getCompanyById(id);
		ModelAndView mv = new ModelAndView("updateCompany");
		mv.addObject("company", company);
		return mv;
	}

	@PostMapping("/updateCompany/{id}")
	public ModelAndView updateCompany(@PathVariable("id") long id, @ModelAttribute Company updatedCompany) {
		Company company = companyService.getCompanyById(id);
		company.setAddress(updatedCompany.getAddress());
		company.setEmail(updatedCompany.getEmail());
		company.setWebsite(updatedCompany.getWebsite());
		company.setTags(updatedCompany.getTags());
		companyService.saveCompany(company);
		return new ModelAndView("redirect:/home");
	}

	// On Delete the company data change to trash///////////////////////////////
	@GetMapping("/changeTrash/{id}")
	public ModelAndView changeTrash(@PathVariable long id) {
		companyService.changeTrash(id);
		List<Company> company = companyService.getAllCompanies();
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("data", company);
		return mv;
	}

	////////////////////////////////////////////////////////////////////////////

	// it will move the deleted data from company to trash
	@GetMapping("/companyTrash")
	public List<Company> trashedFromCompany() {
		return companyService.trashedData();
	}
	
	//it will get the restored data from trash to company
	@GetMapping("retrieveTrashCompany/{id}")
	public void retrieveTrashCompany(@PathVariable int id) {
		companyService.retrieveTrash(id);
	}
	
	//Change the trash column to 0
	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyService.deleteCompanyById(id);
	}
//  
//  @DeleteMapping("/contact/{id}")
//	public void deleteContact(@PathVariable int id) {
//  	contactServiceImpl.deleteContactById(id);
//  }

}
