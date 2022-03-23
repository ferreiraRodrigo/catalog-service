package com.ecommerce.catalogservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("catalog-service")
@Data
public class Configuration {

    private int mockValue;

}
