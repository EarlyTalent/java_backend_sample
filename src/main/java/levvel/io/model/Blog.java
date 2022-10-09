package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.ArrayList;

import java.time.LocalDateTime;

@Data
public class Blog {

    @Id
    String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String author;
    String title;
    String text;
    
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getAllComments() {
        return comments;
    }
    // array list of comments to store comments
    ArrayList<Comment> comments= new ArrayList<Comment>();
}

