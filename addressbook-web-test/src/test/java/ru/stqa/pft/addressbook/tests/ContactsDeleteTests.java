package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsDeleteTests extends TestBase {

    @Test
    public void testContactsDelete() {
      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),true);
      }
      app.getContactsHelper().selectContacts();
      app.getContactsHelper().deleteSelectedContacts();
    }
}
