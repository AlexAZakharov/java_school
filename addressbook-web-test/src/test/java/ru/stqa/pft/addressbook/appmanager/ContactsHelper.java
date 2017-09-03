package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }
    private  GroupHelper gh =new GroupHelper(wd);
    private  NavigationHelper nh =new NavigationHelper(wd);

    public void fillContactsForm(ContactsDate contactsDate, boolean creation) {
        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsDate.getGroup());
        } else {
         //   Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("firstname"),contactsDate.getFirstname());
        type(By.name("middlename"),contactsDate.getMiddlename());
        type(By.name("lastname"),contactsDate.getLastname());
        type(By.name("nickname"),contactsDate.getNickname());
        type(By.name("company"),contactsDate.getCompany());
        type(By.name("address"),contactsDate.getAddress());
        type(By.name("home"),contactsDate.getHome());
        type(By.name("email"),contactsDate.getEmail());
        type(By.name("address2"),contactsDate.getAddress2());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContacts(int index) {
        wd.findElements(By.xpath(".//*[@name='selected[]']")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath(".//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void initContactsModification(int index){
        wd.findElements(By.xpath(".//*[@title='Edit']")).get(index).click();
    }

    public void submitContactsModification() {
        click(By.xpath(".//*[@name='update']"));
    }

    public void addtoGroup() {
        click(By.xpath(".//input[@name='add']"));
    }

    public void gotoGroup() {
        click(By.xpath(".//*[@id='content']/div/i/a"));
    }

    public void submitContactsCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createContact(ContactsDate contacts, boolean b) {
        initContactCreation();
        fillContactsForm(contacts,b);
        submitContactsCreation();
        gotoHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath(".//*[@name='selected[]']")).size();
    }
}
