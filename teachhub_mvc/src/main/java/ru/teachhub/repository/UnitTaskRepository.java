package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;

public interface UnitTaskRepository extends CrudRepository<UnitTask, Long> {

	List<UnitTask> findByUnit(Unit unit);

}
