package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }
    private  GroupHelper gh =new GroupHelper(wd);
    private  NavigationHelper nh =new NavigationHelper(wd);

    public void fillForm(ContactsDate contactsDate, boolean creation) {
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

    public void creation() {
        click(By.linkText("add new"));
    }

    public void select(int index) {
        wd.findElements(By.xpath(".//*[@name='selected[]']")).get(index).click();
    }

    public void delete() {
        click(By.xpath(".//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void initModification(int index){
        wd.findElements(By.xpath(".//*[@title='Edit']")).get(index).click();
    }

    public void submitModification() {
        click(By.xpath(".//*[@name='update']"));
    }

    public void addtoGroup() {
        click(By.xpath(".//input[@name='add']"));
    }

    public void gotoGroup() {
        click(By.xpath(".//*[@id='content']/div/i/a"));
    }

    public void submitCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createContact(ContactsDate contacts, boolean b) {
        creation();
        fillForm(contacts,b);
        submitCreation();
        gotoHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath(".//*[@name='selected[]']")).size();
    }

    public List<ContactsDate> list() {
       List<ContactsDate> contacts = new ArrayList<ContactsDate>();
       List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
       for (WebElement element: elements){
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String firstname =  cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactsDate contact = new ContactsDate(id,null, lastname,null,firstname,null,null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
