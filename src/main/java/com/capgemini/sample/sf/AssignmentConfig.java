package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.InventoryFacade;
import com.capgemini.sample.sf.inventory.InventoryRepository;
import com.capgemini.sample.sf.inventory.InventorySampleData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class AssignmentConfig {

    @Bean
    @Order(1)
    ApplicationRunner initSampleData(InventoryRepository repository) {
        return args -> InventorySampleData.initSampleItems(repository);
    }

    @Bean
    @Order(2)
    ApplicationRunner runAssignment(InventoryFacade facade) {
        return args -> new AssignmentRunner().run(facade);
    }

}
