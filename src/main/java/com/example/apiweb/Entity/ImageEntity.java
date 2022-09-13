package com.example.apiweb.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "image", schema = "web_truyen", catalog = "")
public class ImageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "fk_id")
    private int fkId;
    @Basic
    @Column(name = "type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getFkId() {
        return fkId;
    }

    public void setFkId(int fkId) {
        this.fkId = fkId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEntity that = (ImageEntity) o;
        return id == that.id && fkId == that.fkId && Objects.equals(name, that.name) && Objects.equals(path, that.path) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, path, fkId, type);
    }
}
