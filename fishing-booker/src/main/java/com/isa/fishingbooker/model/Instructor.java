package com.isa.fishingbooker.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Instructor implements UserDetails {
	
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
	
	@Column(name = "refusalReason")
	private String refusalReason;

	@Column(name = "deleteRequest")
	private String deleteRequest;

	@Column(name = "deleteReason")
	private String deleteReason;

	@Column(name = "availabilityPeriodFrom")
	private Date availabilityPeriodFrom;

	@Column(name = "availabilityPeriodTo")
	private Date availabilityPeriodTo;

	@JsonIgnore
	@OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
	private List<InstructorComplaint> instructorsComplaint;

	@JsonIgnore
	@OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
	private List<DateSpanInstructor> dateSpanInstructors;

	@JsonIgnore
    @OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
    private List<FishingClass> fishingClasses ;
	
	@JsonIgnore
    @OneToMany(mappedBy="instructor",fetch=FetchType.LAZY)
    private List<InstructorRate> instructorRates ;
	
	@Column(name="averageRate")
	private Long averageRate;

	@Version
	@Column(name= "version", nullable= false)
	private Integer version;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
