package com.term3.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {

    @Test
    void TestBlogPostInstanceCreationSuccess() {
        BlogPost post = BlogPost.builder()
                .id("AC1")
                .authorId("Author031")
                .postContent("Assignment 2 part 1 Completed")
                .build();

        // Assertions
        assertEquals("AC1", post.getId());
        assertEquals("Author031", post.getAuthorId());
        assertEquals("Assignment 2 part 1 Completed", post.getPostContent());
    }

    @Test
    void TestBlogPostNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id(null)
                .authorId("Author031")
                .postContent("Assignment 2 part 1 Completed")
                .build()
        );

        // Assertions
        assertTrue(exception.getMessage().equals("ID cannot be null."));
    }

    @Test
    void TestBlogPostNullAuthorId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id("A12")
                .authorId(null)
                .postContent("Assignment 2 part 1 Completed")
                .build()
        );

        // Assertions
        assertTrue(exception.getMessage().equals("authorId cannot be null or blank"));
    }
}
