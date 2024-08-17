package fr.afpa.models;

import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObservableContact {

    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private StringProperty phoneProperty;
    private StringProperty emailProperty;
    private StringProperty addressProperty;
    private StringProperty zipCodeProperty;
    private StringProperty genderProperty;
    private StringProperty birthDateProperty;
    private StringProperty proPhoneProperty;
    private StringProperty nicknameProperty;
    private StringProperty gitLinkProperty;
    private Contact contact;

    public ObservableContact (Contact contact) {
        this.firstNameProperty = new SimpleStringProperty(contact.getFirstName());
        this.lastNameProperty = new SimpleStringProperty(contact.getLastName());
        this.phoneProperty = new SimpleStringProperty(contact.getPhone());
        this.emailProperty = new SimpleStringProperty(contact.getEmail());
        this.addressProperty = new SimpleStringProperty(contact.getAddress());
        this.zipCodeProperty = new SimpleStringProperty(contact.getZipCode());
        switch (contact.getGender()) {
            case Contact.Gender.MALE:
                this.genderProperty = new SimpleStringProperty("Male");
                break;

            case Contact.Gender.FEMALE:
                this.genderProperty = new SimpleStringProperty("Female");
                break;

            case Contact.Gender.NON_BINARY:
                this.genderProperty = new SimpleStringProperty("Non binary");
                break;

            default:
                break;
        }
        this.birthDateProperty = new SimpleStringProperty(contact.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.proPhoneProperty = new SimpleStringProperty(contact.getProPhone());
        this.nicknameProperty = new SimpleStringProperty(contact.getNickname());
        this.gitLinkProperty = new SimpleStringProperty(contact.getGitLink());
    }

    public StringProperty getFirstNameProperty() {
        return firstNameProperty;
    }

    public StringProperty getLastNameProperty() {
        return lastNameProperty;
    }

    public StringProperty getPhoneProperty() {
        return phoneProperty;
    }

    public StringProperty getEmailProperty() {
        return emailProperty;
    }

    public StringProperty getAddressProperty() {
        return addressProperty;
    }

    public StringProperty getZipCodeProperty() {
        return zipCodeProperty;
    }

    public StringProperty getGenderProperty() {
        return genderProperty;
    }

    public StringProperty getBirthDateProperty() {
        return birthDateProperty;
    }

    public StringProperty getProPhoneProperty() {
        return proPhoneProperty;
    }

    public StringProperty getNicknameProperty() {
        return nicknameProperty;
    }

    public StringProperty getGitLinkProperty() {
        return gitLinkProperty;
    }

    public Contact getContact() {
        return contact;
    }

    
}
