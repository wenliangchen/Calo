package run.calo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import run.calo.app.po.Type;

import java.util.List;
import java.util.Optional;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
