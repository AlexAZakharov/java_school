package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.List;

public class ContactsDeleteTests extends TestBase {

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
    public void testContactsDelete() {

      List<ContactsDate> before = app.contacts().list();
      int index = before.size()-1;
      app.contacts().select(index);
      app.contacts().delete();
      List<ContactsDate> after = app.contacts().list();
      Assert.assertEquals(after.size(),before.size()-1);

      before.remove(index);
      Assert.assertEquals(before,after);
    }
}
