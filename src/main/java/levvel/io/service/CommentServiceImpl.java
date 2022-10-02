package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
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
    public void addComment(Blog blog, Comment comment) {
        Comment commentSaved = commentRepository.save(comment);

        blog.getComments().add(commentSaved);
        blogRepository.save(blog);
    }

    @Override
    public List<Comment> getComments(String id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            throw new RuntimeException("The blog ID provided does not exist.");
        }
        return blog.getComments();
    }
}
