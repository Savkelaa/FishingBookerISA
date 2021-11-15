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
@Table(name = "fishing_class_report")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FishingClassReport {
	
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
    @JoinColumn(name="instructor_id", nullable = false)
    private Instructor instructor;
}
