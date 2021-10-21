package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<Comment> allCommentsById(String id) {
        return blogRepository.findCommentsById(id);
    }

    @Override
    public void addCommentById(String id, Comment comment) {

        Blog blog = blogRepository.findById(id).orElseGet(null);

        if (blog != null) {
            blog.addComment(comment);
            blogRepository.save(blog);
        }
    }


}
