package com.example.fitcalculator;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
public class Cvik {

    private String Nazev;
    private Integer Limit;
    private Integer Splneno_limit;
    private Integer Body;
    private String Jednotka_mereni;
    private String Popis_cviku;
    private String Prvni_datum;


    public Cvik() {

    }


    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String nazev) {
        Nazev = nazev;
    }



    public Integer getLimit() {
        return Limit;
    }

    public void setLimit(Integer limit) {
        Limit = limit;
    }



    public Integer getSplneno_limit() {
        return Splneno_limit;
    }

    public void setSplneno_limit(Integer splneno_limit) {
        Splneno_limit = splneno_limit;
    }


    public Integer getBody() {
        return Body;
    }

    public void setBody(Integer body) {
        Body = body;
    }



    public String getJednotka_mereni() {
        return Jednotka_mereni;
    }

    public void setJednotka_mereni(String jednotka_mereni) {
        Jednotka_mereni = jednotka_mereni;
    }



    public String getPopis_cviku() {
        return Popis_cviku;
    }

    public void setPopis_cviku(String popis_cviku) {
        Popis_cviku = popis_cviku;
    }


    public String getPrvni_datum() {
        return Prvni_datum;
    }

    public void setPrvni_datum(String prvni_datum) {
        Prvni_datum = prvni_datum;
    }
}

