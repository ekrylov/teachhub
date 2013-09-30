package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

	List<Assignment> findByContact(Contact contact);

	List<Assignment> findByUnitTask(UnitTask unitTask);

	List<Assignment> findByContactAndUnitTask(Contact contact, UnitTask unitTask);

	List<Assignment> findByContactAndUnitTaskUnit(Contact contact, Unit unit);

}
