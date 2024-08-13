package fr.afpa.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class mainViewController {

    // -- CRUD BUTTONS --
    @FXML
    private Button newButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button validateButton;

    @FXML
    private Button cancelButton;

    // -- REQUIRED INFOS FIELDS --
    @FXML
    private Label fullNameLabel;
        
    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;
    
    @FXML
    private TextField personalPhoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;
    
    @FXML
    private TextField zipCodeField;

    @FXML
    private RadioButton maleRadio;
    
    @FXML
    private RadioButton femaleRadio;
    
    @FXML
    private RadioButton nonBinaryRadio;

    // -- OPTIONAL INFO FIELDS --
    @FXML
    private DatePicker birthDatePicker;
    
    @FXML
    private TextField workPhoneField;

    @FXML
    private TextField nicknameField;

    @FXML
    private TextField gitLinkField;

    @FXML
    private Button selectAllButton;

    @FXML
    private Button clearSelectionButton;

    // -- EXPORT BUTTONS --
    @FXML
    private Button exportButton;
    
    @FXML
    private CheckBox vCardBox;
    
    @FXML
    private CheckBox jsonBox;

    @FXML
    private CheckBox qrBox;

    @FXML
    private CheckBox csvBox;

    // -- TABLEVIEW ITEMS --
    @FXML
    private TextField searchBar;

    @FXML
    private TableView<?> tableView;
    
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    
    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    // -- STATUS LABELS --
    @FXML
    private Label exportStatusLabel;

    @FXML
    private Label contactStatusLabel;

    // -- APP KILLER --
    @FXML
    private Button quitButton;

    // local attributes for displays and serialization







}
