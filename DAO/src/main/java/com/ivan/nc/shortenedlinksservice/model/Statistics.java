package com.ivan.nc.shortenedlinksservice.model;

import java.util.Date;

public class Statistics {
    private int idAuthor;
    private String refShortAdr;
    private int numbOfTrans;
    private Date lastTrans;

    private int counter;

    public Statistics(int idAuthor, String refShortAdr, int numbOfTrans, Date lastTrans) {
        this.idAuthor = idAuthor;
        this.refShortAdr = refShortAdr;
        this.numbOfTrans = numbOfTrans;
        this.lastTrans = lastTrans;
    }

    public Statistics() {
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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
