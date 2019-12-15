package run.calo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import run.calo.app.po.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);


}
