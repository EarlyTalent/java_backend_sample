package levvel.io.service;

import levvel.io.model.Blog;
import levvel.io.model.Comment;

public interface CommentService {

    void addComment(Blog blog, Comment comment);
}
