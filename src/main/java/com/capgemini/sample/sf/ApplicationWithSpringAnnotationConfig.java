package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationWithSpringAnnotationConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        InventorySampleData.initSampleItems(context.getBean(InventoryRepository.class));

        new ApplicationRunner().run(context.getBean(InventoryFacade.class));
    }


    @Configuration
    public static class SpringConfiguration {

        @Bean(name = {"myName", "drugaNazwa", "inventoryRepository"})
        InventoryRepository inventoryRepository() {
            return new InMemoryInventoryRepository();
        }

        @Bean
        InventoryEventPublisher inventoryEventPublisher(ApplicationEventPublisher publisher) {
            return new InventorySpringEventPublisher(publisher);
        }

        @Bean
        InventoryFacade inventoryFacade(InventoryRepository inventoryRepository,
                                        InventoryEventPublisher inventoryEventPublisher) {
            return new InventoryFacade(inventoryRepository, inventoryEventPublisher);
        }

        @Bean
        InventoryEventListener inventoryEventListener() {
            return new InventoryEventListener();
        }

    }

}
