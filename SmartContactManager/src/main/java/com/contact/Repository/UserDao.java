package com.contact.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
