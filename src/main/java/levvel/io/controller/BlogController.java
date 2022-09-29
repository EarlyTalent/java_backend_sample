package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //Mapping the comments for posting and getting
    @PostMapping("/post/{id}/comment")
    //Creating a comment at the location of a specific blog id
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable String id) {
        //Creating a copy of specific blog in memory
        Blog b = blogService.getBlog(id);
        //Make a list of type Comment, if the blog has comments already, use those, otherwise create an empty List
        List<Comment> comments = b.getComments() == null ? new ArrayList<Comment>() : b.getComments();
        comments.add(comment);
        b.setComments(comments);
        //Upsert
        blogService.addBlog(b);
        return ResponseEntity.ok().body(comment);
    }

    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List<Comment>> getComment(@PathVariable String id) {
        List<Comment> comments = blogService.getComments(id);
        return ResponseEntity.ok().body(comments);
    }
}
