package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupHelper extends HelperBase {

    public GroupHelper(FirefoxDriver wd) {
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

    public void selectGroup() {
        click(By.xpath(".//*[@id='content']/form/span[1]/input"));
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
}
