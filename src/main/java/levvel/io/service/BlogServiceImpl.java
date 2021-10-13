package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    /**
     * This adds the comment to the blog specified by id
     * @param id blog post id
     * @param comment comment to add
     */
    @Override
    public void addComment(String id, Comment comment){
        Blog blog = blogRepository.findById(id).orElseGet(null);
        if (blog != null){
            if (blog.getCommentList() == null){
                blog.setCommentList(new ArrayList<>());
            }
            List<Comment> comm = blog.getCommentList();
            comm.add(comment);
            blog.setCommentList(comm);
            blogRepository.save(blog);
        }
    }
    /**
     * This method retrieves the blog by id, returns all comments for said blog
     * @param id blog post id
     */
    @Override
    public List<Comment> getComments(String id){
        Blog blog = blogRepository.findById(id).orElseGet(null);
        return blog != null ? blog.getCommentList() : null;

    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }
}
