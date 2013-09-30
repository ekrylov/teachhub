package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;

public interface UnitTaskService {

	List<UnitTask> findByUnit(Unit unit);

}
