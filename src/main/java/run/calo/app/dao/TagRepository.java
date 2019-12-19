package run.calo.app.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import run.calo.app.po.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

    @Query("select t from Tag t where t.id = :id")
    Tag findOne(@Param("id") Long id);

}
