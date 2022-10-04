package levvel.io.controller;
import java.util.*; // This is necessary for an ArrayList.
import levvel.io.model.Blog;
import levvel.io.model.Blog.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;

    @PostMapping("/post")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);
        return ResponseEntity.ok().body(blog);
    }

    @PostMapping("/blog/post/{id}/comment")
    public ResponseEntity<Blog> addComment(@PathVariable String id, @RequestBody Comment comment)   {
        blogService.addComment(id,comment);
        return ResponseEntity.ok().body(blogService.getBlog(id));
    }

    @GetMapping("/blog/post/{id}/comment")
    public ResponseEntity<ArrayList<Comment>> getComment(@PathVariable String id) {
        return ResponseEntity.ok().body(blogService.getComments(id));
        
    }
}
