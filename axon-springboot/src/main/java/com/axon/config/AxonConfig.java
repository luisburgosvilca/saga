package com.axon.config;

import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Autowired
    public void configure(EventProcessingConfigurer configurer){

        configurer.usingSubscribingEventProcessors();

    }
}
