package h8.chikey.control;

import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.ClientDAOIMPL;
import h8.chikey.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControllerRead {

    @FXML
    private ImageView image;

    @FXML
    private Label textFerstName;

    @FXML
    private Label textLastname;

    @FXML
    private Label textGender;

    @FXML
    private Button butExit;

    ObservableList<Client> list = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Client,Integer> daoClient = new ClientDAOIMPL(factory);

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> { clientValue = newValue; });
        daoClient.delete(clientValue);
        initialize();


    }






}
