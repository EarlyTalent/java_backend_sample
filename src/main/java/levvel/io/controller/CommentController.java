package levvel.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import levvel.io.data.BlogRepository;
import levvel.io.data.CommentRepository;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class CommentController {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired //	Why ? Tells the application context to inject an instance of commentRepository
	private CommentRepository commentRepository;
	
	// Why ? Get request mapping method needed for API requests used for retrieving comments by blog id
	@GetMapping("/post/{id}/comment")
	  public ResponseEntity<List<Comment>> getAllCommentsByBlogId(@PathVariable String id) {
	    if (!blogRepository.existsById(id)) {
	    	System.out.println("Error, Blog with id # " + id + " not found." );
	    }

	    List <Comment> comments = commentRepository.findByBlogId(id);
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }
	// Why ? Post request mapping method needed needed for API requests used for creating comments 	
	@PostMapping("/post/{id}/comment")
	  public ResponseEntity<Comment> createComment(@PathVariable String id,
	      @RequestBody Comment commentRequest) {
		// Why ? Comment entity needs blog to be mapped and set in order to connect the two tables together		
	    Comment comment = blogRepository.findById(id).map(blog -> {
	      commentRequest.setBlog(blog);
	      return commentRepository.save(commentRequest);
	    }).orElseThrow();

	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
	  }
	
}
