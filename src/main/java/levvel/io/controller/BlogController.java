package levvel.io.controller;

import levvel.io.model.Blog;
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
    @PostMapping("post/{1}/comment")
    public ResponseEntity<Blog> addComment(@RequestBody Blog comment) {
        blogService.addComment(comment);
        return ResponseEntity.ok().body(comment);
    }

    @GetMapping("post/{1}/comment")
    public ResponseEntity<Blog> getComment(@PathVariable String id) {
        Blog comment = blogService.getComment(id);
        return ResponseEntity.ok().body(comment);
    }
}
