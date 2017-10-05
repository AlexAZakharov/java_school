package ru.stqa.pft.mantis.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("user")
@Entity
@Table(name ="mantis_user_table")
public class UserDate {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id= 0;
    @Column(name="username")
    private String username;
    @Column(name="email")
    @Type(type = "text")
    private String email;

    public UserDate withId(int id) {
        this.id = id;
        return this;
    }

    public UserDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDate withUsername(String username) {
        this.username = username;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
