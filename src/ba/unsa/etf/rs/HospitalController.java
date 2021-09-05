package ba.unsa.etf.rs;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HospitalController {
    @FXML
    PreparedStatement prp = null;
    ResultSet result = null;
    Connection connection = null;
    String userName;
    public Button login;
    public TextField pass;
    public TextField username;

    public void btnAction() throws Exception {
        connection = Connector.ConnectDb();
        String user = username.getText();
        String passw = pass.getText();

        try {
            String sql = "select username, password from doctor where username='" + user + "'";
            prp = connection.prepareStatement(sql);
            result = prp.executeQuery();
            result.next();
            userName = user;
            if (passw.equals(result.getString("password"))) {

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Doctor.fxml"));
                Stage stage = (Stage) login.getScene().getWindow();
                stage.setTitle("Doctor");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

                JOptionPane.showMessageDialog((Component)null, "Login Succesful", "Welcome " + user, 1);
                connection.close();
            } else {
                JOptionPane.showMessageDialog((Component)null, "Login Failed", "Error", 2);
            }
        } catch (SQLException | HeadlessException var5) {
            JOptionPane.showMessageDialog((Component)null, "User or Password wrong.");
        }

    }
}
