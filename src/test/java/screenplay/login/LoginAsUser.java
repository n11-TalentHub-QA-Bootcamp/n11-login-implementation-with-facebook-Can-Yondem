package screenplay.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import screenplay.user_interface.N11FacebookLoginWindowElements;
import screenplay.user_interface.N11HomePageElements;
import screenplay.user_interface.N11LoginPageElements;
import screenplay.user_interface.N11UserMainPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class LoginAsUser implements Task{
    private final String email;
    private final String password;

    public LoginAsUser(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(N11HomePageElements.LOGIN_BTN),
                WaitUntil.the(N11LoginPageElements.FACEBOOK_LOGIN_BTN,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(N11LoginPageElements.FACEBOOK_LOGIN_BTN),
                Switch.toNewWindow(), //Facebook login sayfasına geçiş
                // Facebook login
                Click.on(N11FacebookLoginWindowElements.EMAIL_INPUT),
                SendKeys.of(this.email).into(N11FacebookLoginWindowElements.EMAIL_INPUT),
                Click.on(N11FacebookLoginWindowElements.PASSWORD_INPUT),
                SendKeys.of(this.password).into(N11FacebookLoginWindowElements.PASSWORD_INPUT),
                Click.on(N11FacebookLoginWindowElements.LOGIN_BUTTON),
                Switch.toNewWindow(), //N11 sayfasına geçiş
                //Giriş yaptıktan sonra gelen kullanıcı sözleşmesi popup'ının onayı
                WaitUntil.the(N11UserMainPageElements.CONTRACT_CHECK_BOX,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(N11UserMainPageElements.CONTRACT_CHECK_BOX),
                Click.on(N11UserMainPageElements.MARKETIN_APPROVAL_CHECK_BOX),
                Click.on(N11UserMainPageElements.CONTRACT_CONFIRM_BUTTON),
                Click.on(N11UserMainPageElements.CONTRACT_POPUP_CLOSE_BUTTON),
                WaitUntil.the(N11UserMainPageElements.USER_ACC_LINK,isClickable()).forNoMoreThan(5).seconds()
        );
    }

    public static LoginAsUser loginThePage(String emailText, String passwordText){
        return instrumented(
                LoginAsUser.class,
                emailText,
                passwordText
        );
    }


}
