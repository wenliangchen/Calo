package run.calo.app.service;

import run.calo.app.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentBuBlogId(Long id);

    Comment saveComment(Comment comment);

}
