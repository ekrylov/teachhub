package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;
import ru.teachhub.repository.AssignmentRepository;
import ru.teachhub.service.AssignmentService;

@Service("springJpaAssignmentService")
@Repository
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Assignment> findByContact(Contact contact) {
        return assignmentRepository.findByStudent(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assignment> findByUnitTask(UnitTask unitTask) {
        return assignmentRepository.findByUnitTask(unitTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assignment> findByContactAndUnitTask(Contact contact, UnitTask unitTask) {
        return assignmentRepository.findByStudentAndUnitTask(contact, unitTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assignment> findByContactAndUnitTaskUnit(Contact contact, Unit unit) {
        return assignmentRepository.findByStudentAndUnitTaskUnit(contact, unit);
    }

    @Override
    @Transactional(readOnly = true)
    public Assignment findById(Long id) {
        return assignmentRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Assignment findByContactAndId(Contact contact, Long id) {
        return assignmentRepository.findByStudentAndId(contact, id);
    }

    @Override
    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

}
