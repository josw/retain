package com.swj.stock.data;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(catalog="stock", schema="", name="chart")
public class Chart {
	
	@EmbeddedId
	private ChartPK chartPK;
	
	@Column
	private int p1;
	@Column
	private int p2;
	@Column
	private int p3;
	@Column
	private int p4;
	@Column
	private int amt;

}
