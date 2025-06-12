package org.example.kbspring.service.post;

import lombok.RequiredArgsConstructor;
import org.example.kbspring.dto.post.PostDto;
import org.example.kbspring.repository.member.v3.MemberRepositoryV3;
import org.example.kbspring.repository.post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> findAll(){
        return postRepository.findAll();
    }
    public int delete(int id){
        return postRepository.delete(id);
    }
    public int save(String title, String content){
        return postRepository.save(title,content);
    }



}
