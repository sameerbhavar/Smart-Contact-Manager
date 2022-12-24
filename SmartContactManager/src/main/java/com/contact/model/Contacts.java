package com.contact.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Contacts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String cName;
	private String nickName;
	private String work;
	private String CEmail;
	private long phoneNumber;
	private String cImgUrl;
	@Column(length = 1000)
	private String cDesc;

	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private User user;
	
	
	
}
