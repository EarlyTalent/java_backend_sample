package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;

import java.util.List;

public interface BlogService {

    void addBlog(Blog blog);
    void addComment(String id, Comment comment);
    List<Comment> getComments(String id);
    Blog getBlog(String id);
}
