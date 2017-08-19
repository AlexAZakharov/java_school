package ru.stqa.pft.addressbook.model;

public class ContactsDate {
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String firstname;
    private final String company;
    private final String address;
    private final String home;
    private final String email;
    private final String address2;

    public ContactsDate(String middlename, String lastname, String nickname, String firstname, String company, String address, String home, String email, String address2) {
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.firstname = firstname;
        this.company = company;
        this.address = address;
        this.home = home;
        this.email = email;
        this.address2 = address2;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress2() {
        return address2;
    }
}
