package com.ivan.nc.shortenedlinksservice.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reference {
    @Id
    private String shortAddress;

    private String fullAddress;

    private Date dateCreate;

    private int authorId;

    @ManyToOne(fetch = FetchType.EAGER)
    Author author;

    @OneToMany(mappedBy = "reference")
    List<Statistics> statisticsList;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Reference(String fullAddress, String shortAddress, Date dateCreate, int authorId) {
        this.fullAddress = fullAddress;
        this.shortAddress = shortAddress;
        this.dateCreate = dateCreate;
        this.authorId = authorId;
    }

    public Reference(String fullAddress, String shortAddress, int authorId) {
        this.fullAddress = fullAddress;
        this.shortAddress = shortAddress;
        this.authorId = authorId;
    }

    public Reference() {
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getShortAddress() {
        return shortAddress;
    }

    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
