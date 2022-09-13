package com.example.apiweb.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "web_truyen", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "book_name")
    private String bookName;
    @Basic
    @Column(name = "author_id")
    private int authorId;
    @Basic
    @Column(name = "book_poster")
    private String bookPoster;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "summary")
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getBookPoster() {
        return bookPoster;
    }

    public void setBookPoster(String bookPoster) {
        this.bookPoster = bookPoster;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && authorId == that.authorId && userId == that.userId && categoryId == that.categoryId && Objects.equals(bookName, that.bookName) && Objects.equals(bookPoster, that.bookPoster) && Objects.equals(url, that.url) && Objects.equals(summary, that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, authorId, bookPoster, userId, url, categoryId, summary);
    }
}
