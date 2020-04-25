package hu.alkfejl.dao;

import hu.alkfejl.model.Alapanyag;
import java.util.List;

public interface AlapanyagDao {

    public boolean hozzaad(Alapanyag a);
    public void torol(Alapanyag a);
    public void modosit(Alapanyag a);
    public void keszletModositas(Alapanyag a);

    public List<Alapanyag> Osszes();
}
