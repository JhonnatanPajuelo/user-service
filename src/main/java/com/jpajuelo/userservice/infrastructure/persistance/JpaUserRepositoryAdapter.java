package com.jpajuelo.userservice.infrastructure.persistance;

import com.jpajuelo.userservice.application.port.out.UserRepositoryPort;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.persistance.mapper.UserPersistenceMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private SpringDataUserRepository userRepository;
    @Autowired
    public JpaUserRepositoryAdapter(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity= UserPersistenceMapper.toEntity(user);
        userRepository.save(userEntity);
        return UserPersistenceMapper.toDomain(userEntity);
    }

    @Override
    public User findUserById(Long idUser) {
        return userRepository.findByUserIdAndIsActivoIsTrue(idUser).map(UserPersistenceMapper::toDomain).orElseThrow(()-> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUserById(Long idUser) {

    }
}
