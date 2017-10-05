package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangeOfPasswordTest extends  TestBase {
    @Test
    public void testChangeOfPassword() throws IOException, MessagingException, InterruptedException {

        // Администратор входит в систему
        app.navigatiom().login("administrator","root");
        // переходит на страницу управления пользователями
        app.navigatiom().control();
        app.control().userControl();
        // выбирает заданного пользователя и нажимает кнопку Reset Password
        //
        app.db().users();
        String username ="";
        String password ="";
        String email ="";
        app.control().editUser(username);
        app.control().resetPassword();
        // тесты получают письмо
        List<MailMessage> mailMessages =app.mail().waitForMail(2,10000);
        // извлекаю ссылку для смены пароля
        String confermationLinK = findConfermationLinK(mailMessages, email);
        // пройти по ссылке и изменить пароль.
        app.registrarion().finish(confermationLinK, password);
        assertTrue(app.newSession().login(username,password));
        // проверить новый пароль
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator","root"));
    }
    private String findConfermationLinK(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
}
