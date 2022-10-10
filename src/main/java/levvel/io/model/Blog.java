package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.List;
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

    List<Comment> comments= new ArrayList<Comment>();
    
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    ArrayList<String> output = new ArrayList<>();
    
    public List<String> getOutputFromBlog() {
        for (Comment comment : comments)
        {
            output.add("Author: " + comment.author + " " +  "Comment: " + comment.text);
        }
        return output;
    }

    

}
