package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class Comment {

    @Id
    String post_id; 

    @CreatedDate
    private LocalDateTime createdData; 

    @LastModifiedDate 
    private LocalDateTime lastModifiedDate;

    String author;
    String text;
}
