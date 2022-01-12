package com.bechtle.eagl.webapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Relationships {
    String relationshipId;
    String linkingCode;
    String login;
    List<String> peers;
    String address;
}