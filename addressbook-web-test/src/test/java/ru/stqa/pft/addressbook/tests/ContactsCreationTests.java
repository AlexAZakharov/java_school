package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class ContactsCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        GroupDate gd=new GroupDate("test1", null, "test3");
        if (! app.group().groupExists(gd.getName())) {
            app.goTo().groupPage();
            app.group().create(gd);
        }

    }
    @Test
    public void testContactsCreation() {

        ContactsDate cd= new ContactsDate("A", "Alexandr", "WaveLW", "Bobrov", "Company", "address", null, "e-mail@mail.ru", "address","test1");

        List<ContactsDate> before = app.contacts().list();
        app.contacts().creation();
        app.contacts().fillForm(cd,true);
        app.contacts().submitCreation();
        app.contacts().gotoHomePage();
        List<ContactsDate> after = app.contacts().list();
        Assert.assertEquals(after.size(),before.size()+1);

        cd.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(cd);
        Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));
    }




}
