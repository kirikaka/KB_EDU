package org.example.kbspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.kbspring.dto.post.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> findAll();
    int delete(@Param("id") int id);
    int save(@Param("title") String title,@Param("content") String content);
}
