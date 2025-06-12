package org.example.kbspring.repository.post;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.example.kbspring.dto.post.PostDto;
import org.example.kbspring.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostMapper postMapper;

    public List<PostDto> findAll(){
        return postMapper.findAll();
    }
    public int delete(int id){
        return postMapper.delete(id);
    }
    public int save(String title, String content){
        return postMapper.save(title,content);
    }





}
