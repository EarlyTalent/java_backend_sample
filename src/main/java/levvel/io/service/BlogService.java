package levvel.io.service;

import java.util.List;

import levvel.io.model.Blog;
import levvel.io.model.Comment;


public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void addBlogComment(String id, Comment comment);

    List<Comment> getBlogComments(String id); //might be wrong, how do we get comment body?

    List <Comment> findAll();
    

}
