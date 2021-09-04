package ba.unsa.etf.rs;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class HospitalController {
    PreparedStatement prp = null;
    ResultSet result = null;
    Connection connection = null;
    String userName;
    public Button login;
    public TextField pass;
    public TextField username;

    public HospitalController() {
    }

    public void btnAction(ActionEvent actionEvent) {
        this.connection = Connector.ConnectDb();
        String user = this.username.getText();
        String passw = this.pass.getText();

        try {
            String sql = "select username, password from doctor where username='" + user + "'";
            this.prp = this.connection.prepareStatement(sql);
            this.result = this.prp.executeQuery();
            this.result.next();
            this.userName = user;
            if (passw.equals(this.result.getString("password"))) {
                JOptionPane.showMessageDialog((Component)null, "Login Succesful", "Welcome " + user, 1);
                this.connection.close();
            } else {
                JOptionPane.showMessageDialog((Component)null, "Login Failed", "Error", 2);
            }
        } catch (SQLException | HeadlessException var5) {
            JOptionPane.showMessageDialog((Component)null, "User or Password wrong.");
        }

    }
}
