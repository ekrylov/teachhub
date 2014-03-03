package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;

public interface AssignmentService {

    List<Assignment> findByContact(Contact contact);

    List<Assignment> findByUnitTask(UnitTask unitTask);

    List<Assignment> findByContactAndUnitTask(Contact contact, UnitTask unitTask);

    List<Assignment> findByContactAndUnitTaskUnit(Contact contact, Unit unit);

    Assignment findById(Long id);
    
    Assignment findByContactAndId(Contact contact, Long id);
    
    Assignment save(Assignment assignment);

}
