package h8.chikey.control;

import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.ClientDAOIMPL;
import h8.chikey.daoimpl.GenderDAOIMPLE;
import h8.chikey.model.Client;
import h8.chikey.model.Gender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class CreateClientController {

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtLastName;

        @FXML
        private TextField txtData;

        @FXML
        private TextField txtPhone;

        @FXML
        private ComboBox<Gender> comboBox;

        @FXML
        private Button butCreate;

        @FXML
        private Button butExit;

        @FXML
        public void closeWin(ActionEvent event) {
            butExit.getScene().getWindow().hide();
        }

        @FXML
        void initialize(){
            SessionFactory factory1 = new Configuration().configure().buildSessionFactory();
            ObservableList<Gender> obsList = FXCollections.observableArrayList();
            DAO<Gender, Integer> daoGender = new GenderDAOIMPLE(factory1);
            obsList.addAll(daoGender.readAll());
            comboBox.setItems(obsList);


        }

        @FXML
        public void create(ActionEvent actionEvent) {
            SessionFactory factory2 = new Configuration().configure().buildSessionFactory();
            DAO<Client,Integer> daoClient = new ClientDAOIMPL(factory2);

            Client newClient = new Client();
            newClient.setFirstName(txtName.getText());
            newClient.setLastName(txtLastName.getText());
            newClient.setRegistrationDate(new Date());
            newClient.setPhone(txtPhone.getText());
            newClient.setGender(comboBox.getValue());
            daoClient.create(newClient);
        }

    }