package org.scoula.mongo.dao;

import org.scoula.mongo.bean.Post;

import java.util.List;

public interface PostDAO {
    void createPost(Post post);
    List<Post> readPosts();
    boolean updatePost(int id, String newTitle, String newContent);
    boolean deletePost(int id);
    boolean isPostIdExists(int id); // ID 중복 체크 메서드 추가
}