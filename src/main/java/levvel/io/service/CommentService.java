package levvel.io.service;

import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(String id, Comment comment) throws BlogNotExistException;

    List<Comment> getComments(String id) throws BlogNotExistException;
}
