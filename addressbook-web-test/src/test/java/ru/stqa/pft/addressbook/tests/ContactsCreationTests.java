package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() {

        app.addContacts();
        app.fillContactsForm(new ContactsDate("A", "Alexandr", "WaveLW", "Zakharov", "Company", "address", "Home", "e-mail@mail.ru", "address"));
        app.gotoHomePage();
    }


}
