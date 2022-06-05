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
@Table(name = "boatimage")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoatImage {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_id", nullable = false)
    private Boat boat;
}
