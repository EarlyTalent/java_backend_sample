package levvel.io.data;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

    List<Comment> findCommentsById(String id);

}
