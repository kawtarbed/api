package dev.api.api.service;

import dev.api.api.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserEntity getUser(Long id);
    public UserEntity addUser(UserEntity user);
    public UserEntity updateUser(UserEntity user);
    public void deleteById(Long id);
    public List<UserEntity> getAllUsers();


}