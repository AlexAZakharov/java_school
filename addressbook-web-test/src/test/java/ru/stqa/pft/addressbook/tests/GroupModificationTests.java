package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupModificationTests extends TestBase {

    @Test
    public void testsGroupModificarion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModofocation();
        app.getGroupHelper().fillGroupForm(new GroupDate("test1", "test2", "test3"));
        app.getGroupHelper().submitGorupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
