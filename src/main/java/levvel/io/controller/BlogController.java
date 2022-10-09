package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.service.BlogService;
import levvel.io.model.Comment;
import java.util.ArrayList;
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

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> putComment(@PathVariable String id, @RequestBody Comment comment) {
        blogService.putComment(id, comment);
        return ResponseEntity.ok().body(comment);
    }

    @GetMapping("/post/{id}/comment") 
    public ResponseEntity<ArrayList<Comment>> getComments(@PathVariable String id) {
        ArrayList<Comment> comment = blogService.getComments(id);
        return ResponseEntity.ok().body(comment);
    }
}
