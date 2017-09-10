package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (! app.contact().isThereAContact()){
            app.contact().createContact(new ContactsDate()
                    .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW").withFirstname("Bobrov")
                    .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                    .withAddress2("address").withGroup("test1"),false);
        }
    }

    @Test
    public void testContactModification() {

        Set<ContactsDate> before = app.contact().all();
        ContactsDate contactModified = before.iterator().next();
        ContactsDate contact = new ContactsDate()
                .withId(contactModified.getId())
                .withMiddlename("A1").withLastname("Alexandr").withNickname("WaveLW").withFirstname("Zakharov")
                .withCompany("Company1").withAddress("address2").withEmail("e-mail@mail.ru")
                .withAddress2("address3").withGroup("test1").withHome("Home1");
        app.contact().initModification(contactModified);
        app.contact().fillForm(contact,false);
        app.contact().submitModification();
        Set<ContactsDate> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(contactModified);
        before.add(contact);
        Assert.assertEquals(after,before);

    }
}
