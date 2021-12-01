package com.capgemini.sample.sf.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod") // solution 3
@Configuration
public class ProdAppConfig {

    @Bean
    CriticalEventListener criticalEventListener(NotificationService notificationService) {
        return new CriticalEventListener(notificationService);
    }

}
