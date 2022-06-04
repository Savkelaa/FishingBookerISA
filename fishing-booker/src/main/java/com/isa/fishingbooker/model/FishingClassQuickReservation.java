package com.isa.fishingbooker.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_date_action")
	private LocalDate startDateAction;

	@Column(name = "finish_date_action")
	private LocalDate finishDateAction;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "finish_date")
	private LocalDate finishDate;


	@Column(name = "price")
	private int price;
	

	
	@Column(name = "place")
	private String place;
	
	//@Column(name = "discount")
	//private int discount;


	@ElementCollection
	@OrderColumn(name = "additional_services")
	private String[] additionalServicess;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="fishing_class_id")
    private FishingClass fishingClass;
	
	//@JsonIgnore
   // @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    //private List<AdditionalService> additionalServices ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    private List<FishingClassReport> fishingClassReport ;
	
	@JsonIgnore
    @OneToMany(mappedBy="fishingClassQuickReservation",fetch=FetchType.LAZY)
    private List<FishingClassComplaint> fishingClassComplaints ;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name="fishing_class_quick_reservation_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="additional_service_id",referencedColumnName = "id"))
	private List<AdditionalService> additionalServices;


}
