package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Group")
                && isElementPresent((By.name("new")))){
            return;
        }
        click(By.linkText("groups"));
    }


    public void homePage() {
        if (isElementPresent(By.xpath("//table[@id='maintable']"))){
            if (isElementPresent(By.xpath(".//input[@name='remove']"))) {
                new Select(wd.findElement(By.xpath(".//select[@name='group']"))).selectByVisibleText("[all]");
            }   else return;
        }
        click(By.linkText("home"));
    }
}
