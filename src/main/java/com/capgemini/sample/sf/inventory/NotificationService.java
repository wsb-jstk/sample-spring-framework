package com.capgemini.sample.sf.inventory;

import lombok.Builder;
import lombok.Value;

public interface NotificationService {

    public void send(MessageDto message);

}

@Value
@Builder
class MessageDto {
    String title;
    String text;
}
