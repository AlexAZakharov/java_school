package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.HashSet;
import java.util.List;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (! app.contacts().isThereAContact()){
            app.contacts().createContact(new ContactsDate()
                    .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW").withFirstname("Bobrov")
                    .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                    .withAddress2("address").withGroup("test1"),false);
        }
    }

    @Test
    public void testContactModification() {

        List<ContactsDate> before = app.contacts().list();
        ContactsDate contact = new ContactsDate()
                .withId(before.get(before.size()-1).getId())
                .withMiddlename("A1").withLastname("Alexandr").withNickname("WaveLW").withFirstname("Zakharov")
                .withCompany("Company1").withAddress("address2").withEmail("e-mail@mail.ru")
                .withAddress2("address3").withGroup("test1").withHome("Home1");
        int index = before.size()-1;
        app.contacts().initModification(index);
        app.contacts().fillForm(contact,false);
        app.contacts().submitModification();
        List<ContactsDate> after = app.contacts().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));

    }
}
