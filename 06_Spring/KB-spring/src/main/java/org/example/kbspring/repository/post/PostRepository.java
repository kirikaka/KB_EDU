package org.example.kbspring.repository.post;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.kbspring.dto.post.PostDto;
import org.example.kbspring.mapper.PostMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostMapper postMapper;
    private final RedisTemplate<String, Object> redisTemplate;


    public List<PostDto> findAll(){
        return postMapper.findAll();
    }
    public int delete(int id){
        return postMapper.delete(id);
    }
    public int save(String title, String content){
        return postMapper.save(title,content);
    }

    public List<PostDto> findByCond(String title,String content){
        return postMapper.findByCond(title,content);
    }

    public void deleteAll(){
        postMapper.deleteAll();
        redisTemplate.delete(redisTemplate.keys("post:*"));

    }
    public PostDto findByIdFromRedis(int id){
        Object obj = redisTemplate.opsForValue().get("post:"+id);
        if(obj instanceof PostDto){
            return (PostDto)obj;
        }
        return null;
    }

    public void saveForTest(PostDto post){
        postMapper.saveForTest(post);
        redisTemplate.opsForValue().set("post:"+post.getId(),post);

    }

    public PostDto findById(int id){
        return postMapper.findById(id);
    }




}
