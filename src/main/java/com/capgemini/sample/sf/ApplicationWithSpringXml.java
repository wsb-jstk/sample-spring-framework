package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.InventoryFacade;
import com.capgemini.sample.sf.inventory.InventoryRepository;
import com.capgemini.sample.sf.inventory.InventorySampleData;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationWithSpringXml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        InventorySampleData.initSampleItems(context.getBean(InventoryRepository.class));

        new ApplicationRunner().run(context.getBean(InventoryFacade.class));
    }

}
