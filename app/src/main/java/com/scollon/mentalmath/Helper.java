package com.scollon.mentalmath;

public class Helper {
    private int punkty;
    private int id;

    public Helper(int pkt, int id){

        this.punkty = pkt;
        this.id = id;
    }

    public Helper(){}



    public String toString(){

        return " " + punkty + id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }
}
