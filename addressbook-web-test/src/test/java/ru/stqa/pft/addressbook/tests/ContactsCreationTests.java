package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        GroupDate gd=new GroupDate().withName("test1").withHeader("test3");
        if (! app.group().groupExists(gd.getName())) {
            app.goTo().groupPage();
            app.group().create(gd);
        }

    }
    @Test
    public void testContactsCreation() {
        app.goTo().homePage();
        ContactsDate cd= new ContactsDate()
                .withMiddlename("A").withLastname("Alexandr").withNickname("WaveLW").withFirstname("Bobrov")
                .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                .withAddress2("address").withGroup("test1");
        Contacts before = app.contact().all();
        /*app.contact().creation();
        app.contact().fillForm(cd,true);
        app.contact().submitCreation();
        app.contact().gotoHomePage();*/
        app.contact().createContact(cd,true);

        Contacts after = app.contact().all();
        assertThat(after.size(),equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded(
                cd.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }




}
