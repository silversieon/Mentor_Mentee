package com.example.mentor_mentee.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class PostRequestDto {

    private final String title;
    private final String content;
}
