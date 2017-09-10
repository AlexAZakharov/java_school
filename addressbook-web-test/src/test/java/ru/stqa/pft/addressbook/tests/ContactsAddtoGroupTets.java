package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsAddtoGroupTets extends TestBase {

    @Test
    public void testContacttsAddtoGroup (){
        app.goTo().homePage();
        app.contacts().select(0);
        app.contacts().addtoGroup();
        app.contacts().gotoGroup();
        app.goTo().homePage();
    }
}
