package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Blog {
	
	// @Id marks the String id as a primary key for the db

    @Id
    String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String author;
    String title;
    String text;
    List<Comment> comments; // each blog has comments associated with it
    
    public void addToComments(Comment comment) {
    	comments.add(comment); // add a comment to the list
    }
    
    public List<Comment> getComment(){
    	return comments;
    }
}
