package org.scoula.mongo.service;

import org.scoula.mongo.bean.Post;

import java.util.List;

public interface PostService {
    void createPost(int id, String title, String content);
    List<Post> readPosts();
    boolean updatePost(int id, String newTitle, String newContent);
    boolean deletePost(int id);
    boolean isPostIdExists(int id); // ID 중복 체크 메서드 추가
}