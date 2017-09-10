package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(new GroupDate().withName("test1").withHeader("test3"));
        }
    }

    @Test
    public void testsGroupModificarion() {

        Set<GroupDate> before = app.group().all();
        GroupDate modifiedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("test5").withFooter( "test6").withHeader("test7");
        app.group().modify(group);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifiedGroup);
        before.add(group);
        /*Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));*/
         Assert.assertEquals(after,before);
    }


}
