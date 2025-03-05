package com.term3.assignment2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Assignment_2 {
    public static void main(String arg[]) {
        ObjectMapper objMapper = new ObjectMapper();

        List<Person> contributors = new ArrayList<>();
        List<BlogPost> posts = new ArrayList<>();

        try{
            // Reading json files into lists
            contributors = objMapper.readValue(new File("src/main/resources/person.json"), new TypeReference<>() {});
            posts = objMapper.readValue(new File("src/main/resources/blogPosts.json"), new TypeReference<>() {});
        }
        catch (JsonMappingException e) {
            System.out.println("Error : Invalid Json structure.");
        }
        catch (IOException e) {
            System.out.println("Error : Issue with reading Json File.");
        }

        Blog blog = new Blog(posts, contributors);

        // Print the total number of blog posts and contributors.
        System.out.println("Total number of Blog post: " + posts.size());
        System.out.println("Total number of Contributors: " + contributors.size());

        // Calling getPostsByAuthorAge for author age 30
        System.out.println("Posts of Author aged 30 - " + blog.getPostsByAuthorAge(30));

    }
}
