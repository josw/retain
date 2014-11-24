package com.swj.stock.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({PropertyPlaceholderConfig.class, PersistenceConfig.class})
public class StockServiceConfig {

}
