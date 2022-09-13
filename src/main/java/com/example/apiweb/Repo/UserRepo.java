package com.example.apiweb.Repo;

import com.example.apiweb.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsername(String username);

    UserEntity findUserEntityById(int id);
}
