package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testsGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupDate gd = new GroupDate().withName("test1").withHeader("test3");
        app.group().create(gd);
        assertThat(app.group().count(),equalTo(before.size()+1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(gd.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
