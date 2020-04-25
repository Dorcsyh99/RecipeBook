package hu.alkfejl.controller;

import hu.alkfejl.dao.AlapanyagDao;
import hu.alkfejl.dao.AlapanyagDaoImpl;
import hu.alkfejl.model.Alapanyag;

import java.util.List;

public class AlapanyagController {

    private AlapanyagDao dao = new AlapanyagDaoImpl();
    private static AlapanyagController single_instance = null;

    private AlapanyagController() {

    }

    public static AlapanyagController getInstance(){
        if(single_instance == null){
            single_instance = new AlapanyagController();
        }
        return single_instance;
    }

    public boolean hozzaad(Alapanyag a) {
        return dao.hozzaad(a);
    }

    public List<Alapanyag> Osszes() {
        return dao.Osszes();
    }
}
