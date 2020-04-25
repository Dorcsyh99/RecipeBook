package hu.alkfejl.model;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Alapanyag {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty mertekegyseg = new SimpleStringProperty();


    public Alapanyag(int id, String nev, String mertekegyseg){
        this.id.set(id);
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);

    }

    public Alapanyag(String nev, String mertekegyseg){
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);
    }


    public int getId() {
        return id.get();
    }

    public void setId(int id){
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNev(){
        return nev.get();
    }

    public void setNev(String nev){
        this.nev.set(nev);
    }

    public StringProperty nevProperty(){ return nev; }

    public String getMertekegyseg(){return mertekegyseg.get(); }

    public void setMertekegyseg(String mertekegyseg){
        this.mertekegyseg.set(mertekegyseg);
    }

    public StringProperty mertekegysegProperty(){return mertekegyseg;}


}
