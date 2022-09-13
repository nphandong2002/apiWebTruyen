package com.example.apiweb.Repo;

import com.example.apiweb.Entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<ImageEntity,Integer> {
    List<ImageEntity> findImageEntitiesByFkIdAndType(int id, String type);
}
