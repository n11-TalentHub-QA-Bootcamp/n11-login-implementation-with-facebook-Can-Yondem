package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class N11FacebookLoginWindowElements {
    public static final Target EMAIL_INPUT = Target.the("email input element").locatedBy("#email");
    public static final Target PASSWORD_INPUT = Target.the("password input element").locatedBy("#pass");
    public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("[name=login]");
}
