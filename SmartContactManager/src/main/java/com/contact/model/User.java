package com.contact.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String role;
	
	private boolean enabled;
	
	private String imgUrl;
	
	@Column(length = 500)
	private String desc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	List<Contacts>contact;

}
