package dev.api.api.service;
import lombok.AllArgsConstructor;
import dev.api.api.entity.UserEntity;
import dev.api.api.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class ImpUserService implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }
    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<UserEntity> getAllUsers() {

        return userRepository.findAll();
    }
}