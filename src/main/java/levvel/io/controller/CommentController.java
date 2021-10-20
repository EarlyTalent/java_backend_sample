package levvel.io.controller;

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

    private CommentService commentService;

    @PostMapping("/post/{blogId}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable String blogId, @RequestBody Comment comment ) {
        commentService.addComment(blogId, comment);
        return ResponseEntity.ok().body(comment);
    }

    @GetMapping("/post/{blogId}/comment")
    public ResponseEntity< List<Comment> > getComments(@PathVariable String blogId) {
        List<Comment> comments = commentService.getComments(blogId);
        return ResponseEntity.ok().body(comments);
    }
}
