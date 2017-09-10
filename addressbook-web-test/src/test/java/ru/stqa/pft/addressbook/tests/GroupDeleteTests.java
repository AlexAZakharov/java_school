package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(new GroupDate().withName("test1").withHeader("test3"));
        }
    }

    @Test
    public void testsGroupDelete() {

        List<GroupDate> before = app.group().list();
        int index = before.size()-1;
        app.group().select(index);
        app.group().delete();
        app.group().returnToGroupPage();
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(index);
        Assert.assertEquals(after,before);

    }
}
