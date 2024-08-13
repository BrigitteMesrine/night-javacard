package fr.afpa.models;

import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObservableContact {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty address;
    private StringProperty zipCode;
    private StringProperty gender;
    private StringProperty birthDate;
    private StringProperty proPhone;
    private StringProperty nickname;
    private StringProperty gitLink;
    private Contact contact;

    @SuppressWarnings({"java:S107"})
    public ObservableContact(Contact contact) {
        this.firstName = new SimpleStringProperty(contact.getFirstName());
        this.lastName = new SimpleStringProperty(contact.getLastName());
        this.phone = new SimpleStringProperty(contact.getPhone());
        this.email = new SimpleStringProperty(contact.getEmail());
        this.address = new SimpleStringProperty(contact.getAddress());
        this.zipCode = new SimpleStringProperty(contact.getZipCode());
        StringProperty genderProperty = new SimpleStringProperty();
        switch (contact.getGender()) {
            case Contact.Gender.MALE:
                genderProperty.setValue("Male");
                break;
        
            case Contact.Gender.FEMALE:
                genderProperty.setValue("Female");
                break;
        
            case Contact.Gender.NON_BINARY:
                genderProperty.setValue("Non binary");
                break;
                
            default:
                break;
        }
        this.gender = genderProperty;
        this.birthDate = new SimpleStringProperty(contact.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.proPhone = new SimpleStringProperty(contact.getProPhone());
        this.nickname = new SimpleStringProperty(contact.getNickname());
        this.gitLink = new SimpleStringProperty(contact.getGitLink());
        this.contact = contact;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public StringProperty getPhone() {
        return phone;
    }

    public StringProperty getEmail() {
        return email;
    }

    public StringProperty getAddress() {
        return address;
    }

    public StringProperty getZipCode() {
        return zipCode;
    }

    public StringProperty getGender() {
        return gender;
    }

    public StringProperty getBirthDate() {
        return birthDate;
    }

    public StringProperty getProPhone() {
        return proPhone;
    }

    public StringProperty getNickname() {
        return nickname;
    }

    public StringProperty getGitLink() {
        return gitLink;
    }

    public Contact getContact() {
        return contact;
    }

    

}
