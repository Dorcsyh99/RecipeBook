package hu.alkfejl.controller;

import hu.alkfejl.dao.AlapanyagDao;
import hu.alkfejl.dao.AlapanyagDaoImpl;
import hu.alkfejl.dao.ReceptDaoImpl;
import hu.alkfejl.dao.Receptdao;
import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.model.Recept;

import java.util.List;

public class ReceptController {

    private Receptdao dao = new ReceptDaoImpl();
    private static ReceptController single_instance = null;

    private ReceptController() {

    }

    public static ReceptController getInstance(){
        if(single_instance == null){
            single_instance = new ReceptController();
        }
        return single_instance;
    }

    public boolean hozzaad(Recept r) {
        return dao.hozzaad(r);
    }

    public List<Recept> Osszes() {
        return dao.Osszes();
    }
}
