package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.HashSet;
import java.util.List;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (! app.contacts().isThereAContact()){
            app.contacts().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),false);
        }
    }

    @Test
    public void testContactModification() {

        List<ContactsDate> before = app.contacts().list();
        ContactsDate contact = new ContactsDate(before.get(before.size()-1).getId(),"A1", "Alexandr", "WaveLW", "Zakharov", "Company1", "address2", "Home1", "e-mail@mail.ru", "address3", null);
        int index = before.size()-1;
        app.contacts().initModification(index);
        app.contacts().fillForm(contact,false);
        app.contacts().submitModification();
        List<ContactsDate> after = app.contacts().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));

    }
}
