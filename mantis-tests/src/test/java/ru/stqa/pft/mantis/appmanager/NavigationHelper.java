package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ApplicationManager app) {
            super(app);
    }

    public void login (String username, String password) {
        wd.get(app.getProperty("web.urlBase") + "/login_page.php");
        type(By.xpath("//input[@name='username']"),username);
        click(By.xpath("//input[@type='submit']"));
        type(By.xpath("//input[@name='password']"), password);
        click(By.xpath("//input[@type='submit']"));
    }

    public void control() {
        click(By.xpath(".//*[@id='sidebar']/ul/li[7]/a/i"));
    }
}
