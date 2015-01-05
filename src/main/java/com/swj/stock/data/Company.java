package com.swj.stock.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(catalog="stock", schema="", name="company")
public class Company {
	
	public enum MTYPE {
		KOSPI, KOSDAQ, KONEX
	}
	
	@Id
	@Column(length=10)
	String symbol;
	
	@Column(length=40)
	String name;
	
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	MTYPE mtype;
	
	@Column
	Date updDt;
	
	@Column(length=10)
	String status;
	

}
