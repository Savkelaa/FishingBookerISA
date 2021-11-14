package com.isa.fishingbooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "fishing_class_complaint")
@DynamicUpdate
public class FishingClassComplaint {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	//check
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="fishing_class_reservation_id", nullable = true)
    private FishingClassReservation fishingClassReservation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="fishing_class_quick_reservation_id", nullable = true)
    private FishingClassQuickReservation fishingClassQuickReservation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
}
