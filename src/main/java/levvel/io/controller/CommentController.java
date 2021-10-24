package levvel.io.controller;

import levvel.io.model.Comment;
import levvel.io.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog/post{id}")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/blog/post{id}/comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResponseEntity.ok().body(comment);
    }
    

    @GetMapping("/blog/post{id}/comment")
    public ResponseEntity<Comment> getComment(@PathVariable String id) {
        Comment comment = commentService.getComment(id);
        return ResponseEntity.ok().body(comment);
    }
    
}

