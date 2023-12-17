package ru.sbt.synapse.simplewebservice.property;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String emailId;
}
