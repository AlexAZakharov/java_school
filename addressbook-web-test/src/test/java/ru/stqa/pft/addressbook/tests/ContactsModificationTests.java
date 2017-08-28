package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        //app.getContactsHelper().selectContacts();
        if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),true);
        }
        app.getContactsHelper().initContactsModification();
        app.getContactsHelper().fillContactsForm(new ContactsDate("A1", "Alexandr", "WaveLW", "Zakharov", "Company1", "address2", "Home1", "e-mail@mail.ru", "address3", null),false);
        app.getContactsHelper().submitContactsModification();

    }
}
