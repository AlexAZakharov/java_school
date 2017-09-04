package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.List;

public class ContactsDeleteTests extends TestBase {

    @Test
    public void testContactsDelete() {

      app.getNavigationHelper().gotoHomePage();
      if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address",null),false);
      }
      List<ContactsDate> before = app.getContactsHelper().getContactList();
      app.getContactsHelper().selectContacts(before.size()-1);
      app.getContactsHelper().deleteSelectedContacts();
      List<ContactsDate> after = app.getContactsHelper().getContactList();
      Assert.assertEquals(after.size(),before.size()-1);
    }
}
