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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructor")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
	
	@Column(name = "activated")
	private String activated;

	@Column(name = "deleted")
	private String deleted;
	
	@JsonIgnore
    @OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
    private List<FishingClass> fishingClasses ;
	
	@JsonIgnore
    @OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
    private List<InstructorRate> instructorRates ;
	
	@Column(name="averageRate")
	private Long averageRate;
}
