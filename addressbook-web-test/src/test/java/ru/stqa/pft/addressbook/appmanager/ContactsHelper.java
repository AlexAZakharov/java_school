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

    public void selectContacts() {
        click(By.xpath(".//tr[@name='entry'][1]/td[@class='center']/input"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath(".//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void initContactsModification() {
       click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactsModification() {
        click(By.xpath(".//*[@name='update']"));
    }
}
