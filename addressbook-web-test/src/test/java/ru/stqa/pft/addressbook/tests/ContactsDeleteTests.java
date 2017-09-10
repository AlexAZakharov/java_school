package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.List;

public class ContactsDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(new ContactsDate("A", "Ivan", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1"),false);
        }
    }

    @Test
    public void testContactsDelete() {

      List<ContactsDate> before = app.getContactsHelper().getContactList();
      app.getContactsHelper().selectContacts(before.size()-1);
      app.getContactsHelper().deleteSelectedContacts();
      List<ContactsDate> after = app.getContactsHelper().getContactList();
      Assert.assertEquals(after.size(),before.size()-1);

      before.remove(before.size()-1);
      Assert.assertEquals(before,after);
    }
}
