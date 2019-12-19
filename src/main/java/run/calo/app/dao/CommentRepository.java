package run.calo.app.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import run.calo.app.po.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long id, Sort sort);

    @Query("select b from Comment b where b.id = :id")
    Comment findOne(@Param("id") Long id);
}
