package com.example.apiweb.Service;

import com.example.apiweb.Entity.BookEntity;
import com.example.apiweb.Entity.BookdetailsEntity;
import com.example.apiweb.Entity.CategoryEntity;
import com.example.apiweb.Repo.BookRepo;
import com.example.apiweb.Repo.BookdbRepo;
import com.example.apiweb.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookdbRepo bookdbRepo;

    @Autowired
    CategoryRepo categoryRepo;



    public void createCategory(CategoryEntity c){
        categoryRepo.save(c);
    }
    public List<CategoryEntity> getAllCategory(){
        return categoryRepo.findAll();
    }

    public CategoryEntity getCabyID(int id){
        return categoryRepo.findCategoryEntityById(id);
    }


    //book
    public BookEntity createBook(BookEntity b){
        if(!"0".equals(b.getId())){
            BookEntity b2 = bookRepo.save(b);
            b2.setBookPoster("/" +  b.getId()+"_poster.jpg");
            b2.setUrl("/book/"+b.getId());
            return bookRepo.save(b);

        }
        return bookRepo.save(b);
    }

    public List<BookEntity> getAll(Pageable pageable){
        return bookRepo.findAll(pageable).getContent();
    }

    public List<BookEntity> getBookTop(){
        return bookRepo.getBookTop();
    }

    public BookEntity getById(int id){
        return bookRepo.findBookEntityById(id);
    }

    public List<BookEntity> getByAId(int id){
        return bookRepo.findBookEntitiesByAuthorId(id);
    }

    public List<BookEntity> getByCa(int id){
        return bookRepo.findBookEntitiesByCategoryId(id);
    }

    public void delete(int id){
        bookRepo.deleteById(id);
    }

    public void createBD(BookdetailsEntity b){
        bookdbRepo.save(b);
    }
    public BookdetailsEntity getChapterBook(int bookId, int chapter){
        List<BookdetailsEntity> listdb = bookdbRepo.findBookdetailsEntitiesByBookId(bookId);
        List<BookdetailsEntity> list =  bookdbRepo.findAll();
        BookdetailsEntity bd = listdb.get(chapter - 1);
        return bd;
    }

    public List<BookdetailsEntity> getChapterNew(){
        return bookdbRepo.findChaperNew();
    }

    public int getNumberChapter(int bookID){
        return bookdbRepo.findBookdetailsEntitiesByBookId(bookID).size();
    }

}
