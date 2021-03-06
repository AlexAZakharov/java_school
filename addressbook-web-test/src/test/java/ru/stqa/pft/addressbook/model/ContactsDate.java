package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import sun.text.resources.cldr.to.FormatData_to;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table (name ="addressbook")
public class ContactsDate {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id= 0;
    @Column(name="middlename")
    private String middlename;
    @Column(name="lastname")
    private String lastname;
    @Column(name="nickname")
    private String nickname;
    @Column(name="firstname")
    private String firstname;
    @Column(name="company")
    private String company;
    @Column(name="address")
    @Type(type = "text")
    private String address;
    @Transient
    private String home;
    @Column(name="email")
    @Type(type = "text")
    private String email;
    @Column(name="email2")
    @Type(type = "text")
    private String email2;
    @Column(name="email3")
    @Type(type = "text")
    private String email3;
    @Column(name="address2")
    @Type(type = "text")
    private String address2;
    /*@Transient
    private String group;*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="address_in_groups"
            ,joinColumns = @JoinColumn(name="id")
            ,inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<GroupDate> groups = new HashSet<GroupDate>();

    @Column(name="home")
    @Type(type = "text")
    private String homePhon;
    @Column(name="mobile")
    @Type(type = "text")
    private String mobilePhon;
    @Column(name="work")
    @Type(type = "text")
    private String workPhon;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Column(name="photo")
    @Type(type = "text")
    private String photo="src/test/resources/i.jpg";

    public ContactsDate withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

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


    /*  public ContactsDate withGroup(String group) {
        this.group = group;
        return this;
    }*/

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

   /* public String getGroup() {
        return group;
    }*/

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

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsDate that = (ContactsDate) o;

        if (id != that.id) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public File getPhoto() {
        return new File(photo);
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
