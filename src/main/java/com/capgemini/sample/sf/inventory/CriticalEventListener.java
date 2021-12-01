package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.NoItemOnStockEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
//@Profile("prod") // solution 2
//@ConditionalOnProperty(name = "send-mail", havingValue = "true", matchIfMissing = false) // solution 1
public class CriticalEventListener {

    private final NotificationService notificationService;

    @EventListener
    public void notifyOnNoItemOnStockEvent(NoItemOnStockEvent event) {
        MessageDto message = MessageDto.builder()
                .title("No item on stock!")
                .text("Got event: " + event).build();
        notificationService.send(message);
    }

}
