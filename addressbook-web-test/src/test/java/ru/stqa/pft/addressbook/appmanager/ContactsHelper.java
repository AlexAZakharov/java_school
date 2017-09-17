package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
      //  type(By.name("phone2"),contactsDate.getHome());
        type(By.name("email"),contactsDate.getEmail());
        type(By.name("address2"),contactsDate.getAddress2());
        attach(By.name("photo"),contactsDate.getPhoto());
    }

    public void creation() {
        click(By.linkText("add new"));
    }

    public void select(int index) {
        wd.findElements(By.xpath(".//*[@name='selected[]']")).get(index).click();
    }
    public void selectContactById(ContactsDate contact) {
        wd.findElement(By.xpath(".//input[@value='"+contact.getId()+"']")).click();
    }

    public void initModification(ContactsDate contact){
        wd.findElement(By.xpath(".//a[@href='edit.php?id="+contact.getId()+"']")).click();
    }
    public void delete() {
        click(By.xpath(".//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void delete(ContactsDate contactDeleted) {
        selectContactById(contactDeleted);
        delete();
        contactCash = null;
        nh.homePage();
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    /*public void initModification(int index){
        wd.findElements(By.xpath(".//*[@title='Edit']")).get(index).click();
    }*/

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
        contactCash = null;
        gotoHomePage();
    }
    public void modify(ContactsDate contact) {
        initModification(contact);
        fillForm(contact,false);
        submitModification();
        contactCash = null;
        gotoHomePage();
    }
    public boolean isThereAContact() {
        return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public int count() {
        return wd.findElements(By.xpath(".//*[@name='selected[]']")).size();
    }

  /*  public List<ContactsDate> list() {
       List<ContactsDate> contacts = new ArrayList<ContactsDate>();
       List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
       for (WebElement element: elements){
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String firstname =  cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactsDate contact = new ContactsDate()
                    .withId(id).withLastname(lastname).withFirstname(firstname);
            contacts.add(contact);
        }
        return contacts;
    }*/
  private Contacts contactCash = null;

    public Contacts all() {
        if(contactCash != null){
            return new Contacts(contactCash);
        }
        contactCash = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
        for (WebElement element: elements){
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String firstname =  cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String  allPhones = cells.get(5).getText();
            String  allEmails = cells.get(4).getText();
            String  address = cells.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactsDate contact = new ContactsDate().withId(id).withLastname(lastname).withAddress(address)
                    .withFirstname(firstname).withAllPhones(allPhones).withAllEmails(allEmails);
            contactCash.add(contact);
        }
        return contactCash;
    }

    public ContactsDate contactInfoFromEditForm(ContactsDate contact) {
        initModification(contact);
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        nh.homePage();
        return new ContactsDate().withFirstname(firstname).withLastname(lastname).withHomePhon(home).withAddress(address)
                .withMobilePhon(mobile).withWorkPhon(work).withEmail(email).withEmail2(email2).withEmail3(email3);
    }
}
