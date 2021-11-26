package com.isa.fishingbooker.model;

import java.util.HashMap;
import java.util.List;

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

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cottage")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cottage {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "promo_description")
	private String promoDescription;
	
	@Column(name = "price")
	private int price;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottage",fetch=FetchType.LAZY)
    private List<CottageRate> rates ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cottage_owner_id", nullable = false)
    private CottageOwner cottageOwner;
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
