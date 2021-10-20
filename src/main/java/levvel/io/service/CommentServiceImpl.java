package levvel.io.service;

import levvel.io.data.CommentRepository;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Override
    public void addComment(String blogId, Comment comment) { commentRepository.save(comment); }

    @Override
    public List<Comment> getComments(String blogId) {
        return commentRepository.getCommentsByBlogId(blogId);
    }
}
