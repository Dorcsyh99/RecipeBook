package hu.alkfejl.dao;
import hu.alkfejl.model.Alapanyag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlapanyagDaoImpl implements AlapanyagDao {

    private final static String DB_STRING = "jdbc:sqlite:bdproject3.db";
    private static final String CREATE_ALAPANYAG = "CREATE TABLE IF NOT EXISTS Alapanyag (" +
            "id integer PRIMARY KEY AUTOINCREMENT," +
            "nev text NOT NULL," +
            "mertekegyseg text NOT NULL)";
    private static final String INSERT_ALAPANYAG = "INSERT INTO Alapanyag (nev, mertekegyseg) VALUES " +
            "(?,?);";
    private static final String SELECT_ALAPANYAG = "SELECT * FROM Alapanyag;";




    public void initializeTables() {
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate(CREATE_ALAPANYAG);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AlapanyagDaoImpl() {
        initializeTables();
    }

    @Override
    public void keszletModositas(Alapanyag a){

    }


    @Override
    public boolean hozzaad(Alapanyag a){
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement(INSERT_ALAPANYAG)) {
            st.setString(1, a.getNev());
            st.setString(2, a.getMertekegyseg());
            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void torol(Alapanyag a){

    }

    @Override
    public void modosit(Alapanyag a){

    }

    @Override
    public List<Alapanyag> Osszes(){
        List<Alapanyag> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_ALAPANYAG);

            while (rs.next()) {
                Alapanyag a = new Alapanyag(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                result.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
