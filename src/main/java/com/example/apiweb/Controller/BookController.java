package com.example.apiweb.Controller;

import com.example.apiweb.Base.Constants;
import com.example.apiweb.Base.Response;
import com.example.apiweb.DTO.BookDBDTO;
import com.example.apiweb.DTO.BookDTO;
import com.example.apiweb.Entity.BookEntity;
import com.example.apiweb.Entity.BookdetailsEntity;
import com.example.apiweb.Entity.CategoryEntity;
import com.example.apiweb.Service.BookService;
import com.example.apiweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    private Environment env;

    @Autowired
    UserService userService;

    @PostMapping("/category/create")
    public @ResponseBody Response PostCreate(@RequestBody CategoryEntity c){
        bookService.createCategory(c);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData("done");
    }

    @GetMapping("/category")
    public @ResponseBody Response getAllCategory(){
        List<CategoryEntity> list = bookService.getAllCategory();
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(list);
    }

    //book
    @PostMapping("/book/upload")
    public @ResponseBody Response Post(@RequestBody BookEntity c){
        BookEntity b =  bookService.createBook(c);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(b.getId());
    }
    @PostMapping("/book/uploadD")
    public @ResponseBody Response PostD(@RequestBody BookdetailsEntity b){
        bookService.createBD(b);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData("done");
    }

    @PostMapping("/book")
    public @ResponseBody Response getBook(@RequestParam(name = "id") int id,
                                          @RequestParam(name = "chapter" , required = false , defaultValue = "1") Integer chapter,

                                          @RequestParam(name = "limit" , required = false , defaultValue = "5") Integer limit,
                                          @RequestParam(name = "page" , required = false , defaultValue = "0") Integer page){
        if(id == 0){
            List<BookEntity> list =   bookService.getAll(PageRequest.of(page,limit, Sort.by("id")));
            List<BookDTO> listbook = new ArrayList<>();
            for(BookEntity b : list){
                BookDTO bd = new BookDTO();
                bd.setName(b.getBookName());
                bd.setCategory(bookService.getCabyID(b.getCategoryId()).getName());
                bd.setAther_name(userService.getUserbyId(b.getAuthorId()).getName());
                bd.setBookPoster("http://localhost:" + env.getProperty("server.port") + b.getBookPoster());
                bd.setSummary(b.getSummary());
                bd.setPath(b.getUrl());
                bd.setNumberChapter(bookService.getNumberChapter(b.getId()));
                bd.setNumberRead(b.getUserId());
                listbook.add(bd);
            }
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(listbook);
        }else{
            BookEntity b = bookService.getById(id);
            BookDTO bd = new BookDTO();
            bd.setName(b.getBookName());
            bd.setCategory(bookService.getCabyID(b.getCategoryId()).getName());
            bd.setAther_name(userService.getUserbyId(b.getAuthorId()).getName());
            bd.setBookPoster("http://localhost:" + env.getProperty("server.port") + b.getBookPoster());
            bd.setSummary(b.getSummary());

            BookdetailsEntity bt = bookService.getChapterBook(b.getId(),chapter);
            BookDBDTO bdDTO = new BookDBDTO();
            bdDTO.setName(bt.getChapter());
            bdDTO.setNote(bt.getNote());
            bd.setChapter(bdDTO);
            bd.setNumberChapter(bookService.getNumberChapter(b.getId()));
            bd.setNumberRead(b.getUserId());
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bd);
        }
    }
    @PostMapping("/authbook/{id}")
    public @ResponseBody Response getBookAuth(@PathVariable("id") int id){
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bookService.getByAId(id));
    }
    @PostMapping("/book/top")
    public @ResponseBody Response getBookTop(){
        List<BookEntity> list =   bookService.getBookTop();
        List<BookDTO> listbook = new ArrayList<>();
        for(BookEntity b : list){
            BookDTO bd = new BookDTO();
            bd.setName(b.getBookName());
            bd.setCategory(bookService.getCabyID(b.getCategoryId()).getName());
            bd.setAther_name(userService.getUserbyId(b.getAuthorId()).getName());
            bd.setBookPoster("http://localhost:" + env.getProperty("server.port") + b.getBookPoster());
            bd.setSummary(b.getSummary());
            bd.setPath(b.getUrl());
            listbook.add(bd);
        }
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(listbook);
    }
    @PostMapping("/book/chapterNew")
    public @ResponseBody Response getChapterNew(){
        List<BookdetailsEntity> listdb = bookService.getChapterNew();
        List<BookDTO> listbook = new ArrayList<>();

        for(BookdetailsEntity book: listdb){

            BookEntity b = bookService.getById(book.getBookId());
                if(b != null){
                    BookDTO bd = new BookDTO();
                    bd.setName(b.getBookName());
                    bd.setCategory(bookService.getCabyID(b.getCategoryId()).getName());
                    bd.setAther_name(userService.getUserbyId(b.getAuthorId()).getName());
                    bd.setBookPoster("http://localhost:" + env.getProperty("server.port") + b.getBookPoster());
                    bd.setSummary(b.getSummary());
                    bd.setPath(b.getUrl());
                    BookDBDTO bdbDTO  = new BookDBDTO();
                    bdbDTO.setName(book.getChapter());
                    bd.setChapter(bdbDTO);

                    listbook.add(bd);
                }

        }
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(listbook);
    }
}
