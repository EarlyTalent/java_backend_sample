package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.data.CommentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

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


    @Override
    public void addBlogComment(String id, Comment comment) {
        //blog.comment = commentRepository.save(comment);
        //Blog blog = getBlog(id);
        if (id != null) {
            commentRepository.save(comment);
            //blogRepository.getCommentList(blog).add(comment);
            //blogRepository.save(blog);
            //return new ResponseEntity<>(HttpStatus.CREATED);
        }
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public List<Comment> getBlogComments(String id) {
        return commentRepository.findAll(id);
    }

    @Override
    public List<Comment> findAll() {
        // TODO Auto-generated method stub
        return commentRepository.findAll();
    }

   

}
