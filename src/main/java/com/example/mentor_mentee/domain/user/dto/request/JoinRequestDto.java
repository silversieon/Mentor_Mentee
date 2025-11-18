package com.example.mentor_mentee.domain.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinRequestDto {
    @NotBlank // null, 빈 문자열, 공백 문자열도 허용하지 않는다.
    private final String name;
    @NotBlank
    private final String nickname;
    @NotBlank
    private final String classNum;

    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String loginId;
    @NotBlank
    private final String password;
    @NotBlank
    private final String department;
    @NotNull
    @Builder.Default
    private final boolean inSchool = true;
}