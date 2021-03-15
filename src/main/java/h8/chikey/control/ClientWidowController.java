package h8.chikey.control;


import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.ClientDAOIMPL;
import h8.chikey.model.Client;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ClientWidowController {

    @FXML
    private TableView<Client> tableView;

    @FXML
    private TableColumn<Client, Integer> columnID;

    @FXML
    private TableColumn<Client, String> columnFirstName;

    @FXML
    private TableColumn<Client, String> columnLastName;

    @FXML
    private TableColumn<Client, String> columnPatronymic;

    @FXML
    private TableColumn<Client, Date> columnBirthday;

    @FXML
    private TableColumn<Client, Date> columnRegistrationDate;

    @FXML
    private TableColumn<Client, String> columnEmail;

    @FXML
    private TableColumn<Client, String> columnPhone;

    @FXML
    private TableColumn<Client, String> columnGender;

    @FXML
    private TableColumn<Client, String> columnPhotoPath;

    @FXML
    private Button buttonExit;

    private static Client clientValue;
    ObservableList<Client> clientList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        try(SessionFactory factory = new Configuration().configure().buildSessionFactory()){
            DAO<Client,Integer> clientDAO = new ClientDAOIMPL(factory);
            List<Client> list = clientDAO.readAll();
            clientList.addAll(list);

            columnID.setCellValueFactory(clientIntegerCellDataFeatures -> new SimpleObjectProperty<>(clientIntegerCellDataFeatures.getValue().getClientId()));
            columnFirstName.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getFirstName()));
            columnLastName.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getLastName()));
            columnPatronymic.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getPatronymic()));
            columnBirthday.setCellValueFactory(clientDateCellDataFeatures -> new SimpleObjectProperty<>(clientDateCellDataFeatures.getValue().getBirthday()));
            columnRegistrationDate.setCellValueFactory(clientDateCellDataFeatures -> new SimpleObjectProperty<>(clientDateCellDataFeatures.getValue().getRegistrationDate()));;
            columnGender.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getGender().getName()));
            columnPhone.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getPhone()));

            tableView.setItems(clientList);
        }
    }


    public void deleteClient(ActionEvent actionEvent) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Client,Integer> daoClient = new ClientDAOIMPL(factory);
        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> { clientValue = newValue; });
        daoClient.delete(clientValue);
        initialize();
    }


    public void openCreateWin(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CreateClientWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Create Client");
        stage.getIcons().add(new Image("/image/service_logo.png"));
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void openUpdate(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/ClientUpdateWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("clientUpdate");
        stage.getIcons().add(new Image("/image/service_logo.png"));
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
//git init
//git status
//git add --all
//git commit -m"wgmwg"
//
//git remote
//git remote add VETKA url
//git push github
