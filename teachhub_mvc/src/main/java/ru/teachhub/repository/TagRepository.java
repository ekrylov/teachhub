package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findByTitle(String title);

}
