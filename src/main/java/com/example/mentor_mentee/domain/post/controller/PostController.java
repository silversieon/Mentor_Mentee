package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDtos;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService ;

    @PostMapping
    public PostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        PostResponseDto responseDto = postService.createPost(createPostRequestDto);
        return responseDto;
    }

    @GetMapping
    public List<PostListResponseDto> getAllPosts() {
        List<PostListResponseDto> responseDtos = postService.readPostList();
        return responseDtos;
    }

    @GetMapping("/{post-id}")
    public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.readPost(id);
        return responseDto;
    }

    @PutMapping("/{post-id}")
    public PostResponseDto updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
        return responseDto;
    }

    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable(value = "post-id") Long id){
        String response = postService.deletePost(id);
        return response;
    }

}