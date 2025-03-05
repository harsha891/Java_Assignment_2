package com.term3.assignment2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private List<BlogPost> posts;
    private List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    public List<String> getPostsByAuthorAge(int age) {
        // Created map of author Id and Age for post reference
        Map<String, Integer> authorAgeMap = contributors.stream()
                .collect(Collectors.toMap(Person::getId, Person::getAge));

        return posts.stream()
                .filter(post -> authorAgeMap.getOrDefault(post.getAuthorId(), -1) == age)
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }

}
