package levvel.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import levvel.io.model.Blog; // import blog so it can be tested
import levvel.io.model.Blog.Comment;
import java.util.*; // This is necessary for an ArrayList.

@SpringBootTest
class WorkSampleApplicationTests {

	@Test
	@Order(1)
	void contextLoads() {

	}
	
	@Test
	@DisplayName("testGetCommentAndAddCommentOfObject")
	@Order(2)
	// This tests the Blog class functions that I implemented.
	void testGetCommentAndAddComment(){
		Blog blog = new Blog();
		ArrayList<Comment> correctComment = new ArrayList<Blog.Comment>();
		// check to make sure empty comment ArrayList works.
		assertEquals(blog.getComments(),correctComment);
		assertEquals(blog.getComments().size(),correctComment.size());
		// add a comment see if it works
		Blog.Comment comment = new Comment("This is a comment.","This is the post id.");
		blog.addCommentToObject("This is a comment.", "This is the post id.");
		correctComment.add(comment);
		// assert the two ArrayLists and Comments are correct
		assertEquals(correctComment.size(), blog.getComments().size());
		assertEquals(correctComment.get(0).comment, blog.getComments().get(0).comment);
		assertEquals(correctComment.get(0).user, blog.getComments().get(0).user);
	}

}
