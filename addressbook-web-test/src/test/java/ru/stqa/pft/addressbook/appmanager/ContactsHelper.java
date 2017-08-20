package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactsForm(ContactsDate contactsDate) {
        type(By.name("firstname"),contactsDate.getFirstname());
        type(By.name("middlename"),contactsDate.getMiddlename());
        type(By.name("lastname"),contactsDate.getLastname());
        type(By.name("nickname"),contactsDate.getNickname());
        type(By.name("company"),contactsDate.getCompany());
        type(By.name("address"),contactsDate.getAddress());
        type(By.name("home"),contactsDate.getHome());
        type(By.name("email"),contactsDate.getEmail());
        type(By.name("address2"),contactsDate.getAddress2());
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void addContacts() {
        click(By.linkText("add new"));
    }
}
