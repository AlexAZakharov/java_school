package ru.stqa.pft.addressbook.model;

public class ContactsDate {
    private int id= 0;
    private String middlename;
    private String lastname;
    private String nickname;
    private String firstname;
    private String company;
    private String address;
    private String home;
    private String email;
    private String email2;
    private String email3;
    private String address2;
    private String group;
    private String homePhon;
    private String mobilePhon;
    private String workPhon;
    private String allPhones;
    private String allEmails;

    public ContactsDate withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactsDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactsDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactsDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactsDate withHomePhon(String homePhon) {
        this.homePhon = homePhon;
        return this;
    }

    public ContactsDate withMobilePhon(String mobilePhon) {
        this.mobilePhon = mobilePhon;
        return this;
    }

    public ContactsDate withWorkPhon(String workPhon) {
        this.workPhon = workPhon;
        return this;
    }

    public ContactsDate withId(int id) {
        this.id = id;
        return this;
    }
    public ContactsDate withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactsDate withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactsDate withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactsDate withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactsDate withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactsDate withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactsDate withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactsDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactsDate withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactsDate withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
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

    public String getGroup() {
        return group;
    }

    public String getHomePhon() {
        return homePhon;
    }

    public String getMobilePhon() {
        return mobilePhon;
    }

    public String getWorkPhon() {
        return workPhon;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsDate that = (ContactsDate) o;

        if (id != that.id) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactsDate{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }


}
