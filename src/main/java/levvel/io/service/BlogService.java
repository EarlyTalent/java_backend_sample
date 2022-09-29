package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;

import java.util.Optional;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    //Adding methods to add comments and get comments by blog id
    void addComment(Comment comment);

    Comment getComment(String id);
}
