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
@Table(name = "cottage_room")
@DynamicUpdate
public class CottageRoom {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "number")
	private String number;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getNum_beds() {
		return num_beds;
	}

	public void setNum_beds(int num_beds) {
		this.num_beds = num_beds;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	@Column(name = "num_beds")
	private int num_beds;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cottage_id", nullable = false)
    private Cottage cottage;

	public CottageRoom(Integer id, String number, int num_beds, Cottage cottage) {
		super();
		this.id = id;
		this.number = number;
		this.num_beds = num_beds;
		this.cottage = cottage;
	}

	public CottageRoom() {
		super();
	}
	
	
	
	
}
