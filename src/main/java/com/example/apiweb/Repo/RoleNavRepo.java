package com.example.apiweb.Repo;

import com.example.apiweb.Entity.RoleNavabarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleNavRepo extends JpaRepository<RoleNavabarEntity,Integer> {
}
