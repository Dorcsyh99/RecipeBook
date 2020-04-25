package hu.alkfejl.dao;

import hu.alkfejl.model.Keszlet;
import hu.alkfejl.model.Recept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KeszletDaoImpl implements KeszletDao {

    private final static String DB_STRING = "jdbc:sqlite:bdproject2.db";
    private static final String CREATE_KESZLET = "CREATE TABLE IF NOT EXISTS Keszlet (" +
            "id integer PRIMARY KEY AUTOINCREMENT," +
            "alapanyagNev text NOT NULL," +
            "alapanyagMertekegyseg text NOT NULL," +
            "mennyiseg integer NOT NULL);";
    private static final String INSERT_KESZLET = "INSERT INTO Keszlet (alapanyagNev, alapanyagMertekegyseg, mennyiseg) VALUES " +
            "(?,?,?);";
    private static final String SELECT_KESZLET = "SELECT * FROM Keszlet;";

    public void initializeTables() {
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate(CREATE_KESZLET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public KeszletDaoImpl() {
        initializeTables();
    }

    @Override
    public boolean hozzaad(Keszlet k){
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement(INSERT_KESZLET)) {
            st.setString(1, k.getNev());
            st.setString(2, k.getMertekegyseg());
            st.setInt(3, k.getMennyiseg());

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
    public List<Keszlet> Osszes(){
        List<Keszlet> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_KESZLET);

            while (rs.next()) {
                Keszlet r = new Keszlet(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
