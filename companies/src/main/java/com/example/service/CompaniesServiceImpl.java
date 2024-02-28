package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.repository.CompaniesRepository;

@Service
public class CompaniesServiceImpl {

	@Autowired
	private CompaniesRepository companiesRepository;

	Company companyData = new Company();

	public List<Company> getAllCompanies() {
		List<Company> presentData = companiesRepository.findAll();
		List<Company> updated = new ArrayList<>();
		for(Company i : presentData) {
			if(i.getCompanyTrash()==0) {
				updated.add(i);
			}
		}
		return updated;
		
	}

	public List<Company> createCompany(String name, String website, String email, String address, String tags) {
		Optional<Company> optionatCompanyData = companiesRepository.findByName(name);
		if (optionatCompanyData.isPresent()) {
			System.out.println("company is available");
		} else {
			Company companyData = new Company();
			companyData.setName(name);
			companyData.setWebsite(website);
			companyData.setEmail(email);
			companyData.setAddress(address);
			companyData.setTags(tags);
			companiesRepository.save(companyData);
		}
		return companiesRepository.findAll();
	}
	
	public List<Company> saveOrUpdate(String website, String email, String address, String tags) {
		companyData.setWebsite(website);
		companyData.setEmail(email);
		companyData.setAddress(address);
		companyData.setTags(tags);
		companiesRepository.save(companyData);
		return companiesRepository.findAll();
	}

	//for update
	public Company getCompanyById(long id) {
		return companiesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid conatact Id: " + id));
	}

	public void saveCompany(Company company) {
		companiesRepository.save(company);
	}
	//upto here
	
	public void deleteCompanyById(long id) {
		this.companiesRepository.deleteById(id);
	}

	public void changeTrash(long id) {
		List<Company> data = companiesRepository.findAll();
		for(Company i : data) {
			if(i.getId() == (long)id) {
				i.setCompanyTrash((int)1);
				companiesRepository.save(i);
			}
		}
	}

	public void retrieveTrash(int id) {
		List<Company> data = companiesRepository.findAll();
		for(Company i : data) {
			if(i.getId() == (long)id) {
				i.setCompanyTrash((int)0);
				companiesRepository.save(i);
			}
		}
		
	}

	public List<Company> trashedData() {
		List<Company> data = companiesRepository.findAll();
		List<Company> trashedData = new ArrayList<>();
		for(Company i : data) {
			if(i.getCompanyTrash() == 1) {
				trashedData.add(i);
			}
		}
		return trashedData;
	}

	

//   @Override
//   public List<Company> getCompany(String keyword) {
//    List<Company> Alldata = companiesRepository.findAll();
//	List<Company> data = new ArrayList<>();
//	
//	if (keyword != null) {
//        List<Company> filtered = companiesRepository.search(keyword);
//        for(int i=0;i< filtered.size();i++)
//        	if(filtered.get(i).getTrash()==0) {
//        		data.add(filtered.get(i));
//        	}
//        return data;
//    }
//	else {
//	for(int i=0;i< Alldata.size();i++)
//	if(Alldata.get(i).getTrash()==0) {
//		data.add(Alldata.get(i));
//	}
//	return data;
//	}
//   }

}
