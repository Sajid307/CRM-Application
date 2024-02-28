package com.project.document.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.document.model.Document;
import com.project.document.service.DocumentServiceImpl;

@RestController
public class DocumentController {

	@Autowired
	private DocumentServiceImpl documentService;

	@GetMapping("/showHomepage")
	public ModelAndView showHomepage() {
		List<Document> document = documentService.getAllDocuments();
		System.out.println("Homepage in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("data", document);
		return mv;
	}

	@GetMapping("/updatepage/{id}")
	public ModelAndView UpdateForm(@PathVariable long id) {
		System.out.println("update form page in controller");
		ModelAndView mv = new ModelAndView("updatepage");
		mv.addObject("id", id);
		return mv;
	}

	@PostMapping("/saveDocument")
	public ModelAndView update(@RequestParam String documentName, @RequestParam long id) {
		System.out.println("put method in controller");
		List<Document> data = documentService.saveOrUpdate(documentName, id);
		ModelAndView mv = new ModelAndView("redirect:/showHomepage");
		mv.addObject("data", data);
		return mv;
	}
	
	@GetMapping("/changeTrash/{id}")
	public ModelAndView changeTrash(@PathVariable int id) {
		System.out.println("transfer trash to trash module");
		documentService.changetrash(id);
		List<Document> document = documentService.getAllDocuments();
		ModelAndView mv = new ModelAndView("redirect:/showHomepage");
		mv.addObject("data", document);
		return mv;
	}

	////////////////////////////////////////////////////////////////////////////////////
	//below 3 are for delete and they are mapped to trash.client(DocumentClient) package
	@GetMapping("/documentTrash")
	public List<Document> trashedData() {
		return documentService.trashedData();
	}

	@GetMapping("/retriveTrash/{id}")
	public void retriveTrash(@PathVariable int id) {
		System.out.println("get data from trash module");
		documentService.retriveTrash(id);
	}

	@DeleteMapping("/document/{id}")
	public void deleteDoc(@PathVariable long id) {
		documentService.deleteDocumentById(id);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	

	@PutMapping("/saveDoc")
	private Document saveDocument(@RequestBody Document document) {
		return documentService.saveDocument(document);
	}

	@GetMapping("/showdeleteForm")
	public ModelAndView showNewdeleteForm() {
		List<Document> document = documentService.getDocumentByName(null);
		System.out.println("hello");
		ModelAndView mv = new ModelAndView("deletepage");
		mv.addObject("data", document);
		return mv;
	}

}
