package com.term3.assignment2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private List<BlogPost> posts;
    private List<Person> contributors;
}
