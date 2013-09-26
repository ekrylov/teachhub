package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.teachhub.domain.Group;
import ru.teachhub.repository.GroupRepository;
import ru.teachhub.service.GroupService;

@Service("springJpaGroupService")
@Repository
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Group> findAll() {
		return Lists.newArrayList(groupRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Group> findByTitle(String title) {
		return groupRepository.findByTitle(title);
	}

}
