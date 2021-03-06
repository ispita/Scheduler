/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler.ViewController;


import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import scheduler.Model.Appointment;
import static scheduler.Model.SqlQueries.assembleAppointmentsData;
import scheduler.Model.User;

/**
 * FXML Controller class
 *
 * @author flavius8
 */
public class AppointmentsController implements Initializable {
    User currentUser;
    private ObservableList<Appointment> appointmentData = FXCollections.observableArrayList();
    @FXML
    private TableView<Appointment> appointmentTable;
    @FXML
    private TableColumn<Appointment, Integer> appointmentID;
    @FXML
    private TableColumn<Appointment, Integer> customerID;
    @FXML
    private TableColumn<Appointment, Integer> userID;
    @FXML
    private TableColumn<Appointment, String> appointmentTitle;
    @FXML
    private TableColumn<Appointment, String> appointmentDescription;    
    @FXML
    private TableColumn<Appointment, String> appointmentLocation;
    @FXML
    private TableColumn<Appointment, String> appointmentContact;
    @FXML
    private TableColumn<Appointment, String> appointmentType; 
    @FXML
    private TableColumn<Appointment, String> appointmentURL;
    @FXML
    private TableColumn<Appointment, Timestamp> appointmentStart;
    @FXML
    private TableColumn<Appointment, Timestamp> appointmentEnd;
    @FXML
    private TableColumn<Appointment, Timestamp> appointmentCreateDate;
    @FXML
    private TableColumn<Appointment, String> appointmentCreatedBy;
    @FXML
    private TableColumn<Appointment, Timestamp> appointmentLastUpdate;
    @FXML
    private TableColumn<Appointment, String> appointmentLastUpdateBy;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        appointmentID.setCellValueFactory(cellData -> cellData.getValue().getAppointmentId().asObject());
        customerID.setCellValueFactory(cellData -> cellData.getValue().getCustomerID().asObject());      
        userID.setCellValueFactory(cellData -> cellData.getValue().getUserID().asObject());
        appointmentTitle.setCellValueFactory(cellData -> cellData.getValue().getAppointmentTitle());
        appointmentDescription.setCellValueFactory(cellData -> cellData.getValue().getAppointmentDescription());
        appointmentLocation.setCellValueFactory(cellData -> cellData.getValue().getAppointmentLocation());
        appointmentContact.setCellValueFactory(cellData -> cellData.getValue().getAppointmentContact());
        appointmentType.setCellValueFactory(cellData -> cellData.getValue().getAppointmentType());
        appointmentURL.setCellValueFactory(cellData -> cellData.getValue().getAppointmentUrl());
        appointmentStart.setCellValueFactory(cellData -> cellData.getValue().getAppointmentStart());
        appointmentEnd.setCellValueFactory(cellData -> cellData.getValue().getAppointmentEnd());
        appointmentCreateDate.setCellValueFactory(cellData -> cellData.getValue().getAppointmentCreateDate());
        appointmentCreatedBy.setCellValueFactory(cellData -> cellData.getValue().getAppointmentCreatedBy());
        appointmentLastUpdate.setCellValueFactory(cellData -> cellData.getValue().getAppointmentLastUpdate());
        appointmentLastUpdateBy.setCellValueFactory(cellData -> cellData.getValue().getAppointmentLastUpdatedBy());
        appointmentTable.setItems(assembleAppointmentsData());
        System.out.println("Appointment Table Contents: " + appointmentTable.getItems());
    }   
    
    public void setCurrentUser(User passCurrentUser){
        this.currentUser = passCurrentUser;
        System.out.println("Homepage User Set: " + currentUser.getUsername());
    }
}
