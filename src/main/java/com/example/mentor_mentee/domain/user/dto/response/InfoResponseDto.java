package com.example.mentor_mentee.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InfoResponseDto {
    private final Long userId;
    private final String name;
    private final String nickname;
    private final String classNum;
    private final String email;
    private final String loginId;
    private final String department;
    private final boolean inSchool;
}
