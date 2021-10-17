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

	@Override
	public void addComment(Comment comment, String id) {
		Blog blog = blogRepository.findById(id).orElseGet(null);
        blog.comments.add(comment);
        blogRepository.save(blog);
	}

	@Override
	public Comment[] getComments(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        return (Comment[])blog.comments.toArray();
	}
}

