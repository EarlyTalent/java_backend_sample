package levvel.io.service;
//import levvel.io.data.CommentRepository;
import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import levvel.io.model.Comment;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;
    //private CommentRepository commentRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    //@Override
    public void addComment(String id, Comment comment){
        Blog blog = blogRepository.findById(id).orElseGet(null);
        blog.addComment(comment);
        blogRepository.save(blog);//saves newly added comment to blog in mongo
    }

    //@Override
    public List<String> getComment(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        return blog.getOutputFromBlog();//gets list of comments from blog
    }
}
