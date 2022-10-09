package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog); // saves blog into database
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    // my code here: 
    public void putComment(String id, Comment comment) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        blog.addComment(comment);
        blogRepository.save(blog);
    }

    public ArrayList<Comment> getComments(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        return blog.getAllComments();
    }
}
