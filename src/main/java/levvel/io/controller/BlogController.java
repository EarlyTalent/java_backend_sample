package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
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

    /* 
        Post request - creates a new comment for a post with passed {id}
        Post at /blog/post/{1}/comment
    */
    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable String id, @RequestBody Comment comment) {
        blogService.addComment(id, comment);
        return ResponseEntity.ok().body(comment);
    }

    /*
        Get Request - gets all the comments at the post with passed {id}
        Get at /blog/post/{1}/comment
    */
    @GetMapping("/post/{id}/comment")
    public ResponseEntity<Comment[]> getComments(@PathVariable String id) {
        Comment[] comments = blogService.getComments(id);
        return ResponseEntity.ok().body(comments);
    }
}
