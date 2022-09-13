package com.example.apiweb.Repo;

import com.example.apiweb.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity,Integer> {
    BookEntity findBookEntityById(int id);

    List<BookEntity> findBookEntitiesByAuthorId(int id);

    List<BookEntity> findBookEntitiesByCategoryId(int id);

    @Query(value = "SELECT f.* FROM (SELECT * FROM book WHERE book.id in (SELECT id FROM `book` ORDER BY user_id DESC)) f LIMIT 5 ;",nativeQuery = true)
    List<BookEntity> getBookTop();
}
