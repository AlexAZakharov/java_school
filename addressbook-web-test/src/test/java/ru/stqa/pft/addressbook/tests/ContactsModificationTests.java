package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),false);
        }
        List<ContactsDate> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().initContactsModification(before.size()-1);
        ContactsDate contact = new ContactsDate(before.get(before.size()-1).getId(),"A1", "Alexandr", "WaveLW", "Zakharov", "Company1", "address2", "Home1", "e-mail@mail.ru", "address3", null);
        app.getContactsHelper().fillContactsForm(contact,false);
        app.getContactsHelper().submitContactsModification();
        List<ContactsDate> after = app.getContactsHelper().getContactList();

        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));

    }
}
