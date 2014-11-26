package com.swj.stock.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(catalog="stock", schema="", name="company")
public class Company {
	
	@Id
	String symbol;
	String name;
	

}
