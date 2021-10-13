package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/blog/post/{id}/comment")
    public ResponseEntity<List> getAllBlogCommentsById(@PathVariable String id) {
        List comments = blogService.getComments(id);
        return ResponseEntity.ok().body(comments);
    }

    @PostMapping("/blog/post/{id}/comment")
    public ResponseEntity<Comment> createCommentForPostById(@PathVariable String id, @RequestBody Comment comment) {
        blogService.addComment(id, comment);
        return ResponseEntity.ok().body(comment);
    }

}
