package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class ApplicationWithSpringBoot {

    public static void main(String[] args) {
        new SpringApplication().run(ApplicationWithSpringBoot.class);
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
        InventoryEventListener inventoryEventListener(JavaMailSender javaMailSender) {
            return new InventoryEventListener(javaMailSender);
        }

    }

}
