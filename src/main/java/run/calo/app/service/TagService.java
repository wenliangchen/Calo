package run.calo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import run.calo.app.po.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String id);

    List<Tag> listTagTop(Integer size);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
