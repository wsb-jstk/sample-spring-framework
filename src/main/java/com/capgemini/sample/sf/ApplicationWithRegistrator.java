package com.capgemini.sample.sf;

import com.capgemini.sample.sf.infrastructure.Registrator;
import com.capgemini.sample.sf.infrastructure.ServiceRegistrator;
import com.capgemini.sample.sf.inventory.*;

public class ApplicationWithRegistrator {

    public static void main(String[] args) {
        Registrator registrator = new ServiceRegistrator();
        registrator.register(new InMemoryInventoryRepository());
        registrator.register(new InventoryLoggingEventPublisher());
        registrator.register(new InventoryFacade(registrator));

        InventorySampleData.initSampleItems(registrator.getObject(InventoryRepository.class));

        new ApplicationRunner().run(registrator.getObject(InventoryFacade.class));
    }

}
