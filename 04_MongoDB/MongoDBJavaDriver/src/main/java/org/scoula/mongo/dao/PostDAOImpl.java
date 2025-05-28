package org.scoula.mongo.dao;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.scoula.mongo.bean.Post;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class PostDAOImpl implements PostDAO {
    private final MongoCollection<Document> collection;

    public PostDAOImpl(MongoDatabase database) {
        this.collection = database.getCollection("posts");//posts collection얻어오기
    }

    @Override
    public void createPost(Post post) {
        Document document = new Document("id", post.getId())
                .append("title", post.getTitle())
                .append("content", post.getContent())
                .append("createdAt", post.getCreatedAt());
        collection.insertOne(document);
    }

    @Override
    public List<Post> readPosts() {
        List<Post> posts = new ArrayList<>();
        for (Document doc : collection.find()) {
            Post post = new Post();
            post.setId(doc.getInteger("id"));
            post.setTitle(doc.getString("title"));
            post.setContent(doc.getString("content"));
            post.setCreatedAt(doc.getDate("createdAt"));
            posts.add(post);
        }
        return posts;
    }

    @Override
    public boolean updatePost(int id, String newTitle, String newContent) {
        UpdateResult result = collection.updateOne(eq("id", id),
                combine(
                        set("title", newTitle),
                        set("content", newContent)
                ));
        return result.getMatchedCount() > 0;
    }

    @Override
    public boolean deletePost(int id) {
        DeleteResult result = collection.deleteOne(eq("id", id));
        return result.getDeletedCount() > 0;
    }

    @Override
    public boolean isPostIdExists(int id) {
        Document doc = collection.find(eq("id", id)).first();
        return doc != null;
    }
}

