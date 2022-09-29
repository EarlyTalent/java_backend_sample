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
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;
    private CommentRepository commentRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    //Implementing add/getComment

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(String id) {
        Blog b = blogRepository.findById(id).orElseGet(null);
        return b.getComments();
    }
}
