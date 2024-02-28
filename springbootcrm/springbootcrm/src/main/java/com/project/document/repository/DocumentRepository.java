
package com.project.document.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.document.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document>findByDocumentName(String name);
	//List<Document>DeleteByName(Stirng name);
	

}


