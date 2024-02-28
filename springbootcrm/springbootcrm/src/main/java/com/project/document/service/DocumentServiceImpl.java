package com.project.document.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.document.model.Document;
import com.project.document.repository.DocumentRepository;

@Service
public class DocumentServiceImpl {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	public Document CreateDocument(Document document) {
		return documentRepository.save(document);
	}

	
	public List<Document> getAllDocuments() {
		 List<Document> presentData = documentRepository.findAll();
		 List<Document> updated = new ArrayList<>();
		 
		 for(Document i : presentData) {
			 if(i.getTrash()==0)
				 updated.add(i);
		 }
		 return updated;
	}
	
	public List<Document> saveOrUpdate(String documentName, long id) {
		List<Document> full = documentRepository.findAll();
		for (Document i : full) {
			if (i.getId() == id)
				i.setDocumentName(documentName);
			documentRepository.save(i);
		}

		System.out.println("in service, update method");
		return documentRepository.findAll();
	}

	
	public void changetrash(int id) {
		List<Document> data = documentRepository.findAll();
		for(Document i : data) {
			
			if(i.getId()==(long)id) {
				i.setTrash((int)1);
				documentRepository.save(i);
			}
		}
	}
	
	public void retriveTrash(int id) {
		List<Document> data = documentRepository.findAll();
		for(Document i : data) {
			
			if(i.getId()==(long)id) {
				i.setTrash((int)0);
				documentRepository.save(i);
			}
		}
	}

	
	public Document saveDocument(Document document) {
		 return documentRepository.save(document);		
	}
    
	
	public Document getDocumentById(long id) {
		Optional<Document> optional= documentRepository.findById(id);
		//return documentRepository.findById(id).orElse(null);
		Document document=null;
		if(optional.isPresent()) {
			document=optional.get();
		} else {
			throw new RuntimeException("Document not found with id: "+id);
		}
		return document;
	}
	
	
	public List<Document> getDocumentByName(String name) {
		//List<Document> docName= documentRepository.findByDocumentName(name);
		//return documentRepository.findById(id).orElse(null);
//		Document document=null;
//		if(optional.isPresent()) {
//			document=optional.get();
//		} else {
//			throw new RuntimeException("Document not found with name: "+name);
//		}
		return documentRepository.findAll();
	}


	public List<Document> trashedData() {
		List<Document> data = documentRepository.findAll();
		List<Document> trasheddata = new ArrayList<>();
		for (Document i : data) {
			if(i.getTrash()==1)
				trasheddata.add(i);
		}
		return trasheddata;
	}


	public void deleteDocumentById(long id) {
		documentRepository.deleteById(id);
	}
	
	
	//private Optional<Document> findByName(String name) {
		// TODO Auto-generated method stub
		//return null;
	//}


//	public String deleteDocumentById(String name) {
//		 return documentRepository.deleteByName(name);	
//		return "Document is deleted";
//	}

	

}