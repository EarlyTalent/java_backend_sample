package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
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

    /*
        Adds a comment to a blog based on id and
        saves the blog to the database
    */
    @Override
    public void addComment(String id, Comment comment) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        if(blog != null){
            blog.comments.add(comment);
            blogRepository.save(blog);
        }
    }

    /*
        Gets all the comments for a given post based on id
    */
    @Override
    public Comment[] getComments(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        if(blog != null){
            return (Comment[])blog.comments.toArray();
        }
        else{
            return null;
        }
    }
}
