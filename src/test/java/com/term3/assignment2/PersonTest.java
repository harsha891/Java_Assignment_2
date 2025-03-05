package com.term3.assignment2;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testingConstructorSuccessfullCreation() {
        Person person = Person.builder()
                .id("C0931034")
                .firstName("Harsha")
                .lastName("G")
                .age(25)
                .gender("male")
                .build();

        //assertion
        assertEquals("C0931034", person.getId());
        assertEquals("Harsha", person.getFirstName());
        assertEquals("G", person.getLastName());
        assertEquals(25, person.getAge());
        assertEquals("male", person.getGender());
    }

    @Test
    void testingConstructorNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id(null)
                .firstName("Harsha")
                .lastName("G")
                .age(25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("ID cannot be null."));
    }

    @Test
    void testingConstructorBlankFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id("C0931034")
                .firstName("")
                .lastName("G")
                .age(25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("First name cannot be null or blank"));
    }

    @Test
    void testingConstructorNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id("C0931034")
                .firstName(null)
                .lastName("G")
                .age(25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("First name cannot be null or blank"));
    }

    @Test
    void testingConstructorBlankLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id("C0931034")
                .firstName("Harsha")
                .lastName("")
                .age(25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("Last name cannot be null or blank"));
    }

    @Test
    void testingConstructorNullLasstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id("C0931034")
                .firstName("Harsha")
                .lastName(null)
                .age(25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("Last name cannot be null or blank"));
    }

    @Test
    void testingConstructorNegativeAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->Person.builder()
                .id("C0931034")
                .firstName("Harsha")
                .lastName("G")
                .age(-25)
                .gender("male")
                .build()
        );

        //assertion
        assertTrue(exception.getMessage().contains("age connot be negative"));
    }
}
