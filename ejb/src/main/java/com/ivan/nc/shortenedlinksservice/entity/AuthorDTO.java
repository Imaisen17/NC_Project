package com.ivan.nc.shortenedlinksservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class AuthorDTO {

    private int id;
    private String name;
    private int refCount;

    public AuthorDTO() {
    }

    public AuthorDTO(int id, String name, int refCount) {
        this.id = id;
        this.name = name;
        this.refCount = refCount;
    }

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

    public int getRefCount() {
        return refCount;
    }

    public void setRefCount(int refCount) {
        this.refCount = refCount;
    }
}
