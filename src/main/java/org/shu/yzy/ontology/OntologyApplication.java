package org.shu.yzy.ontology;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackages = {"org.shu.yzy"})
public class OntologyApplication {
    Logger logger = LoggerFactory.getLogger(OntologyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OntologyApplication.class, args);
    }

}
