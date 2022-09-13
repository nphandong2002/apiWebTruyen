package com.example.apiweb.DTO;

import com.example.apiweb.Entity.BookdetailsEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookDTO {
    private String name;

    private BookDBDTO chapter;

    private String note;

    private String ather_name;

    private String category;

    private String summary;

    private String bookPoster;

    private String path;

}
