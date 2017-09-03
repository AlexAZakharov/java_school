package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

public class ContactsDeleteTests extends TestBase {

    @Test
    public void testContactsDelete() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address",null),false);
      }
      int before = app.getContactsHelper().getContactCount();
      app.getContactsHelper().selectContacts(before-1);
      app.getContactsHelper().deleteSelectedContacts();
      int after = app.getContactsHelper().getContactCount();

      Assert.assertEquals(after,before-1);
    }
}
