package levvel.io.service;

import java.util.ArrayList;
import levvel.io.model.Blog;
import levvel.io.model.Comment;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void putComment(String id, Comment comment);

    ArrayList<Comment> getComments(String id);
}
