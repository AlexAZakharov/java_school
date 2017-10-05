package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ControlHelper extends HelperBase {

    public ControlHelper(ApplicationManager app) {
        super(app);
    }

    public void userControl() {
        click(By.xpath(".//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a"));
    }

    public void editUser(String username) {
        type(By.xpath(".//*[@id='username']"), username);
        click(By.xpath(".//*[@id=\"manage-user-edit-form\"]/input[2]"));
    }

    public void resetPassword() {
        click(By.xpath("//*[@id=\"manage-user-reset-form\"]/fieldset/span/input"));
    }
}
