package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCiunt();
        app.getGroupHelper().createGroup(new GroupDate("test1", null, "test3"));
        int after = app.getGroupHelper().getGroupCiunt();
        Assert.assertEquals(after,before+1);
    }

}
