package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private BlogRepository blogRepository;

    private CommentRepository commentRepository;

    @Override
    public void addComment(String id, Comment comment) throws BlogNotExistException {
        Blog blog = blogRepository.findById(id).orElseThrow(BlogNotExistException::new);

        Comment commentSaved = commentRepository.save(comment);

        blog.getComments().add(commentSaved);
        blogRepository.save(blog);
    }

    @Override
    public List<Comment> getComments(String id) throws BlogNotExistException {
        Blog blog = blogRepository.findById(id).orElseThrow(BlogNotExistException::new);
        return blog.getComments();
    }
}
