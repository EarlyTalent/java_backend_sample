package levvel.io.data;

import levvel.io.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query("{blogId :?0}")
    List<Comment> getCommentsByBlogId(String blogId);
}
