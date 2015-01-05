package com.swj.stock.data;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Embeddable
public class ChartPK implements Serializable{
	private String symbol;
	private Date date;
}
