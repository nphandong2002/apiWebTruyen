package com.example.apiweb.Repo;

import com.example.apiweb.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {
    CategoryEntity findCategoryEntityById(int id);
}
