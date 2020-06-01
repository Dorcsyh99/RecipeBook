package hu.alkfejl.model;

import javafx.beans.property.*;

public class Keszlet {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty mertekegyseg = new SimpleStringProperty();
    private DoubleProperty mennyiseg = new SimpleDoubleProperty();
    private DoubleProperty minimalis = new SimpleDoubleProperty();

    public Keszlet(int id, String nev, String mertekegyseg, double mennyiseg, double minimalis){
        this.id.set(id);
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);
        this.mennyiseg.set(mennyiseg);
        this.minimalis.set(minimalis);
    }
    public Keszlet(String nev, String mertekegyseg, double mennyiseg, double min){
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);
        this.mennyiseg.set(mennyiseg);
        this.minimalis.set(min);
    }

    public int getId(){
        return id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }

    public String getNev(){ return nev.get();}
    public void setNev(String nev){this.nev.set(nev);}

    public StringProperty alapanyagNevProperty(){return nev;}
    public StringProperty alapanyagMertekegysegProperty(){return mertekegyseg;};
    public DoubleProperty mennyisegProperty(){return mennyiseg;};
    public DoubleProperty minimalisProperty(){return minimalis;};

    public String getMertekegyseg(){ return mertekegyseg.get();}
    public void setMertekegyseg(String mertekegyseg){this.mertekegyseg.set(mertekegyseg);}

    public double getMennyiseg(){
        return mennyiseg.get();
    }
    public void setMennyiseg(double m){
        this.mennyiseg.set(m);
    }

    public double getMinimalis(){return minimalis.get();}
    public void setMinimalis(double min){this.minimalis.set(min);}
}
