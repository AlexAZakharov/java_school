package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {
        app.goTo().groupPage();
        List<GroupDate> before = app.group().list();

        GroupDate gd = new GroupDate("test1", null, "test3");

        app.group().create(gd);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(),before.size()+1);

      //  gd.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(gd);

        Comparator<? super GroupDate> byId = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
      //  Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));
        Assert.assertEquals(after,before);
    }

}
