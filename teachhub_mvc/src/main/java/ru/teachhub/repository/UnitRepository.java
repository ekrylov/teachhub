package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Unit;

public interface UnitRepository extends CrudRepository<Unit, Long> {
	
	List<Unit> findByTitle(String title);

}
