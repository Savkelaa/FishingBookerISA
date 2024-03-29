package com.isa.fishingbooker.model;

import java.time.LocalDate;
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
@Table(name = "fishing_class_reservation")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FishingClassReservation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "finish_date")
	private LocalDate finishDate;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "place")
	private String place;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="fishing_class_id", nullable = false)
    private FishingClass fishingClass;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassReservation",fetch=FetchType.LAZY)
    private List<AdditionalService> additionalServices ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassReservation",fetch=FetchType.LAZY)
    private List<FishingClassReport> fishingClassReport ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassReservation",fetch=FetchType.LAZY)
    private List<FishingClassComplaint> fishingClassComplaints ;	
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassReservation",fetch=FetchType.LAZY)
    private List<FishingEquipment> fishingEquipments;
}
