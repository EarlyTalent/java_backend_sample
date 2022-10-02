package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Blog;
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
    public Blog getBlog(String id) throws BlogNotExistException {
        return blogRepository.findById(id).orElseThrow(BlogNotExistException::new);
    }
}
