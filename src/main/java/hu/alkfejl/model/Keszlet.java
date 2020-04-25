package hu.alkfejl.model;

import javafx.beans.property.*;

public class Keszlet {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty mertekegyseg = new SimpleStringProperty();
    private IntegerProperty mennyiseg = new SimpleIntegerProperty();

    public Keszlet(int id, String nev, String mertekegyseg, int mennyiseg){
        this.id.set(id);
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);
        this.mennyiseg.set(mennyiseg);
    }
    public Keszlet(String nev, String mertekegyseg, int mennyiseg){
        this.nev.set(nev);
        this.mertekegyseg.set(mertekegyseg);
        this.mennyiseg.set(mennyiseg);
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
    public IntegerProperty mennyisegProperty(){return mennyiseg;};

    public String getMertekegyseg(){ return mertekegyseg.get();}
    public void setMertekegyseg(String mertekegyseg){this.mertekegyseg.set(mertekegyseg);}


    public int getMennyiseg(){
        return mennyiseg.get();
    }

    public void setMennyiseg(int m){
        this.mennyiseg.set(m);
    }
}
