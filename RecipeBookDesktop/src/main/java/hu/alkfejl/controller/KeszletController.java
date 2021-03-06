package hu.alkfejl.controller;

import hu.alkfejl.dao.KeszletDao;
import hu.alkfejl.dao.KeszletDaoImpl;
import hu.alkfejl.model.Keszlet;

import java.util.List;

public class KeszletController {

    private KeszletDao dao = new KeszletDaoImpl();
    private static KeszletController single_instance = null;

    private KeszletController() {

    }

    public static KeszletController getInstance(){
        if(single_instance == null){
            single_instance = new KeszletController();
        }
        return single_instance;
    }

    public boolean hozzaad(Keszlet k) {
        return dao.hozzaad(k);
    }

    public List<Keszlet> Osszes() {
        return dao.Osszes();
    }

    public Keszlet keres(String k){ return dao.keres(k);}

    public boolean modosit(Double m, String a){return dao.modosit(m, a);}
}
