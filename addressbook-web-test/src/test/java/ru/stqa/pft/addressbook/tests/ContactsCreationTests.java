package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

        ContactsDate cd= new ContactsDate()
                .withMiddlename("A").withLastname("Alexandr").withNickname("WaveLW").withFirstname("Bobrov")
                .withCompany("Company").withAddress("address").withEmail("e-mail@mail.ru")
                .withAddress2("address").withGroup("test1");

        Contacts before = app.contact().all();
        app.contact().creation();
        app.contact().fillForm(cd,true);
        app.contact().submitCreation();
        app.contact().gotoHomePage();
        Set<ContactsDate> after = app.contact().all();
        assertThat(after.size(),equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded(
                cd.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }




}
