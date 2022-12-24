package com.contact.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.model.Contacts;

public interface ContactDao extends JpaRepository<Contacts, Integer>{

}
