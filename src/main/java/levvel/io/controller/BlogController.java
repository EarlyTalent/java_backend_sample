package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // labels as the controller layer
@AllArgsConstructor // lombok annotation that gets rid of boiler plate code
@RequestMapping("/blog") // changes mapping to /blog
public class BlogController {

    private BlogService blogService; // service from BlogService

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
    public ResponseEntity<Blog> addComment(@PathVariable String id, @RequestBody Comment comment){
    	blogService.addComment(id, comment);
    	return ResponseEntity.ok().body(blogService.getBlog(id));
    }
    
    @GetMapping("post/{id}/comment")
    public ResponseEntity<Blog> getComments(@PathVariable String id){
    	blogService.getComments(id);
    	return ResponseEntity.ok().body(blogService.getBlog(id));
    }
}
