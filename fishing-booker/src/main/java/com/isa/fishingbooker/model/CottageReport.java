package com.isa.fishingbooker.model;

import java.util.Date;

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
@Table(name = "cottage_report")
@DynamicUpdate
public class CottageReport {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cottage_owner_id", nullable = false)
    private CottageOwner cottageOwner;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cottage_reservation_id", nullable = false)
    private CottageReservation cottageReservation;
	

}
