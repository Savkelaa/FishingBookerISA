package com.isa.fishingbooker.model;

import java.util.Date;
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
@Table(name = "fishing_class_quick_reservation")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FishingClassQuickReservation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "finish_date")
	private Date finishDate;
	
	@Column(name = "max_people")
	private int maxPeople;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "discount")
	private int discount;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="fishing_class_id", nullable = false)
    private FishingClass fishingClass;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    private List<AdditionalService> additionalServices ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    private List<FishingClassReport> fishingClassReport ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    private List<FishingClassComplaint> fishingClassComplaints ;
}
