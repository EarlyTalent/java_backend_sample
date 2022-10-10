package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import java.util.List;

public interface BlogService {

    void addBlog(Blog blog);
    Blog getBlog(String id);

    void addComment(String id, Comment comment);//ads comment to blog id
    List<String> getComment(String id);//gets all comments for blog id
}
