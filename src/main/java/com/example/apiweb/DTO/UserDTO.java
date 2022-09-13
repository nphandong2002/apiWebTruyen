package com.example.apiweb.DTO;

import com.example.apiweb.Entity.BookEntity;
import com.example.apiweb.Entity.NavbarEntity;
import com.example.apiweb.Entity.ReadingEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
public class UserDTO {
    private String name;

    private String gender;

    private Date birth;

    private int roleId;

    private String url_avatar;

    private int exp;

    private List<ReadingEntity> book_readed;

    private List<BookEntity> auther_book;

    private List<NavbarEntity> navbar;

    private int id;
}
