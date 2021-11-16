package com.isa.fishingbooker.model;

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
@Table(name = "boat")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Boat {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "promo_description")
	private String promoDescription;
	
	@Column(name = "num_motors")
	private String num_motors;
	
	@Column(name = "motor_power")
	private int motorPower;
	
	@Column(name = "max_speed")
	private int maxSpeed;
	
	/*
	 * @Column(name = "enteries_photos")
	private String enteries_photos;
	
	@Column(name = "exterier_photos")
	private String exterier_photos;
	 * 
	 * 
	 */
	
	@Column(name="cancellation_condition")
	private int cancellationCondition;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "price")
	private int price;
	
	@JsonIgnore
    @OneToMany(mappedBy="boat",fetch=FetchType.LAZY)
    private List<BoatRate> rates ;
	
	@JsonIgnore
    @OneToMany(mappedBy="boat",fetch=FetchType.LAZY)
    private List<BoatNavigationEquipment> navigationEquipment ;
	
	@JsonIgnore
    @OneToMany(mappedBy="boat",fetch=FetchType.LAZY)
    private List<BoatBehavioralRule> behavioralRules ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_owner_id", nullable = false)
    private BoatOwner boatOwner;
	
	
}
