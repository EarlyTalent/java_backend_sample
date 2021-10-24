package levvel.io.service;

import levvel.io.model.Comment;

public interface CommentService {

    void addComment(Comment comment);
   

	Comment getComment(String id);

}
