package org.scoula.mongo.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.scoula.mongo.bean.Post;
import org.scoula.mongo.dao.PostDAO;
import org.scoula.mongo.dao.PostDAOImpl;
import org.scoula.mongo.service.PostService;
import org.scoula.mongo.service.PostServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ConsoleBoardApp {
    private static PostService postService;

    public static void main(String[] args) {
        // MongoDB 클라이언트 및 데이터베이스 연결
        MongoDatabase database = connectToDatabase("mongodb://localhost:27017", "boarddb");

        // DAO 및 서비스 초기화
        PostDAO postDAO = new PostDAOImpl(database);
        postService = new PostServiceImpl(postDAO);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nConsole Board Application");
            System.out.println("1. Create Post");
            System.out.println("2. Read Posts");
            System.out.println("3. Update Post");
            System.out.println("4. Delete Post");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createPost(scanner);
                    break;
                case 2:
                    readPosts();
                    break;
                case 3:
                    updatePost(scanner);
                    break;
                case 4:
                    deletePost(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static MongoDatabase connectToDatabase(String connectionString, String databaseName) {
        MongoClient mongoClient = MongoClients.create(connectionString);
        return mongoClient.getDatabase(databaseName);
    }

    private static void createPost(Scanner scanner) {
        System.out.print("Enter post ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        postService.createPost(id, title, content);
    }

    private static void readPosts() {
        List<Post> posts = postService.readPosts();
        for (Post post : posts) {
            System.out.println("\nPost ID: " + post.getId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Content: " + post.getContent());
            System.out.println("Created At: " + post.getCreatedAt());
        }
    }

    private static void updatePost(Scanner scanner) {
        System.out.print("Enter post ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new content: ");
        String newContent = scanner.nextLine();

        boolean updated = postService.updatePost(id, newTitle, newContent);
        if (updated) {
            System.out.println("Post updated successfully");
        } else {
            System.out.println("Post not found");
        }
    }

    private static void deletePost(Scanner scanner) {
        System.out.print("Enter post ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean deleted = postService.deletePost(id);
        if (deleted) {
            System.out.println("Post deleted successfully");
        } else {
            System.out.println("Post not found");
        }
    }
}
