package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

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
        InventoryEventListener inventoryEventListener(JavaMailSender javaMailSender) {
            return new InventoryEventListener(javaMailSender);
        }

        @Bean
        JavaMailSender javaMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.mailtrap.io");
            mailSender.setPort(2525);

            mailSender.setUsername("f3a60689e18915");
            mailSender.setPassword("414ad6df522c7c");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;
        }

    }

}
