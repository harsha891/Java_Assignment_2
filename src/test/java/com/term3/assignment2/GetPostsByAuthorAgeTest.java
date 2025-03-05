package com.term3.assignment2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetPostsByAuthorAgeTest {

    @Test
    void testGetPostsByAuthorAge_Success() throws IOException {
        ObjectMapper objMapper = new ObjectMapper();

        List<Person> contributors = new ArrayList<>();
        List<BlogPost> posts = new ArrayList<>();

        // Reading json files into lists
        contributors = objMapper.readValue(new File("src/test/resources/person_success.json"), new TypeReference<>() {});
        posts = objMapper.readValue(new File("src/test/resources/blogPosts_success.json"), new TypeReference<>() {});

        Blog blog = new Blog(posts, contributors);

        List<String> result = blog.getPostsByAuthorAge(30);
        assertTrue(result.contains("b1") && result.contains("b4"));
    }

    @Test
    void testGetPostsByAuthorAge_empty() throws IOException {
        ObjectMapper objMapper = new ObjectMapper();

        List<Person> contributors = new ArrayList<>();
        List<BlogPost> posts = new ArrayList<>();

        Blog blog = new Blog(posts, contributors);

        List<String> result = blog.getPostsByAuthorAge(30);
        System.out.println(result);
        assertTrue(result.isEmpty());
    }
}
