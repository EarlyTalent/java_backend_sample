package levvel.io.service;

import java.util.*; // This is necessary for an ArrayList.

import levvel.io.model.Blog;
import levvel.io.model.Blog.Comment;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void addComment(String id, Comment comment);
    
    ArrayList<Comment> getComments(String id);
}
