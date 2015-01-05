package com.swj.stock.data;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

@Slf4j
public class ChartRepositoryImpl extends QueryDslRepositorySupport implements
		ChartRepositoryCustom {

	public ChartRepositoryImpl() {
		super(Chart.class);
	}
	
	@Override
	public Chart findLatest(String symbol) {
		
		QChart qChart = QChart.chart;
		
		ChartPK chartPK = new ChartPK();
		chartPK.setSymbol(symbol);
		
		Chart aaa = from(qChart).where(qChart.chartPK.symbol.eq(symbol)).orderBy(qChart.chartPK.date.desc()).limit(1).uniqueResult(qChart);
		
		return aaa;
	}

}
