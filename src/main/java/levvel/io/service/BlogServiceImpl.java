package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.*;
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
    public void addComment(Comment comment, String id){
        Blog blog = getBlog(id);
        blog.comments.add(comment);
    }

    @Override
    public Comment[] getComments(String id){
        Blog blog = getBlog(id);
        return (Comment[])blog.comments.toArray();
    }
}
