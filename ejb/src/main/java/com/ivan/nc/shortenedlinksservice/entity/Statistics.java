package com.ivan.nc.shortenedlinksservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @org.hibernate.annotations.ForeignKey(name = "refShortAdr")
    private String refShortAdr;

    private int authorId;

    private int numbOfTrans;

    private Date lastTrans;

    @ManyToOne(fetch = FetchType.EAGER)
    Reference reference;

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Statistics() {
    }

    public Statistics(int id, String refShortAdr, int authorId, int numbOfTrans, Date lastTrans) {
        this.id = id;
        this.refShortAdr = refShortAdr;
        this.authorId = authorId;
        this.numbOfTrans = numbOfTrans;
        this.lastTrans = lastTrans;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getRefShortAdr() {
        return refShortAdr;
    }

    public void setRefShortAdr(String refShortAdr) {
        this.refShortAdr = refShortAdr;
    }

    public int getNumbOfTrans() {
        return numbOfTrans;
    }

    public void setNumbOfTrans(int numbOfTrans) {
        this.numbOfTrans = numbOfTrans;
    }

    public Date getLastTrans() {
        return lastTrans;
    }

    public void setLastTrans(Date lastTrans) {
        this.lastTrans = lastTrans;
    }
}
