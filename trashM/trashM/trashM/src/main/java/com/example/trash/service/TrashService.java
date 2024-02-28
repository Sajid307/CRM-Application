package com.example.trash.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.trash.AllEntity.CompanyEntity;
import com.example.trash.AllEntity.ContactEntity;
import com.example.trash.AllEntity.DocumentEntity;
import com.example.trash.client.CompanyClient;
import com.example.trash.client.ContactClient;
import com.example.trash.client.DocumentClient;
import com.example.trash.entity.TrashEntity;
import com.example.trash.repository.TrashRepository;

@Service
public class TrashService {

	@Autowired
	private TrashRepository trashRepository;

	@Autowired
	private ContactClient contactClient;

	@Autowired
	private CompanyClient companyClient;

	@Autowired
	private DocumentClient documentClient;

	public void moveRecordToTrash(String recordType, Long recordId, Long userId) {
		TrashEntity trash = new TrashEntity();
		trash.setrecordType(recordType);
		trash.setTimestamp(LocalDateTime.now());
		trash.setUserId(userId);

		// set the ID of the record that was deleted to the trash entity
		trash.setRecordId(recordId);

		trashRepository.save(trash);
	}

	public List<DocumentEntity> restoreData() {
		return documentClient.trashedData();
	}

	@Scheduled(fixedRate = 24 * 60 * 60 * 1000) // run every day
	public void deleteExpiredTrash() {
		LocalDateTime expirationDate = LocalDateTime.now().minusDays(1);
		List<TrashEntity> expiredTrash = trashRepository.findByTimestampBefore(expirationDate);
		trashRepository.deleteAll(expiredTrash);
	}

	public List<TrashEntity> getTrash() {

		return trashRepository.findAll();
	}

	public void restoreData(long id) {
		documentClient.retriveTrash((int) id);
	}

	public List<DocumentEntity> getDocumentData() {
		return documentClient.trashedData();
	}

	public void deleteById(Long id) {
		documentClient.deleteDoc(id);
	}

	/////// Contact Service Methods
	public List<ContactEntity> getContactData() {
		return contactClient.trashedDataFromContact();
	}

	public void restoreContactData(int id) {
		contactClient.retrieveTrashFromContact(id);
	}

	public List<ContactEntity> restoreContactData() {
		return contactClient.trashedDataFromContact();
	}

	public void deleteContactById(int id) {
		contactClient.deleteContact(id);
	}

	////////////////////////////////////////////////////////////////////////
	public List<CompanyEntity> getCompanyData() {
		return companyClient.trashedFromCompany();
	}

	public void restoreCompanyData(long id) {
		companyClient.retrieveTrashCompany((int) id);
	}

	public List<CompanyEntity> restoreCompanyData() {
		return companyClient.trashedFromCompany();
	}

	public void deleteCompanyById(long id) {
		companyClient.deleteCompany(id);
	}

}
