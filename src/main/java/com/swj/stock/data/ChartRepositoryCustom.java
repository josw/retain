package com.swj.stock.data;

public interface ChartRepositoryCustom {

	Chart findLatest(String symbol);

}
