package levvel.io.controller;

import levvel.io.exception.BlogNotExistException;
import levvel.io.model.Comment;
import levvel.io.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable String id, @RequestBody Comment comment) {
        try {
            commentService.addComment(id, comment);
            return ResponseEntity.ok().body(comment);
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
