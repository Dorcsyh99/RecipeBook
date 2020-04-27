package hu.alkfejl.dao;

import hu.alkfejl.model.Keszlet;
import hu.alkfejl.model.Recept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KeszletDaoImpl implements KeszletDao {

    private final static String DB_STRING = "jdbc:sqlite:bdproject3.db";
    private static final String CREATE_KESZLET = "CREATE TABLE IF NOT EXISTS Keszlet (" +
            "id integer PRIMARY KEY AUTOINCREMENT," +
            "alapanyagNev text NOT NULL," +
            "alapanyagMertekegyseg text NOT NULL," +
            "mennyiseg double NOT NULL, " +
            "minimalis double NOT NULL);";
    private static final String INSERT_KESZLET = "INSERT INTO Keszlet (alapanyagNev, alapanyagMertekegyseg, mennyiseg, minimalis) VALUES " +
            "(?,?,?,?);";
    private static final String SELECT_KESZLET = "SELECT * FROM Keszlet;";

    private static final String FIND_ONE = "SELECT * FROM Keszlet WHERE alapanyagNev=?;";

    private static final String UPDATE_ONE = "UPDATE Keszlet SET mennyiseg=? WHERE alapanyagNev=?;";

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
    public boolean modosit(Double m, String a){
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement(UPDATE_ONE)) {
            st.setDouble(1, m);
            st.setString(2, a);
            int res = st.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Keszlet keres(String k){
        Keszlet ke = new Keszlet("", "", 0, 0);
        try (Connection conn = DriverManager.getConnection(DB_STRING);
             PreparedStatement ps = conn.prepareStatement(FIND_ONE);) {
                ps.setString(1, k);
                ResultSet rs = ps.executeQuery();

                Keszlet result = new Keszlet(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getDouble(5));
                ke = result;
                System.out.println(result.getNev());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ke;


    }

    @Override
    public boolean hozzaad(Keszlet k){
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement(INSERT_KESZLET)) {
            st.setString(1, k.getNev());
            st.setString(2, k.getMertekegyseg());
            st.setDouble(3, k.getMennyiseg());
            st.setDouble(4, k.getMinimalis());

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
                        rs.getDouble(4),
                        rs.getDouble(5)
                );
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
