package levvel.io.service;

import levvel.io.data.CommentRepository;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public abstract class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    
    @Override
    public Comment getComment(String id) {
        return commentRepository.findById(id).orElseGet(null);
    }
    

}
