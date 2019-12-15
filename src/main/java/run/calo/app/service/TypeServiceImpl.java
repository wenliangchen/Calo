package run.calo.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import run.calo.app.NotFoundException;
import run.calo.app.dao.TypeRepository;
import run.calo.app.po.Type;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Optional<Type> getType(Long id) {
        return typeRepository.findById(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return null;
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        return null;
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
       Optional<Type> t = typeRepository.findById(id);
        if (t == null){
            throw new NotFoundException("Not found the Type in Database");
        }
        BeanUtils.copyProperties(type,t);

        return typeRepository.save(type);
//        return null;
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
