package com.appledevapp.learning.properties;

import com.appledevapp.learning.properties.event.AppEnvPreparedEventListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootLearningPropertiesApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.listeners(new AppEnvPreparedEventListener());
        application.sources(SpringbootLearningPropertiesApplication.class);
        application.run(args);
    }
}
