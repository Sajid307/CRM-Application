package com.example.trash.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.trash.AllEntity.ContactEntity;

@FeignClient("contact")
public interface ContactClient {
	
	@GetMapping("/retrieveTrashContact/{id}")
	public void retrieveTrashFromContact(@PathVariable int id);
	
	@GetMapping("/contactTrash")
	public List<ContactEntity> trashedDataFromContact();
	
	@DeleteMapping("/contact/{id}")
	public void deleteContact(@PathVariable int id);
}
