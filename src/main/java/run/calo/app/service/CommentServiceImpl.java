package run.calo.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import run.calo.app.NotFoundException;
import run.calo.app.dao.CommentRepository;
import run.calo.app.po.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comment> listCommentBuBlogId(Long blogId) {

        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId,Sort.by(Sort.Direction.ASC,"createTime"));
        return eachComment(comments);
    }



    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1) {
            comment.setParentComment(commentRepository.findOne(parentCommentId));
        } else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    /**
     * Loop through each top-level comment node
     * @param comments
     * @return
     */

    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments){
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        combineChildren(commentsView);
        return commentsView;
    }
    /**
     *
     * @param comments Root root node, object collection where blog is not empty
     * @return
     */
    private void combineChildren(List<Comment> comments) {
        for (Comment comment : comments){
            List<Comment> replys1 = comment.getReplyComments();
            for (Comment reply1 : replys1) {
                recursively(reply1);
            }
            comment.setReplyComments(tempReplys);

            tempReplys = new ArrayList<>();
        }
    }

    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * Recursive iteration, peeling onions
     * @param comment The object being iterated
     * @return
     */
    private void recursively(Comment comment){
        tempReplys.add(comment);
        if(comment.getReplyComments().size()>0){
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply : replys){
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0){
                    recursively(reply);
                }
            }
        }
    }
}
