package ru.stqa.pft.addressbook.model;

public class ContactsDate {
    private int id;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String firstname;
    private final String company;
    private final String address;
    private final String home;
    private final String email;
    private final String address2;
    private String group;

    public ContactsDate(int id, String middlename, String lastname, String nickname, String firstname, String company, String address, String home, String email, String address2, String group) {
        this.id= id;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.firstname = firstname;
        this.company = company;
        this.address = address;
        this.home = home;
        this.email = email;
        this.address2 = address2;
        this.group = group;
    }
    public ContactsDate( String middlename, String lastname, String nickname, String firstname, String company, String address, String home, String email, String address2, String group) {
        this.id= 0;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.firstname = firstname;
        this.company = company;
        this.address = address;
        this.home = home;
        this.email = email;
        this.address2 = address2;
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
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
