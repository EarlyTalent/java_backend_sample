package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;

import java.util.List;

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


    //create a new comment for a post with passed {id}
    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> addBlogComment(@PathVariable String id, @RequestBody Comment comment) {
        //Blog blog = blogService.getBlog(id);

        blogService.addBlogComment(id, comment);
        return ResponseEntity.ok().body(comment);

    }

    //which should return all comments for a post with passed {id}
    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List<Comment>> getBlogComments(@PathVariable String id) {
        List<Comment> comments = blogService.getBlogComments(id); //not sure
        return ResponseEntity.ok().body(comments);
/*
        List<Comment> comments = CommentRepository.findAllByPostId(id);
        if (comments != null) {
            //System.out.println("This method called successfully!");
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        */
    }
}
