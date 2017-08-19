package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() {

        addContacts();
        fillContactsForm(new ContactsDate("A", "Alexandr", "WaveLW", "Zakharov", "Company", "address", "Home", "e-mail@mail.ru", "address"));
        gotoHomePage();
    }


}
