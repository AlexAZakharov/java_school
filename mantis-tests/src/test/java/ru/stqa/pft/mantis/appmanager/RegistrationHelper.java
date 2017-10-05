package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.urlBase") + "/signup_page.php");
        type(By.xpath("//input[@name='username']"),username);
        type(By.xpath("//input[@name='email']"),email);
        click(By.xpath("//input[@type='submit']"));
    }

    public void finish(String confermationLinK, String password) {
        wd.get(confermationLinK);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.xpath("//*[@type='submit']"));
    }
}
