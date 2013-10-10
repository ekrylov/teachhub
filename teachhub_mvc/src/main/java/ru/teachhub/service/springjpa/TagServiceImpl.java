package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.teachhub.domain.Tag;
import ru.teachhub.repository.TagRepository;
import ru.teachhub.service.TagService;

@Service("springJpaTagService")
@Repository
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tag> findAll() {
        return Lists.newArrayList(tagRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tag> findByTitle(String title) {
        return tagRepository.findByTitle(title);
    }

}
