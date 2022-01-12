package com.bechtle.eagl.webapp.model.events;

import com.bechtle.eagl.webapp.model.User;
import org.springframework.context.ApplicationEvent;

public class UserRefreshedEvent extends ApplicationEvent {

    public UserRefreshedEvent(User source) {
        super(source);
    }

    public User getUser() {
        return (User) super.getSource();
    }
}
