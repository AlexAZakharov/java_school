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
        //(! app.contact().isThereAContact())
        if (app.db().contacts().size()==0){
            app.goTo().homePage();
            app.contact().createContact(new ContactsDate()
                    .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW").withFirstname("Bobrov")
                    .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                    .withAddress2("address"),false);
        }
    }

    @Test
    public void testContactsDelete() {
      app.goTo().homePage();
      Contacts before = app.db().contacts();
      ContactsDate contactDeleted = before.iterator().next();
      app.contact().delete(contactDeleted);
      assertEquals(app.contact().count(),before.size()-1);
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.without(contactDeleted)));
      verifyContactListInUi();
    }

}
