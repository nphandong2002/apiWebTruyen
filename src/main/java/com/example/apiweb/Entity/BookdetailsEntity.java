package com.example.apiweb.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookdetails", schema = "web_truyen", catalog = "")
public class BookdetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "chapter")
    private String chapter;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "user_read")
    private int userRead;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserRead() {
        return userRead;
    }

    public void setUserRead(int userRead) {
        this.userRead = userRead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookdetailsEntity that = (BookdetailsEntity) o;
        return id == that.id && bookId == that.bookId && chapter == that.chapter && userRead == that.userRead && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, chapter, note, userRead);
    }
}
