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
@Table(name = "additional_service")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdditionalService {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="cottage_reservation_id", nullable = true)
    private CottageReservation cottageReservation;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="boat_reservation_id", nullable = true)
    private BoatReservation boatReservation;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
   @JoinColumn(name="fishing_class_reservation_id", nullable = true)
    private FishingClassReservation fishingClassReservation;
	
	//@ManyToOne(fetch = FetchType.LAZY, optional = true)
   // @JoinColumn(name="fishing_class_quick_reservation_id", nullable = true)
   // private FishingClassQuickReservation fishingClassQuickReservation;


}
