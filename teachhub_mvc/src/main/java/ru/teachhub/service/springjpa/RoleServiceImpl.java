package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.teachhub.domain.Role;
import ru.teachhub.repository.RoleRepository;
import ru.teachhub.service.RoleService;

@Service( "springJpaRoleService" )
@Repository
@Transactional
public class RoleServiceImpl
    implements RoleService
{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional( readOnly = true )
    public List<Role> findAll()
    {
        return Lists.newArrayList( roleRepository.findAll() );
    }

    @Override
    @Transactional( readOnly = true )
    public List<Role> findByTitle( String title )
    {
        return roleRepository.findByTitle( title );
    }

}
