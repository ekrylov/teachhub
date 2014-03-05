package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

    List<Assignment> findByStudent(Contact student);

    List<Assignment> findByUnitTask(UnitTask unitTask);

    List<Assignment> findByStudentAndUnitTask(Contact student, UnitTask unitTask);

    List<Assignment> findByStudentAndUnitTaskUnit(Contact student, Unit unit);

    Assignment findByStudentAndId(Contact student, Long id);

}
