package com.term3.assignment2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    private Person(String id, String firstName, String lastName, int age, String gender) {
        if(id == null)
            throw new IllegalArgumentException("ID cannot be null.");
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name cannot be null or blank");
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Last name cannot be null or blank");
        if (age <= 0)
            throw new IllegalArgumentException("age connot be negative");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}
