package com.idcut.mosmqtt.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.idcut.mosmqtt.constant.EventConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class EventBusConfig {

    @Bean
    public AsyncEventBus asyncEventBus() {
        return new AsyncEventBus(EventConstant.DEFAULT_ASYNC_EVENT, Executors.newFixedThreadPool(EventConstant.DEFAULT_POOL_SIZE));
    }

    @Bean(name = "syncEventBus")
    public EventBus syncEventBus() {
        return new EventBus(EventConstant.DEFAULT_SYNC_EVENT);
    }
}
