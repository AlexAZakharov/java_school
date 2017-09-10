package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.Set;

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

      Set<ContactsDate> before = app.contact().all();
      ContactsDate contactDeleted = before.iterator().next();
      app.contact().selectContactById(contactDeleted);
      app.contact().delete();
      Set<ContactsDate> after = app.contact().all();
      Assert.assertEquals(after.size(),before.size()-1);

      before.remove(contactDeleted);
      Assert.assertEquals(before,after);
    }
}
