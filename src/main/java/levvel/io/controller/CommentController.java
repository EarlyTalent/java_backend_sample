package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import levvel.io.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class CommentController {

    private BlogService blogService;
    private CommentService commentService;

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Blog> addBlog(@PathVariable String id, @RequestBody Comment comment) {
        Blog blog = blogService.getBlog(id);
        commentService.addComment(blog, comment);
        return ResponseEntity.ok().body(blog);
    }
}
