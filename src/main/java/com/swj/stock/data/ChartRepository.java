package com.swj.stock.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends ChartRepositoryCustom,  JpaRepository<Chart, ChartPK>{

}
