package levvel.io.model;

import org.springframework.data.mongodb.core.mapping.Document;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.ManyToOne;
import lombok.Data;

//Why? Used as base template to create comment entity
@Data 
@Document(collection="comment")
public class Comment {
	
	String author;
    String text;
    
    //Why ? Creates the ManytoOne Relationship with Blog  
    @ManyToOne(fetch = FetchType.EAGER)
    private Blog blog;

}
