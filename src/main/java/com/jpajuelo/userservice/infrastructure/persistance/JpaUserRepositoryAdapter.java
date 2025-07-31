package com.jpajuelo.userservice.infrastructure.persistance;

import com.jpajuelo.userservice.application.port.out.UserRepositoryPort;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.domain.exception.UserNotFoundException;
import com.jpajuelo.userservice.infrastructure.persistance.mapper.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findUserById(Long idUser) {
        return userRepository.findByUserIdAndIsActivoIsTrue(idUser).map(UserPersistenceMapper::toDomain);
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUserById(Long idUser) {
        try{
        userRepository.deleteById(idUser);}
        catch(Exception e){
            throw new UserNotFoundException("El usuario no fue encontrado");
        }
    }
}
