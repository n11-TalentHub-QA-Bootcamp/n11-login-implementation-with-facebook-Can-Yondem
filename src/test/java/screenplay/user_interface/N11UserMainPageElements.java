package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class N11UserMainPageElements {
    public static final Target USER_ACC_LINK = Target.the("user main page account link").locatedBy(".menuLink.user");
    public static final Target CONTRACT_CHECK_BOX = Target.the("contract checkbox").locatedBy("#acceptContract");
    public static final Target MARKETIN_APPROVAL_CHECK_BOX = Target.the("marketing approval checkbox").locatedBy("#sendPromotionalMailAndSms");
    public static final Target CONTRACT_CONFIRM_BUTTON = Target.the("contract target button").locatedBy("#confirmBtn");
}
