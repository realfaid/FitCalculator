package com.example.fitcalculator;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
public class Historie {

    private String Nazev;
    private Integer Zapsano;
    private String Datum;



    public Historie() {

    }


    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String nazev) {
        Nazev = nazev;
    }



    public Integer getZapsano() {
        return Zapsano;
    }

    public void setZapsano(Integer zapsano) {
        Zapsano = zapsano;
    }



    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }
}

