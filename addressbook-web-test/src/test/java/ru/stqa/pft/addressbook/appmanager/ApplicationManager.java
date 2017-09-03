package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    private  SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  ContactsHelper contactsHelper;
    private  GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if (browser == BrowserType.FIREFOX){
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser == BrowserType.CHROME){
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactsHelper = new ContactsHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() { return groupHelper; }

    public ContactsHelper getContactsHelper() {
        return contactsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
