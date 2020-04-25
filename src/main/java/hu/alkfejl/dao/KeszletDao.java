package hu.alkfejl.dao;

import hu.alkfejl.model.Keszlet;

import java.util.List;

public interface KeszletDao {

    public boolean hozzaad(Keszlet k);

    public List<Keszlet> Osszes();

}
