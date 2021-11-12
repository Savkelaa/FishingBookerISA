package com.FishingBooker.FishingBooker.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="cottage")
public class Cottage {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	
	
public Cottage(){super();}



public Cottage(Integer id,String name){super();this.id=id;this.name=name;}
	
	

public Integer getId() {
return id;}



public void setId(Integer id) {
this.id = id;}



public String getName() {
return name;}



public void setName(String name) {
this.name = name;}


	
}



