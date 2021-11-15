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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boat_report")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoatReport {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_owner_id", nullable = false)
    private BoatOwner boatOwner;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_reservation_id", nullable = false)
    private BoatReservation boatReservation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_quick_reservation_id", nullable = false)
    private BoatQuickReservation boatQuickReservation;
}
