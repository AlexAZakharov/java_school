package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactsDeleteTests extends TestBase {

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
    public void testContactsDelete() {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      ContactsDate contactDeleted = before.iterator().next();
      app.contact().selectContactById(contactDeleted);
      app.contact().delete();
      Contacts after = app.contact().all();
      assertEquals(after.size(),before.size()-1);
      assertThat(after, equalTo(before.without(contactDeleted)));
    }
}
