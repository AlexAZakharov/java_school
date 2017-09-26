package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if ( app.db().groups().size() ==0){
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("test1").withHeader("test3"));
        }
    }

    @Test
    public void testsGroupDelete() {

        Groups before = app.db().groups();
        GroupDate deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertEquals(app.group().count(),before.size()-1);
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
        verifyGroupListInUi();

    }


}
