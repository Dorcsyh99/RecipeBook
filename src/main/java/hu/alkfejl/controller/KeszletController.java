package hu.alkfejl.controller;

import hu.alkfejl.dao.KeszletDao;
import hu.alkfejl.dao.KeszletDaoImpl;
import hu.alkfejl.dao.ReceptDaoImpl;
import hu.alkfejl.dao.Receptdao;
import hu.alkfejl.model.Keszlet;
import hu.alkfejl.model.Recept;

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
}
