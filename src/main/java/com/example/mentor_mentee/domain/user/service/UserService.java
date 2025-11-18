package com.example.mentor_mentee.domain.user.service;

import com.example.mentor_mentee.domain.user.dto.request.JoinRequestDto;
import com.example.mentor_mentee.domain.user.dto.response.InfoResponseDto;
import com.example.mentor_mentee.domain.user.dto.response.PatchRequestDto;
import com.example.mentor_mentee.domain.user.entity.User;
import com.example.mentor_mentee.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public void join(JoinRequestDto dto){
        // 1. User 생성하기
        User user = User.builder()
                .name(dto.getName())
                .nickname(dto.getNickname())
                .classNum(dto.getClassNum())
                .email(dto.getEmail())
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .department(dto.getDepartment())
                .inSchool(dto.isInSchool())
                .build();

        // 2. user에 저장된 비밀번호 encoding하기
        user.encodePassword(passwordEncoder);

        // 3. User 저장하기
        userRepository.save(user);
    }

    // 사용자 정보 조회
    @Transactional(readOnly = true)
    public InfoResponseDto getInfo(Long userId){
        // 1. 사용자 정보 조회 (해당 사용자가 없으면 런타임 에러 실행)
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // 2. 가져온 사용자 정보를 dto로 변환
        InfoResponseDto dto = InfoResponseDto.builder()
                .userId(userId)
                .name(user.getName())
                .nickname(user.getNickname())
                .classNum(user.getClassNum())
                .email(user.getEmail())
                .loginId(user.getLoginId())
                .department(user.getDepartment())
                .inSchool(user.isInSchool())
                .build();
        return dto;
    }

    // 사용자 정보 수정
    @Transactional
    public void patchInfo(Long userId, PatchRequestDto dto){
        // 1. 사용자 정보 가져오기 (해당 사용자 정보 없으면 예외 처리하기)
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // 2. 사용자 정보 수정하기 (User 엔티티에 선언해놓은 patchInfo 함수 사용)
        user.patchInfo(dto);

        // 3. user 비밀번호 인코딩
        user.encodePassword(passwordEncoder);
        // ㄴ> 이후, 굳이 다시 save() 해주지 않아도 된다. (@Transactional, 영속성 컨텍스트 덕분에 해당 트랜잭션이 끝나면 자동으로 변경 사항이 업데이트 된다)
    }

    // 회원 탈퇴
    @Transactional
    public void withdraw(Long userId){
        // 해당 user가 존재하는경우
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
