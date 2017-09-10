package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsAddtoGroupTets extends TestBase {

    @Test
    public void testContacttsAddtoGroup (){
        app.goTo().homePage();
        app.contact().select(0);
        app.contact().addtoGroup();
        app.contact().gotoGroup();
        app.goTo().homePage();
    }
}
