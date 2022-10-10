package levvel.io;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import java.util.*; 

@SpringBootTest
class WorkSampleApplicationTests {

	@Test
	@DisplayName("EmptyCommentTest")
	void emptyCommentTest(){
		Blog b = new Blog();
		ArrayList<String> comment = new ArrayList<>();
		assertEquals(b.getOutputFromBlog(),comment);
		assertEquals(b.getComments().size(),comment.size());
	}


}
