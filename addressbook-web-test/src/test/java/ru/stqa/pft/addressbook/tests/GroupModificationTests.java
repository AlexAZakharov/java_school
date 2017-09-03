package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupModificationTests extends TestBase {

    @Test
    public void testsGroupModificarion() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCiunt();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test1", null, "test3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModofocation();
        app.getGroupHelper().fillGroupForm(new GroupDate("test5", "test6", "test7"));
        app.getGroupHelper().submitGorupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCiunt();
        if (before == 0){before=1;}
        Assert.assertEquals(after,before);
    }
}
