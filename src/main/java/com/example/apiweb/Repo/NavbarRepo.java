package com.example.apiweb.Repo;

import com.example.apiweb.Entity.NavbarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavbarRepo extends JpaRepository<NavbarEntity,Integer> {
}
