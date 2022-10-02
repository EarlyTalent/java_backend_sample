package levvel.io;

import levvel.io.data.BlogRepository;
import levvel.io.exception.BlogNotExistException;
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

import static org.junit.jupiter.api.Assertions.*;

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
		prepareMockBlogRepository(mockBlogsList);

		Blog blog = createTestBlog();
		blogService.addBlog(blog);

		assertEquals(mockBlogsList.size(), 1);
		assertEquals(mockBlogsList.get(0).getId(), "123abc");
	}

	@Test
	public void Should_GetPostFromMockList_When_GetBlog() throws BlogNotExistException {
		List<Blog> mockBlogsList = new ArrayList<>(List.of(createTestBlog()));
		prepareMockBlogRepository(mockBlogsList);

		Blog blog = blogService.getBlog("123abc");

		assertNotNull(blog);
		assertEquals(blog.getAuthor(), "Levvel");
	}

	@Test
	public void Should_Fail_When_GettingBlogWithUnknownId() {
		List<Blog> mockBlogsList = new ArrayList<>(List.of(createTestBlog()));
		prepareMockBlogRepository(mockBlogsList);

		assertThrows(BlogNotExistException.class, () -> blogService.getBlog("diffId123"));
	}

	private void prepareMockBlogRepository(List<Blog> mockBlogsList) {
		Mockito.when(blogRepository.save(Mockito.any())).thenAnswer(invocation -> {
			Blog blog = invocation.getArgument(0);
			mockBlogsList.add(blog);
			return blog;
		});

		Mockito.when(blogRepository.findById(Mockito.any()))
				.thenAnswer(invocation -> mockBlogsList.stream()
						.filter(b -> b.getId().equals(invocation.getArgument(0)))
						.findFirst());
	}

	private Blog createTestBlog() {
		Blog blog = new Blog();
		blog.setId("123abc");
		blog.setAuthor("Levvel");
		blog.setText("Body text");
		return blog;
	}

}
