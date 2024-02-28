package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	Optional<Contact> findByFirstName(String firstName);

}