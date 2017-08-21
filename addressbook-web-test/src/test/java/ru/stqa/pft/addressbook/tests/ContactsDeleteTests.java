package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeleteTests extends TestBase {

    @Test
    public void testContactsDelete() {
      app.getNavigationHelper().gotoHomePage();
      app.getContactsHelper().selectContacts();
      app.getContactsHelper().deleteSelectedContacts();
    }
}
