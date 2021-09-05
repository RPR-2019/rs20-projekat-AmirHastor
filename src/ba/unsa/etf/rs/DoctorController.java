package ba.unsa.etf.rs;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DoctorController {
    public TableView<Patient> tableViewPatients;
    public TableColumn colPatientId;
    public TableColumn colPatientName;
    public TableColumn colPatientSurname;
    public TableColumn colContact;
    private HealthDAO dao;
    private ObservableList<Patient> listPatients;


    public DoctorController() {
        dao = HealthDAO.getInstance();
        listPatients = FXCollections.observableArrayList(dao.patients());
    }

    @FXML
    public void initialize() {
        tableViewPatients.setItems(listPatients);
        colPatientId.setCellValueFactory(new PropertyValueFactory("id"));
        colPatientName.setCellValueFactory(new PropertyValueFactory("name"));
        colPatientSurname.setCellValueFactory(new PropertyValueFactory("surname"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
    }


}
