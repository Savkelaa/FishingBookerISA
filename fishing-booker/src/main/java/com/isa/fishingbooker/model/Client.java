package com.isa.fishingbooker.model;

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
@Table(name = "client")
@DynamicUpdate
public class Client {
	
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
	
	@Column(name = "penalty")
	private int penalty;
	
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

	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<CottageRate> cottageRates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<CottageOwnerRate> cottageOwnerRates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<InstructorRate> instructorRates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<BoatRate> boatRates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<FishingClassRate> fishingClassRates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<CottageReservation> cottageReservations ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<CottageQuickReservation> cottageQuickReservations ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<BoatReservation> boatReservations ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<BoatQuickReservation> boatQuickReservations ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<CottageComplaint> cottageComplaints ;
	
	@JsonIgnore
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<BoatComplaint> boatComplaints ;
	
	
public Client() {
		super();
	}



}
