package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        //app.getContactsHelper().selectContacts();
        app.getContactsHelper().initContactsModification();
        app.getContactsHelper().fillContactsForm(new ContactsDate("A1", "Alexandr", "WaveLW", "Zakharov", "Company1", "address2", "Home1", "e-mail@mail.ru", "address3"));
        app.getContactsHelper().submitContactsModification();

    }
}
