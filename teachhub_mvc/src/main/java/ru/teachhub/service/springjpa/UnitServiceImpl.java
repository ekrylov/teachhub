package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.teachhub.domain.Unit;
import ru.teachhub.repository.UnitRepository;
import ru.teachhub.service.UnitService;

@Service("springJpaUnitService")
@Repository
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Unit> findAll() {
		return Lists.newArrayList(unitRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Unit> findByTitle(String title) {
		return unitRepository.findByTitle(title);
	}

}
