package com.bechtle.eagl.webapp.clients.user.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    public String login;
    public String relationshipId;
}
