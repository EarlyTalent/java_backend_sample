package levvel.io.service;

import levvel.io.model.*;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void addComment(Comment comment, String id);

    Comment[] getComments(String id);
}
