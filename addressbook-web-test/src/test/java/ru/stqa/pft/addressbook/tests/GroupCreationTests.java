package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {
        app.goTo().groupPage();
        Set<GroupDate> before = app.group().all();

        GroupDate gd = new GroupDate().withName("test1").withHeader("test3");

        app.group().create(gd);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(),before.size()+1);

        gd.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(gd);
        Assert.assertEquals(after,before);
    }

}
