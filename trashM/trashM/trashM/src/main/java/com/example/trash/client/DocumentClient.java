package com.example.trash.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.trash.AllEntity.DocumentEntity;

@FeignClient("document")
public interface DocumentClient {
	
	@GetMapping("/retriveTrash/{id}")
	public void retriveTrash(@PathVariable int id);
	
	@GetMapping("/documentTrash")
	public List<DocumentEntity> trashedData();
	
	@DeleteMapping("/document/{id}") 
	public void deleteDoc(@PathVariable long id);

}
