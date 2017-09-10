package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test1", null, "test3"));
        }
    }

    @Test
    public void testsGroupModificarion() {

        List<GroupDate> before = app.getGroupHelper().getGroupList();
        int index = before.size()-1;
        GroupDate group = new GroupDate(before.get(index).getId(),"test5", "test6", "test7");
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(group);
        /*Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));*/
        Comparator<? super GroupDate> byId = (g1, g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }


}
