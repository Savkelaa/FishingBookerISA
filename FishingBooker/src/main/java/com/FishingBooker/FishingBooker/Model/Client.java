package com.FishingBooker.FishingBooker.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="client")
@Table(name="client")
@DynamicUpdate
public class Client {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private long postalCode;
	
	
	
	
	
	
	
	public Client(){
		super();
	}
 








public Client(long id,String name,String address,String city,long postalCode){super();this.id=id;this.name=name;this.address=address;this.city=city;this.postalCode=postalCode;}









public long getId() {
return id;}

public void setId(long id) {
this.id = id;}

public String getName() {
return name;}

public void setName(String name) {
this.name = name;}

public String getAddress() {
return address;}

public void setAddress(String address) {
this.address = address;}

public String getCity() {
return city;}

public void setCity(String city) {
this.city = city;}

public long getPostalCode() {
return postalCode;}

public void setPostalCode(long postalCode) {
this.postalCode = postalCode;}






	
	
	
	
	
	
}


