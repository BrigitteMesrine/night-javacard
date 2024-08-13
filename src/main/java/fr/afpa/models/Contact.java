package fr.afpa.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {

    // Serializable attributes
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String zipCode;
    private Enum<Gender> gender;
    private LocalDate birthDate;
    private String proPhone;
    private String nickname;
    private String gitLink;

    // ObjectProperty for JavaFX display
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

    public enum Gender {
        MALE,
        FEMALE,
        NON_BINARY
    }

    @SuppressWarnings({ "java:S107" })
    public Contact(String firstName, String lastName, String phone, String email, String address, String zipCode,
            Enum<Gender> gender, LocalDate birthDate, String proPhone, String nickname, String gitLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.gender = gender;
        this.birthDate = birthDate;
        this.proPhone = proPhone;
        this.nickname = nickname;
        this.gitLink = gitLink;
        this.firstNameProperty = new SimpleStringProperty(firstName);
        this.lastNameProperty = new SimpleStringProperty(lastName);
        this.phoneProperty = new SimpleStringProperty(phone);
        this.emailProperty = new SimpleStringProperty(email);
        this.addressProperty = new SimpleStringProperty(address);
        this.zipCodeProperty = new SimpleStringProperty(zipCode);
        StringProperty localGenderProperty = new SimpleStringProperty();
        switch (gender) {
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
        this.genderProperty = localGenderProperty;
        this.birthDateProperty = new SimpleStringProperty(birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.proPhoneProperty = new SimpleStringProperty(proPhone);
        this.nicknameProperty = new SimpleStringProperty(nickname);
        this.gitLinkProperty = new SimpleStringProperty(gitLink);
    }

    // setters set both serializable attributes and ObjectProperty attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.firstNameProperty = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.lastNameProperty = new SimpleStringProperty(lastName);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.phoneProperty = new SimpleStringProperty(phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.emailProperty = new SimpleStringProperty(email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.addressProperty = new SimpleStringProperty(address);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        this.zipCodeProperty = new SimpleStringProperty(zipCode);
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
        StringProperty localGenderProperty = new SimpleStringProperty();
        switch (gender) {
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
        this.genderProperty = localGenderProperty;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.birthDateProperty = new SimpleStringProperty(birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
        this.proPhoneProperty = new SimpleStringProperty(proPhone);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        this.nicknameProperty = new SimpleStringProperty(nickname);
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
        this.gitLinkProperty = new SimpleStringProperty(gitLink);
    }

    @Override
    public String toString() {
        return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
                + ", address=" + address + ", zipCode=" + zipCode + ", gender=" + gender + ", birthDate=" + birthDate
                + ", proPhone=" + proPhone + ", nickname=" + nickname + ", gitLink=" + gitLink + "]";
    }

    // ObjectProperty getters for JavaFX display
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

}
