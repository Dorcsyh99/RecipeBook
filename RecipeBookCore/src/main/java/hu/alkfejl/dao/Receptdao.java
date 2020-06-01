package hu.alkfejl.dao;

import hu.alkfejl.model.Recept;

import java.util.List;

public interface Receptdao {

    public boolean hozzaad(Recept r);
    public void torol(Recept r);

    public List<Recept> Osszes();
}
