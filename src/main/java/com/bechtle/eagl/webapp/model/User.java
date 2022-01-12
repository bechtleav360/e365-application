package com.bechtle.eagl.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class User {

    public String login;

    List<Relationships> relationships;

}
