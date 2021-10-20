package levvel.io.service;

import levvel.io.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(String blogId, Comment comment);

    List<Comment> getComments(String blogId);

}
