package com.example.mentor_mentee.domain.user.controller;

import com.example.mentor_mentee.domain.user.dto.request.JoinRequestDto;
import com.example.mentor_mentee.domain.user.dto.response.InfoResponseDto;
import com.example.mentor_mentee.domain.user.dto.response.PatchRequestDto;
import com.example.mentor_mentee.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("")
    public  String join(@RequestBody @Valid JoinRequestDto dto){
        userService.join(dto);
        return "joined";
    }

    // 사용자 정보 조회
    @GetMapping("/{userId}")
    public InfoResponseDto getInfo(@PathVariable Long userId){
        InfoResponseDto responseDto = userService.getInfo(userId);
        return responseDto;
    }

    // 사용자 정보 수정
    @PatchMapping("/{userId}")
    public String patchInfo(@RequestBody @Valid PatchRequestDto dto, @PathVariable Long userId){
        userService.patchInfo(userId, dto);
        return "patched";
    }

    // 회원 탈퇴
    @DeleteMapping("/{userId}")
    public String withdraw(@PathVariable Long userId){
        userService.withdraw(userId);
        return "withdrawn";
    }
}
