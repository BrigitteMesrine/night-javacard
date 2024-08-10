package fr.afpa.models;

import java.time.LocalDate;

public class Contact {

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

    private enum Gender {
        MALE,
        FEMALE,
        NON_BINARY
    }

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
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    @Override
    public String toString() {
        return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
                + ", address=" + address + ", zipCode=" + zipCode + ", gender=" + gender + ", birthDate=" + birthDate
                + ", proPhone=" + proPhone + ", nickname=" + nickname + ", gitLink=" + gitLink + "]";
    }

}
