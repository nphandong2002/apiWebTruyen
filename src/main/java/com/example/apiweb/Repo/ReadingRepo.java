package com.example.apiweb.Repo;

import com.example.apiweb.Entity.ReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepo extends JpaRepository<ReadingEntity,Integer> {
}
