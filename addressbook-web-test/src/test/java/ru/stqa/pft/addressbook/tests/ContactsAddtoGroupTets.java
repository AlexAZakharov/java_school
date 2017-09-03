package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsAddtoGroupTets extends TestBase {

    @Test
    public void testContacttsAddtoGroup (){
        app.getNavigationHelper().gotoHomePage();
        app.getContactsHelper().selectContacts(0);
        app.getContactsHelper().addtoGroup();
        app.getContactsHelper().gotoGroup();
        app.getNavigationHelper().gotoHomePage();
    }
}
