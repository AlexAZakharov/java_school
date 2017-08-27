package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() {

        app.getContactsHelper().addContacts();
        app.getContactsHelper().fillContactsForm(new ContactsDate("A", "Alexandr", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address"));
        app.getContactsHelper().gotoHomePage();
    }


}
