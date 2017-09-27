package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactsRemoveFromGroupTest extends TestBase {
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
        app.contact().selectGroup();
        Contacts before = app.db().contacts();//указать группу
        ContactsDate contactRemoved = before.iterator().next();
        app.contact().selectContactById(contactRemoved);
        app.contact().removeContact();
        Contacts after = app.db().contacts();//указать группу
       // app.contact().gotoGroup(); можно опустить раз читаем напрямую из базы
    }
}
