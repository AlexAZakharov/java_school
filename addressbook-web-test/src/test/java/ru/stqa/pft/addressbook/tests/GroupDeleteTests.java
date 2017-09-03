package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testsGroupDelete() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCiunt();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test1", null, "test3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCiunt();
        if (before == 0){before=1;}
        Assert.assertEquals(after,before-1);
    }
}
