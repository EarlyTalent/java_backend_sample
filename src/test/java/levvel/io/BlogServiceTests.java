package levvel.io;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.service.BlogService;
import levvel.io.service.BlogServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BlogServiceTests {

	@Mock
	private BlogRepository blogRepository;

	private BlogService blogService;

	private AutoCloseable closeable;

	@BeforeEach
	public void setup() {
		closeable = MockitoAnnotations.openMocks(this);
		blogService = new BlogServiceImpl(blogRepository);
	}

	@AfterEach
	void closeService() throws Exception {
		closeable.close();
	}

	@Test
	public void Should_AddPostToMockList_When_AddBlog() {
		List<Blog> mockBlogsList = new ArrayList<>();
		Mockito.when(blogRepository.save(Mockito.any())).thenAnswer(invocation -> {
			Blog blog = invocation.getArgument(0);
			mockBlogsList.add(blog);
			return blog;
		});

		Blog blog = createTestBlog();
		blogService.addBlog(blog);

		assertEquals(mockBlogsList.size(), 1);
		assertEquals(mockBlogsList.get(0).getId(), "123abc");
	}

	private Blog createTestBlog() {
		Blog blog = new Blog();
		blog.setId("123abc");
		blog.setAuthor("Levvel");
		blog.setText("Body text");
		return blog;
	}

}
