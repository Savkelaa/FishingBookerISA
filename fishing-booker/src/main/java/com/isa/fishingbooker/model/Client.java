package com.isa.fishingbooker.model;

import java.util.Collection;
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
@Table(name = "client")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements UserDetails{
	
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

	@Column(name = "points")
	private int points;

	@Version
	@Column(name= "version", nullable= false)
	private Integer version;

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

	@JsonIgnore
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<InstructorComplaint> instructorsComplaint;



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
