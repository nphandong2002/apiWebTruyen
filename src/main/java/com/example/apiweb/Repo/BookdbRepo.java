package com.example.apiweb.Repo;

import com.example.apiweb.Entity.BookdetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookdbRepo extends JpaRepository<BookdetailsEntity,Integer> {
    List<BookdetailsEntity> findBookdetailsEntitiesByBookId(int id);

    BookdetailsEntity findBookdetailsEntityById(int id);
    @Query(value = "select f.* from (SELECT * FROM `bookdetails` ORDER BY bookdetails.id DESC) f limit 5;",nativeQuery = true)
    List<BookdetailsEntity> findChaperNew();


}
