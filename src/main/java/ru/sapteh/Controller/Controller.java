package ru.sapteh.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.DAO;
import ru.sapteh.Model.Computer;
import ru.sapteh.Service.ComputerService;

public class Controller {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Computer> observableList = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Computer, Integer> TableId;

    @FXML
    private TableColumn<Computer, String> TableRam;

    @FXML
    private TableColumn<Computer, String> TableHdd;

    @FXML
    private TableColumn<Computer, String> TablePowerSupply;

    @FXML
    private TableColumn<Computer, String> TableVideoCard;

    @FXML
    private Button Add;

    @FXML
    private Button Update;

    @FXML
    private Button Delete;


    @FXML
    public void initialize() {

        DAO<Computer, Integer> ComputerService = new ComputerService(factory);
        List<Computer> computers = ComputerService.readByAll();
        observableList.addAll(computers);
        TableId.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getId()));
        TableRam.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getRam()));
        TableHdd.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getHdd()));
        TablePowerSupply.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getPowerSupply()));
        TableVideoCard.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getVideo_card()));


    }
}
