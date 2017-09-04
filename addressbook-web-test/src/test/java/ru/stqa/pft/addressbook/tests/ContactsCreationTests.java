package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() {

        app.getNavigationHelper().gotoHomePage();
        ContactsDate cd= new ContactsDate("A", "Alexandr", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1");

        GroupDate gd=new GroupDate("test1", null, "test3");

        if (! app.getGroupHelper().groupExists(gd.getName())) {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().createGroup(gd);
        }
        List<ContactsDate> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContactsForm(cd,true);
        app.getContactsHelper().submitContactsCreation();
        app.getContactsHelper().gotoHomePage();
        List<ContactsDate> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()+1);
    }




}
