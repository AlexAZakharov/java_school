package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class RegistrationTest extends  TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }
    @Test
    public void testRegistration() throws InterruptedException, MessagingException, IOException {
        long now =System.currentTimeMillis();
        String email = String.format("user%s@localhost.localdomain",now);
        String user = "user"+now;
        String password = "password";
        app.registrarion().start(user, email);
        List<MailMessage> mailMessages =app.mail().waitForMail(2,10000);
        String confermationLinK = findConfermationLinK(mailMessages, email);
        app.registrarion().finish(confermationLinK, password);
        assertTrue(app.newSession().login(user,password));

    }


    private String findConfermationLinK(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
