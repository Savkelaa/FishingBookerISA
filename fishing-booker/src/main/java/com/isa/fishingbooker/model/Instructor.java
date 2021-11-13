package com.isa.fishingbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "instructor")
@DynamicUpdate
public class Instructor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "short_biography")
	private String shortBiography;

	
	

public Instructor() {
		super();
	}

public Instructor(Integer id, String name, String surname, String address, String city, String country,
			String email, String password, String number, String explanation, String shortBiography) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.password = password;
		this.number = number;
		this.explanation = explanation;
		this.shortBiography = shortBiography;
	}

public Integer getId() {
return id;}

public void setId(Integer id) {
this.id = id;}

public String getName() {
return name;}

public void setName(String name) {
this.name = name;}

public String getSurname() {
return surname;}

public void setSurname(String surname) {
this.surname = surname;}

public String getAddress() {
return address;}

public void setAddress(String address) {
this.address = address;}

public String getCity() {
return city;}

public void setCity(String city) {
this.city = city;}

public String getCountry() {
return country;}

public void setCountry(String country) {
this.country = country;}

public String getEmail() {
return email;}

public void setEmail(String email) {
this.email = email;}

public String getPassword() {
return password;}

public void setPassword(String password) {
this.password = password;}

public String getNumber() {
return number;}

public void setNumber(String number) {
this.number = number;}

public String getExplanation() {
return explanation;}

public void setExplanation(String explanation) {
this.explanation = explanation;}
}
