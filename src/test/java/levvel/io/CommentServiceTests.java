package levvel.io;

import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.CommentService;
import levvel.io.service.CommentServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public final class CommentServiceTests {
    @Mock
    private BlogRepository blogRepository;

    @Mock
    private CommentRepository commentRepository;

    private CommentService commentService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        commentService = new CommentServiceImpl(blogRepository, commentRepository);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    public void Should_AddCommentToPost_When_AddComment() {
        Blog blog = createTestBlog();
        Comment comment = createTestComment();
        List<Blog> mockBlogsList = new ArrayList<>(List.of(blog));

        Mockito.when(commentRepository.save(Mockito.any())).thenReturn(comment);
        prepareMockBlogRepository(mockBlogsList);

        commentService.addComment(blog, comment);

        assertEquals(1, mockBlogsList.size());
        assertEquals(1, mockBlogsList.get(0).getComments().size());
        assertEquals("comment123", mockBlogsList.get(0).getComments().get(0).getId());
    }

    @Test
    public void Should_GetCommentsFromPost_When_GetComments() throws BlogNotExistException {
        Blog blog = createTestBlog();
        Comment comment = createTestComment();
        blog.getComments().add(comment);

        List<Blog> mockBlogsList = new ArrayList<>(List.of(blog));
        prepareMockBlogRepository(mockBlogsList);

        List<Comment> comments = commentService.getComments(blog.getId());

        assertEquals(1, comments.size());
        assertEquals(comment.getText(), comments.get(0).getText());
    }

    @Test
    public void Should_Fail_When_GetComments_FromUnknownBlogId() {
        List<Blog> mockBlogsList = new ArrayList<>(List.of(createTestBlog()));
        prepareMockBlogRepository(mockBlogsList);

        assertThrows(BlogNotExistException.class, () -> commentService.getComments("unknownId123"));
    }

    private void prepareMockBlogRepository(List<Blog> mockBlogsList) {
        Mockito.when(blogRepository.save(Mockito.any())).thenAnswer(invocation -> {
            Blog blog = invocation.getArgument(0);
            if (mockBlogsList.size() > 0) {
                mockBlogsList.set(0, blog);
            } else {
                mockBlogsList.add(blog);
            }
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

    private Comment createTestComment() {
        Comment comment = new Comment();
        comment.setId("comment123");
        comment.setAuthor("Endava");
        comment.setText("Comment text");
        return comment;
    }
}
