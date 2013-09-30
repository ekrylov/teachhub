package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;
import ru.teachhub.repository.UnitTaskRepository;
import ru.teachhub.service.UnitTaskService;

@Service("springJpaUnitTaskService")
@Repository
@Transactional
public class UnitTaskServiceImpl implements UnitTaskService {

	@Autowired
	private UnitTaskRepository unitTaskRepository;

	@Override
	@Transactional(readOnly = true)
	public List<UnitTask> findByUnit(Unit unit) {
		return unitTaskRepository.findByUnit(unit);
	}

}
