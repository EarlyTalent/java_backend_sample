package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void addComment(String id, Comment comment);

    Comment[] getComments(String id);
}
