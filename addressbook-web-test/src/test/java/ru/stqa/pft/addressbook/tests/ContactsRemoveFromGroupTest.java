package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsRemoveFromGroupTest extends TestBase {

    @DataProvider
    private GroupDate validGroup() {

        Groups gb = app.db().groups("");
        GroupDate groupForContatcRemove =null;
        //проходим по группам и ищем есть ли там добавленные контакты если есть то берем группу и выходит на сам тест
        for (GroupDate group : gb) {
            Contacts contacts = group.getContacts();
            if (contacts.size() > 0) {
                groupForContatcRemove = group;
                break;
            }
        }
        if (groupForContatcRemove==null) {
            //если нет в группах контактов то проверяем есть ли вообще группы и если нет создаем
            if (app.db().groups("").size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupDate().withName("test1").withHeader("test3"));
            }
            //проверяем есть ли контакты, если нет то добавляем
            if (app.db().contacts().size() == 0) {
                app.contact().createContact(new ContactsDate()
                        .withMiddlename("A").withLastname("Ivan").withNickname("WaveLW")
                        .withFirstname("Bobrov").withCompany("Company").withAddress("address")
                        .withEmail("e-mail@mail.ru").withAddress2("address"), false);
            }
            app.goTo().homePage();
            Contacts before = app.db().contacts();
            ContactsDate contactAdded = before.iterator().next();
            //Выбрал произвольный контак
            app.contact().selectContactById(contactAdded);
            Groups gbefore = app.db().groups("");
            GroupDate groupToAdded = gbefore.iterator().next();
            //выбрал произвльную группу
            app.contact().selectAddedGroup(groupToAdded);
            app.contact().addtoGroup();
            groupForContatcRemove = groupToAdded;
        }

        return groupForContatcRemove;
    }



    @Test (dataProvider = "validGroup")
    public void testContactsRemoveFromGroup (GroupDate groupForContatcRemove){
        app.goTo().homePage();
        app.contact().selectGroup(groupForContatcRemove);
        //создаем множество контактов из вбранной группы
        Contacts before = groupForContatcRemove.getContacts();
        //выбираем произвольный контакт из множества в группе
        ContactsDate contactRemoved = before.iterator().next();
        //выделяем контакт
        app.contact().selectContactById(contactRemoved);
        //удаляем из группы
        app.contact().removeContact();
        //создаем множество контактов выбранной группы после удаления
        Contacts after = groupForContatcRemove.getContacts();
        assertThat(after, equalTo(before.without(contactRemoved)));

    }
}
