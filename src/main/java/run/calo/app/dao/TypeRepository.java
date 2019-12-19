package run.calo.app.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.repository.query.Param;
import run.calo.app.po.Tag;
import run.calo.app.po.Type;

public interface TypeRepository extends JpaRepository<Type,Long> {




    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

    @Query("select t from Type t where t.id = :id")
    Type findOne(@Param("id") Long id);
}
