package hu.alkfejl.model;

import javafx.beans.property.*;

public class Recept {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty leiras = new SimpleStringProperty();
    private StringProperty nehezseg = new SimpleStringProperty();
    private DoubleProperty idotartam = new SimpleDoubleProperty();
    private IntegerProperty fo = new SimpleIntegerProperty();
    private StringProperty alapanyagok = new SimpleStringProperty();
    private StringProperty kategoria = new SimpleStringProperty();

    public Recept(int id, String nev, String le, String neh, double ido, int fo, String alap, String kat){
        this.id.set(id);
        this.nev.set(nev);
        this.leiras.set(le);
        this.nehezseg.set(neh);
        this.idotartam.set(ido);
        this.fo.set(fo);
        this.alapanyagok.set(alap);
        this.kategoria.set(kat);
    }

    public Recept(int id, String nev, String le, String neh, double ido, int fo, String kat){
        this.id.set(id);
        this.nev.set(nev);
        this.leiras.set(le);
        this.nehezseg.set(neh);
        this.idotartam.set(ido);
        this.fo.set(fo);
        this.kategoria.set(kat);
    }

    public Recept(String nev, String le, String neh, double ido, int fo, String alap, String kat){
        this.nev.set(nev);
        this.leiras.set(le);
        this.nehezseg.set(neh);
        this.idotartam.set(ido);
        this.fo.set(fo);
        this.alapanyagok.set(alap);
        this.kategoria.set(kat);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getFo() {
        return fo.get();
    }

    public void setFo(int fo) {
        this.fo.set(fo);
    }

    public String getNev(){
        return nev.get();
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public String getLeiras(){
        return leiras.get();
    }

    public void setLeiras(String leiras) {
        this.leiras.set(leiras);
    }

    public String getNehezseg(){
        return nehezseg.get();
    }

    public void setNehezseg(String nehezseg) {
        this.nehezseg.set(nehezseg);
    }

    public String getKategoria(){
        return kategoria.get();
    }

    public void setKategoria(String kategoria) {
        this.kategoria.set(kategoria);
    }

    public void setIdotartam(double idotartam) {
        this.idotartam.set(idotartam);
    }

    public double getIdotartam() {
        return idotartam.get();
    }

    public String getAlapanyagok(){return alapanyagok.get();}

    public void setAlapanyagok(String alap){this.alapanyagok.set(alap);}


}
