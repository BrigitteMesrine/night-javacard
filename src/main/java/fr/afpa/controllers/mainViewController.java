package fr.afpa.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.ContactBinarySerializer;
import fr.afpa.ContactJSONSerializer;
import fr.afpa.ContactVCardSerializer;
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
import javafx.scene.layout.VBox;

public class mainViewController {

    @FXML
    private VBox infoVBox;

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
    private TextField proPhoneField;

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
    private List<TextField> textFields = new ArrayList<>();
    private ContactBinarySerializer contactBinarySerializer = new ContactBinarySerializer();
    private ContactVCardSerializer contactVCardSerializer = new ContactVCardSerializer();
    private ContactJSONSerializer contactJSONSerializer = new ContactJSONSerializer();

    @FXML
    private void initialize() {

        infoVBox.setVisible(false);
        textFields.add(lastNameField);
        textFields.add(firstNameField);
        textFields.add(personalPhoneField);
        textFields.add(emailField);
        textFields.add(addressField);
        textFields.add(zipCodeField);
        textFields.add(proPhoneField);
        textFields.add(nicknameField);
        textFields.add(gitLinkField);
        // observableContacts.add(contactBinarySerializer.load("serials/contactsBinary"));
        
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
            isEdited = false;
            Contact newContact = new Contact(firstNameField.getText(), lastNameField.getText(),
                    personalPhoneField.getText(), emailField.getText(), addressField.getText(), zipCodeField.getText(),
                    Contact.Gender.FEMALE, birthDatePicker.getValue(), proPhoneField.getText(),
                    nicknameField.getText(),
                    gitLinkField.getText());
            observableContacts.add(newContact);
            tableView.setItems(observableContacts);
            contactBinarySerializer.saveList("serials/ContactsBinary", observableContacts);
        }
        if (isEdited) {
            isNew = false;
            fullNameLabel.setText(firstNameField.getText() + " " + lastNameField.getText());
            Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
            observableContacts.remove(selectedContact);
            selectedContact.setLastName(lastNameField.getText());
            selectedContact.setFirstName(firstNameField.getText());
            selectedContact.setPhone(personalPhoneField.getText());
            selectedContact.setEmail(emailField.getText());
            selectedContact.setAddress(addressField.getText());
            selectedContact.setZipCode(zipCodeField.getText());
            selectedContact.setBirthDate(birthDatePicker.getValue());
            selectedContact.setProPhone(proPhoneField.getText());
            selectedContact.setNickname(nicknameField.getText());
            selectedContact.setGitLink(gitLinkField.getText());
            observableContacts.add(selectedContact);
            tableView.setItems(observableContacts);
            contactBinarySerializer.saveList("serials/ContactsBinary", observableContacts);
        }
    }

    @FXML
    private void newContact() {
        isNew = true;
        infoVBox.setVisible(true);
        for (TextField textField : textFields) {
            textField.setEditable(true);
            textField.setPromptText("Required");
        }
    }

    @FXML
    private void editContact() {
        isEdited = true;
        if (!lastNameField.getText().isEmpty()) {
            for (TextField textField : textFields) {
                textField.setEditable(true);
            }
        }

    }

    @FXML
    private void showContactDetails() {

        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

        infoVBox.setVisible(true);
        fullNameLabel.setText(selectedContact.getFirstName() + " " + selectedContact.getLastName());
        lastNameField.setText(selectedContact.getLastName());
        firstNameField.setText(selectedContact.getFirstName());
        personalPhoneField.setText(selectedContact.getPhone());
        emailField.setText(selectedContact.getEmail());
        addressField.setText(selectedContact.getAddress());
        zipCodeField.setText(selectedContact.getZipCode());
        // genreGroup.;
        birthDatePicker.setValue(selectedContact.getBirthDate());
        proPhoneField.setText(selectedContact.getProPhone());
        nicknameField.setText(selectedContact.getNickname());
        gitLinkField.setText(selectedContact.getGitLink());
    }

    @FXML
    private void quit() {
        Platform.exit();
    }

}
