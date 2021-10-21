package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import lombok.AllArgsConstructor;

import java.util.List;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import levvel.io.model.Comment;

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
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void addComment(Comment comment, String id){
        Blog blog = getBlog(id);
        if(blog != null){
            if(blog.getCommentsList()==null){
                blog.setCommentsList(new ArrayList<Comment>());
            }
            blog.getCommentsList().add(comment);
            blogRepository.save(blog);
        }
    }

    @Override
    public List<Comment> getComments(String id){
        Blog blog = getBlog(id);
        if(blog != null){
            return blog.getCommentsList();
        }
        return null;
    }
}
