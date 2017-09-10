package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;
import java.util.Set;

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

        Set<GroupDate> before = app.group().all();
        GroupDate deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(deletedGroup);
        Assert.assertEquals(after,before);

    }


}
