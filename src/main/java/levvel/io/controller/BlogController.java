package levvel.io.controller;

import levvel.io.model.Blog;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    @PostMapping("/post")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        var blog = new Blog();
        return ResponseEntity.ok().body(blog);
    }
}
