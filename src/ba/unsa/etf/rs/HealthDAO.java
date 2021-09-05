package ba.unsa.etf.rs;

import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;

public class HealthDAO {
    private  static HealthDAO instance;
    @FXML
    Connection connection = null;

    private PreparedStatement givePatients,findPatient,addPatient,editPatient;

    public static HealthDAO getInstance() {
        if (instance == null) instance = new HealthDAO();
        return instance;
    }

    private HealthDAO() {
        connection = Connector.ConnectDb();

        try {
            givePatients = connection.prepareStatement("SELECT * FROM patient");
            addPatient = connection.prepareStatement("INSERT INTO patient VALUES(?,?,?,?)");
            findPatient = connection.prepareStatement("SELECT * FROM patient WHERE name=?");
            editPatient = connection.prepareStatement("UPDATE patient SET name=?, surname=?, contact=? WHERE id=?");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Patient givePatientFromResultSet(ResultSet rs) throws SQLException {
        return new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
    }

    public ArrayList<Patient> patients() {
        ArrayList<Patient> result = new ArrayList();
        try {
            ResultSet rs = givePatients.executeQuery();
            while (rs.next()) {
                Patient patient = givePatientFromResultSet(rs);
                result.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
