package com.isa.fishingbooker.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cottage")
@DynamicUpdate
public class Cottage {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottage",fetch=FetchType.LAZY)
       private List<CottageRate> rates ;
	/*
	 * @Column(name = "enteries_photos")
	private String enteries_photos;
	
	@Column(name = "exterier_photos")
	private String exterier_photos;
	 * 
	 * 
	 */
	
	/*
	 * @Column(name = "quick_appointment")
	private String quick_appointment;
	
	 * 
	 * 
	 */
	
	
	@JsonIgnore
    @OneToMany(mappedBy="cottage",fetch=FetchType.LAZY)
       private List<CottageBehavioralRule> behavioralRules ;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottage",fetch=FetchType.LAZY)
       private List<CottageRoom> Rooms ;
	
	
	
	
	
	
	
	
	
}
