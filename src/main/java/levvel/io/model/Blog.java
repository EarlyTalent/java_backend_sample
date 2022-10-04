package levvel.io.model;

import java.util.*; // This is necessary for an ArrayList.
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.time.LocalDateTime;

@Data
public class Blog {

    @Id
    String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String author;
    String title;
    String text;

    // This is a dynamically allocated array for comments. It is an array comments, which each subarray being a comment.
    // https://www.geeksforgeeks.org/arraylist-in-java
    public static class Comment {
        public String comment;
        public String user;
        public Comment(String comment, String user){
            this.comment = comment;
            this.user = user;
        }
    }
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    // a method to add a comment to the comments array.
    public void addCommentToObject(String comment, String user){
        Comment comment_obj = new Comment(comment, user);
        this.comments.add(comment_obj);
    }

    // a method to return the comments array.
    public ArrayList<Comment> getCommentsFromObject(){
        return this.comments;
    }

}
