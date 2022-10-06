package levvel.io.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import levvel.io.model.Comment;

// Why ? This extends the JpaRepository to create custom find method 
// to interact with Mongo Database and the find the blog via the String id 
// from List of Comments
public interface CommentRepository extends MongoRepository<Comment, String> {
	List<Comment> findByBlogId(String id);
}
