package com.jpajuelo.userservice.infrastructure.persistance.adapter;

import com.jpajuelo.userservice.application.port.out.RoleRepositoryPort;
import com.jpajuelo.userservice.domain.model.Role;
import com.jpajuelo.userservice.infrastructure.persistance.mapper.RolePersistenceMapper;
import com.jpajuelo.userservice.infrastructure.persistance.repository.SpringDataRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort {

    private SpringDataRoleRepository roleRepository;
    @Autowired
    public JpaRoleRepositoryAdapter(SpringDataRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name).map(RolePersistenceMapper::toDomain);
    }
}
