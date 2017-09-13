package ru.stqa.pft.addressbook.tests;

import org.junit.Before;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsAddressTest extends TestBase {


    @Before
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactsDate()
                    .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW").withFirstname("Bobrov")
                    .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                    .withAddress2("address").withGroup("test1"), false);
        }
    }

    @Test
    public void testContactEmail() {
        app.goTo().homePage();
        ContactsDate contact = app.contact().all().iterator().next();
        ContactsDate contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

    }

}
