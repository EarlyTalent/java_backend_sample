package levvel.io.controller;

import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import levvel.io.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class CommentController {

    private BlogService blogService;
    private CommentService commentService;

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Blog> addComment(@PathVariable String id, @RequestBody Comment comment) {
        try {
            Blog blog = blogService.getBlog(id);
            commentService.addComment(blog, comment);
            return ResponseEntity.ok().body(blog);
        } catch (BlogNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List<Comment>> getComments(@PathVariable String id) {
        try {
            List<Comment> comments = commentService.getComments(id);
            return ResponseEntity.ok().body(comments);
        } catch (BlogNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
