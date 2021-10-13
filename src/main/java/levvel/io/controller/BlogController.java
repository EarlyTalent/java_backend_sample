package levvel.io.controller;

import levvel.io.model.*;
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

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, String id) {
        blogService.addComment(comment, id);
        return ResponseEntity.ok().body(comment);
    }

    @GetMapping("/blog/post/{id}/comment")
    public ResponseEntity<Comment[]> getComments(@PathVariable String id) {
        Comment[] comments = blogService.getComments(id);
        return ResponseEntity.ok().body(comments);
    }
}
