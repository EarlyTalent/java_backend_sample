package levvel.io;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

@SpringBootTest
class WorkSampleApplicationTests {

	@Autowired
	private BlogService blogService;


	@Test
	void test1() {
		Blog blog = new Blog();
		blog.setAuthor("Author 1");
		blog.setTitle("Title 1");
		blog.setText("Text 1");
		blog.setId("1");

		blogService.addBlog(blog);
		assert(blogService.getBlog("1").equals(blog));
		assertNull(blogService.getComments("1"));
	}
	@Test
	void test2() {
		Blog blog = new Blog();
		blog.setAuthor("Author 2");
		blog.setTitle("Title 2");
		blog.setText("Text 2");
		blog.setId("2");

		blogService.addBlog(blog);

		List<Comment> comments = new ArrayList<>();

		for(int i = 0; i<10; i++){
			Comment comment = new Comment();
			comment.setAuthor("Author " + i);
			comment.setText("Text " + i);
			comment.setId(Integer.toString(i));
			blogService.addComment(comment, "2");
			comments.add(comment);
		}

		assert(blogService.getComments("2").equals(comments));

	}
	@Test
	void test3() {
		assertNull(blogService.getBlog("3"));
	}

}
