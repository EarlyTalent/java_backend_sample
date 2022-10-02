package levvel.io.service;

import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Blog;
import levvel.io.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Blog blog, Comment comment);

    List<Comment> getComments(String id) throws BlogNotExistException;
}
