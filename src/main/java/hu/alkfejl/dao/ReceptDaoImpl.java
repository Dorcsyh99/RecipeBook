package hu.alkfejl.dao;

import hu.alkfejl.model.Alapanyag;
import hu.alkfejl.model.Recept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceptDaoImpl implements Receptdao {

    private final static String DB_STRING = "jdbc:sqlite:bdproject3.db";
    private static final String CREATE_RECEPT = "CREATE TABLE IF NOT EXISTS Recept (" +
            "id integer PRIMARY KEY AUTOINCREMENT," +
            "nev text NOT NULL," +
            "leiras text NOT NULL," +
            "nehezseg text NOT NULL," +
            "idotartam double NOT NULL," +
            "alapanyagok text NOT NULL," +
            "fo integer NOT NULL," +
            "kategoria text NOT NULL);";
    private static final String INSERT_RECEPT = "INSERT INTO Recept (nev, leiras, nehezseg, idotartam, alapanyagok, fo, kategoria) VALUES " +
            "(?,?,?,?,?,?,?);";
    private static final String SELECT_RECEPT = "SELECT * FROM Recept;";

    public void initializeTables() {
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate(CREATE_RECEPT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ReceptDaoImpl(){initializeTables();};
    @Override
    public boolean hozzaad(Recept r) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement(INSERT_RECEPT)) {
            st.setString(1, r.getNev());
            st.setString(2, r.getLeiras());
            st.setString(3, r.getNehezseg());
            st.setDouble(4, r.getIdotartam());
            st.setString(5, r.getAlapanyagok());
            st.setInt(6, r.getFo());
            st.setString(7, r.getKategoria());

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
    public void torol(Recept r){

    }

    @Override
    public List<Recept> Osszes(){
        List<Recept> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_RECEPT);

            while (rs.next()) {
                Recept r = new Recept(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(7),
                        rs.getString(6),
                        rs.getString(8)
                );
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
