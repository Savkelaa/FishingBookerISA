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
@Table(name = "datespanboat")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DateSpanBoat {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boat_id")
    private Boat boat;
}

