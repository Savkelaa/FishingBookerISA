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

@Entity
@Table(name = "boat_quick_reservation")
@DynamicUpdate
public class BoatQuickReservation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "finish_date")
	private Date finishDate;
	
	@Column(name = "max_people")
	private int maxPeople;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "cancellation_condition")
	private int cancellationCondition;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_id", nullable = false)
    private Boat boat;
	
	@JsonIgnore
    @OneToMany(mappedBy="boatQuickReservation",fetch=FetchType.LAZY)
    private List<AdditionalService> additionalServices ;
	
	@JsonIgnore
    @OneToMany(mappedBy="boatQuickReservation",fetch=FetchType.LAZY)
    private List<FishingEquipment> fishingEquipment ;
	
	@JsonIgnore
    @OneToMany(mappedBy="boatQuickReservation",fetch=FetchType.LAZY)
    private List<BoatReport> boatReports ;
	
	@JsonIgnore
    @OneToMany(mappedBy="boatQuickReservation",fetch=FetchType.LAZY)
    private List<BoatComplaint> boatComplaints ;
}
