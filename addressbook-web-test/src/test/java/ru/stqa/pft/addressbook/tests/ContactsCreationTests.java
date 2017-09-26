package ru.stqa.pft.addressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactsDate.class);
            List<ContactsDate> contacts = (List<ContactsDate>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        GroupDate gd=new GroupDate().withName("test1").withHeader("test3");
        if (! app.group().groupExists(gd.getName())) {
            app.goTo().groupPage();
            app.group().create(gd);
        }

    }
    @Test (dataProvider = "validContacts")
    public void testContactsCreation( ContactsDate cd) {
        app.goTo().homePage();
        File photo = new File("src/test/resources/i.jpg");
        Contacts before = app.db().contacts();
        app.contact().createContact(cd,true);
        assertThat(app.contact().count(),equalTo(before.size()+1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withAdded(
                cd.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
        verifyContactListInUi();
    }
}
