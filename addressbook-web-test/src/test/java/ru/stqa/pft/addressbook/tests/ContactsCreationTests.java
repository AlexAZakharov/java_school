package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() {

        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContactsForm(new ContactsDate("A", "Alexandr", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),true);
        app.getContactsHelper().submitContactsCreation();
        app.getContactsHelper().gotoHomePage();
    }


}
