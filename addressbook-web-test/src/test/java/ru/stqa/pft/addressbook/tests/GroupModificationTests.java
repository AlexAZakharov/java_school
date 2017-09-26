package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if (app.db().groups("").size() ==0){
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("test1").withHeader("test3"));
        }
    }

    @Test
    public void testsGroupModificarion() {

        Groups before = app.db().groups("");
        GroupDate modifiedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("test5").withFooter( "test6").withHeader("test7");
        app.goTo().groupPage();
        app.group().modify(group);
        assertEquals(app.group().count(),before.size());
        Groups after = app.db().groups("");
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
        verifyGroupListInUi();
    }


}
