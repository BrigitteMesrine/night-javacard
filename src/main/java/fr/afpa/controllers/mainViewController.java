package fr.afpa.controllers;

import java.time.LocalDate;

import fr.afpa.models.Contact;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Contact> tableView;

    @FXML
    private TableColumn<Contact, String> firstNameColumn;

    @FXML
    private TableColumn<Contact, String> lastNameColumn;

    @FXML
    private TableColumn<Contact, String> phoneColumn;

    // -- STATUS LABELS --
    @FXML
    private Label exportStatusLabel;

    @FXML
    private Label contactStatusLabel;

    // -- APP KILLER --
    @FXML
    private Button quitButton;

    // local attributes for displays and serialization
    private ObservableList<Contact> observableContacts = FXCollections.observableArrayList();
    private boolean isNew;
    private boolean isEdited;

    @FXML
    private void initialize() {

        Contact testContact1 = new Contact("Fabrizio", "PIZARRO", "0606060606", "fab.piz@gmail.com",
                "3- quai des Trente-Six", "36000", Contact.Gender.MALE, LocalDate.of(1985, 10, 25), "0707070707",
                "beufa", "gitlink-git.com");

        observableContacts.add(testContact1);
        tableView.setItems(observableContacts);

        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneProperty());
    }

    @FXML
    private void validateContact() {
        if (isNew) {
            Contact newContact = new Contact(firstNameField.getText(), lastNameField.getText(),
                    personalPhoneField.getText(), emailField.getText(), addressField.getText(), zipCodeField.getText(),
                    Contact.Gender.FEMALE, birthDatePicker.getValue(), workPhoneField.getText(), nicknameField.getText(),
                    gitLinkField.getText());
            observableContacts.add(newContact);
            tableView.setItems(observableContacts);
        }
        if (isEdited) {
            Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
            observableContacts.remove(selectedContact);
            selectedContact.setLastName(lastNameField.getText());
            selectedContact.setFirstName(firstNameField.getText());
            selectedContact.setPhone(personalPhoneField.getText());
            selectedContact.setEmail(emailField.getText());
            selectedContact.setAddress(addressField.getText());
            selectedContact.setZipCode(zipCodeField.getText());
            selectedContact.setBirthDate(birthDatePicker.getValue());
            selectedContact.setProPhone(workPhoneField.getText());
            selectedContact.setNickname(nicknameField.getText());
            selectedContact.setGitLink(gitLinkField.getText());
            observableContacts.add(selectedContact);
            tableView.setItems(observableContacts);
        }
    }

    @FXML
    private void newContact() {
        isNew = true;
        lastNameField.setEditable(true);
        lastNameField.setPromptText("Required");
        firstNameField.setEditable(true);
        personalPhoneField.setEditable(true);
        emailField.setEditable(true);
        addressField.setEditable(true);
        zipCodeField.setEditable(true);
        birthDatePicker.setEditable(true);
        workPhoneField.setEditable(true);
        nicknameField.setEditable(true);
        gitLinkField.setEditable(true);
        maleRadio.setDisable(false);
        femaleRadio.setDisable(false);
        nonBinaryRadio.setDisable(false);
    }

    @FXML
    private void editContact() {
        isEdited = true;
        if (!lastNameField.getText().isEmpty()) {
            lastNameField.setEditable(true);
            firstNameField.setEditable(true);
            personalPhoneField.setEditable(true);
            emailField.setEditable(true);
            addressField.setEditable(true);
            zipCodeField.setEditable(true);
            birthDatePicker.setEditable(true);
            workPhoneField.setEditable(true);
            nicknameField.setEditable(true);
            gitLinkField.setEditable(true);
            maleRadio.setDisable(false);
            femaleRadio.setDisable(false);
            nonBinaryRadio.setDisable(false);
        }
    }

    @FXML
    private void showContactDetails() {

        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

        lastNameField.setText(selectedContact.getLastName());
        firstNameField.setText(selectedContact.getFirstName());
        personalPhoneField.setText(selectedContact.getPhone());
        emailField.setText(selectedContact.getEmail());
        addressField.setText(selectedContact.getAddress());
        zipCodeField.setText(selectedContact.getZipCode());
        // genreGroup.;
        birthDatePicker.setValue(selectedContact.getBirthDate());
        workPhoneField.setText(selectedContact.getProPhone());
        nicknameField.setText(selectedContact.getNickname());
        gitLinkField.setText(selectedContact.getGitLink());
    }

    @FXML
    private void quit() {
        Platform.exit();
    }

}
