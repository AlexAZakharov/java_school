package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(By.xpath("//div[@id='content']/form/input[4]"));
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void deleteSelectedGroup() {
        click(By.xpath(".//*[@name='delete']"));
    }

    public void delete(GroupDate group) {
        selectGroupById(group.getId());
        deleteSelectedGroup();
        groupCash = null;
        returnToGroupPage();
    }

    public void initGroupModofocation() {
        click(By.xpath(".//*[@name='edit']"));
    }

    public void submitGorupModification() {
        click(By.xpath(".//*[@name='update']"));
    }

    public void create(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCash = null;
        returnToGroupPage();
    }

    public void modify(GroupDate group) {
        selectGroupById(group.getId());
        initGroupModofocation();
        fillGroupForm(group);
        submitGorupModification();
        groupCash = null;
        returnToGroupPage();
    }

    public boolean groupExists(String groupName) {
        click(By.linkText("home"));
        return isElementSelectTextPresent(By.name("to_group"), groupName);
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath(".//*[@id='content']/form/span[1]/input"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

 /*   public List<GroupDate> list() {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        List<WebElement> elements = wd.findElements(By.xpath(".//span[@class='group']"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDate group = new GroupDate().withId(id).withName(name);
            groups.add(group);
        }
        return groups;
    }*/
    private Groups groupCash = null;

    public Groups all() {
        if(groupCash != null){
         return new Groups(groupCash);
        }
        groupCash= new Groups();
        List<WebElement> elements = wd.findElements(By.xpath(".//span[@class='group']"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDate group = new GroupDate().withId(id).withName(name);
            groupCash.add(group);
        }
        return new Groups(groupCash);
    }


}
