package com.isa.fishingbooker.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "cottage_quick_reservation")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CottageQuickReservation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "finish_date")
	private Date finishDate;
	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "max_people")
	private int maxPeople;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="client_id", nullable = true)
    private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name="cottage_id", nullable = false)
    private Cottage cottage;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottageQuickReservation",fetch=FetchType.LAZY)
    private List<AdditionalService> additionalServices ;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottageQuickReservation",fetch=FetchType.LAZY)
    private List<CottageReport> cottageReports ;
	
	@JsonIgnore
    @OneToMany(mappedBy="cottageQuickReservation",fetch=FetchType.LAZY)
    private List<CottageComplaint> cottageComplaint ;
}
