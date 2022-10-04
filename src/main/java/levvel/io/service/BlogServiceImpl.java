package levvel.io.service;

import java.util.*; // This is necessary for an ArrayList.
import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Blog.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    @Override
    public void addComment(String id, Comment comment) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        blog.addCommentToObject(comment.comment, comment.user);
        blogRepository.save(blog);
        return;
    }

    @Override
    public ArrayList<Comment> getComments(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        return blog.getCommentsFromObject();
    }
}
