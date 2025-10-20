package com.example.mentor_mentee.domain.post.dto.request;

import lombok.*;

@Getter
@Builder
public class CreatePostRequestDto {
    private final String title;
    private final String content;
}