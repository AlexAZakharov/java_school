package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteGroup() {
        click(By.xpath(".//*[@name='delete']"));
    }

    public void initGroupModofocation() {
        click(By.xpath(".//*[@name='edit']"));
    }

    public void submitGorupModification() {
        click(By.xpath(".//*[@name='update']"));
    }

    public void createGroup(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void modifyGroup(int index, GroupDate group) {
        selectGroup(index);
        initGroupModofocation();
        fillGroupForm(group);
        submitGorupModification();
        returnToGroupPage();
    }

    public boolean groupExists(String groupName) {
        click(By.linkText("home"));
        return isElementSelectTextPresent(By.name("to_group"), groupName);
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath(".//*[@id='content']/form/span[1]/input"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupDate> getGroupList() {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        List<WebElement> elements = wd.findElements(By.xpath(".//span[@class='group']"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDate group = new GroupDate(id,name,null,null);
            groups.add(group);
        }
        return groups;

    }
}
