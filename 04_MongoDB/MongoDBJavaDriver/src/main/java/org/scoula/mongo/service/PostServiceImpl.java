package org.scoula.mongo.service;

import org.scoula.mongo.bean.Post;
import org.scoula.mongo.dao.PostDAO;

import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void createPost(int id, String title, String content) {
        if (!postDAO.isPostIdExists(id)) {
            Post post = new Post(id, title, content);
            postDAO.createPost(post);
            System.out.println("Post created successfully");
        } else {
            System.out.println("Post ID already exists. Please choose a different ID.");
        }
    }

    @Override
    public List<Post> readPosts() {
        return postDAO.readPosts();
    }

    @Override
    public boolean updatePost(int id, String newTitle, String newContent) {
        return postDAO.updatePost(id, newTitle, newContent);
    }

    @Override
    public boolean deletePost(int id) {
        return postDAO.deletePost(id);
    }

    @Override
    public boolean isPostIdExists(int id) {
        return postDAO.isPostIdExists(id);
    }
}