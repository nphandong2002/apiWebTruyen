package com.example.apiweb.Repo;

import com.example.apiweb.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,Integer> {
    RoleEntity findRoleEntityByName(String name);

}

