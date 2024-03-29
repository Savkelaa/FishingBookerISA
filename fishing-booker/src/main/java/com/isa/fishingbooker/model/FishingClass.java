package com.isa.fishingbooker.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fishing_class")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FishingClass {

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
	
	@Column(name = "cancellation_condition")
	private String cancellationCondition;
	
	@Column(name = "max_people")
	private int maxPeople;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="instructor_id", nullable = false)
    private Instructor instructor;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name="fishing_class_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="client_id",referencedColumnName = "id"))
	private List<Client> subscribers;
	



	@JsonIgnore
    @OneToMany(mappedBy="fishingClass",fetch=FetchType.LAZY)
    private List<Image> images;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClass",fetch=FetchType.LAZY)
    private List<FishingClassBehavioralRule> behavioralRules ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClass",fetch=FetchType.LAZY)
    private List<FishingClassRate> fishingClassRates ;
}
