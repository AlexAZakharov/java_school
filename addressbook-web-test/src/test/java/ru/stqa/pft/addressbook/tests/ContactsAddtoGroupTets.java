package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.security.acl.Group;

public class ContactsAddtoGroupTets extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.db().groups("").size() ==0) {
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("test1").withHeader("test3"));
        }
        if (app.db().contacts().size()==0){
            app.contact().createContact(new ContactsDate()
                    .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW")
                    .withFirstname("Bobrov").withCompany("Company").withAddress("address")
                    .withEmail("e-mail@mail.ru").withAddress2("address"),false);
        }

    }

    @Test
    public void testContacttsAddtoGroup (){
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactsDate contactAdded = before.iterator().next();
        app.contact().selectContactById(contactAdded);
        Groups gbefore = app.db().groups("");
        GroupDate groupToAdded = gbefore.iterator().next();
        app.contact().selectAddedGroup(groupToAdded);
        app.contact().addtoGroup();
        //реализовать проверку попал ли контакт в выбранную группу - через БД
      // app.contact().gotoGroup();
       // app.goTo().homePage();
    }
}
