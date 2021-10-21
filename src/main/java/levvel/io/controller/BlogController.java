package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import levvel.io.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    private final CommentService commentService;

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
    public ResponseEntity<Comment> addComment(@PathVariable String id, @RequestBody Comment comment) {
        Comment savedComment = commentService.createComment(comment);
        blogService.addCommentById(id, savedComment);
        return ResponseEntity.ok().body(savedComment);
    }

    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List<Comment>> getComments(@PathVariable String id) {
        List<Comment> comments = blogService.allCommentsById(id);
        return ResponseEntity.ok().body(comments);
    }

}
