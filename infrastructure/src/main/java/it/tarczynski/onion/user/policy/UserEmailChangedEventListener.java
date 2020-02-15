package it.tarczynski.onion.user.policy;

import it.tarczynski.onion.user.model.UserEmailChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEmailChangedEventListener {

    @EventListener(UserEmailChangedEvent.class)
    public void logEmailChanged(UserEmailChangedEvent event) {
        System.out.println(event);
    }
}
