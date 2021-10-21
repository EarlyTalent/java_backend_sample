package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;

import java.util.List;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    List<Comment> allCommentsById (String id);

    void addCommentById(String id, Comment comment);

}
