package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;

import java.util.List;

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
	public List<Comment> getComments(String id) {
		return getBlog(id).getComment();
	}

	@Override
	public void addComment(String id, Comment comment) {
		Blog current = getBlog(id);
		current.addToComments(comment);
		blogRepository.save(current);
	}
   
}
