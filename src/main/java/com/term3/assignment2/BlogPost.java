package com.term3.assignment2;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class BlogPost {
    private String id;
    private String authorId;
    private String postContent;

    public BlogPost(String id, String authorId, String postContent) {
        if(id == null)
            throw new IllegalArgumentException("ID cannot be null.");
        if (authorId == null)
            throw new IllegalArgumentException("authorId cannot be null or blank");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}
