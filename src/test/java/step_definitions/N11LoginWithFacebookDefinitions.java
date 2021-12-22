package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.login.LoginAsUser;
import screenplay.tasks.NavigateTo;
import screenplay.user_interface.N11UserMainPageElements;

public class N11LoginWithFacebookDefinitions{
    Actor actor = Actor.named("onur");

    @Managed
    WebDriver webDriver;

    @Given("User navigate to N11 homepage")
    public void userNavigateToN11HomePage() {
        actor.can(BrowseTheWeb.with(webDriver)); //Webdriver'ı ayağa kaldırma
        actor.wasAbleTo(NavigateTo.theN11HomePage()); //Webdriver'ı N11'in ana sayfasına yönlendirme
    }

    @When("User enter valid credentials {string} and {string} with facebook in login page")
    public void userEnterValidCredentialsWithFacebook(String email, String password) {
        //Facebook ile login olabilmek için aksiyonların olduğu metodu çağırıp parametrelerini verdik.
        actor.attemptsTo(LoginAsUser.loginThePage(email, password));
    }

    @Then("User should see email {string} in main page")
    public void userShouldSeeEmailInMainPage(String email) {
        actor.attemptsTo(
                //Giriş yaptığımızı doğrulamak için hesabım yazısı altındaki email giriş yaptığımız email ile eşleşiyor mu diye kontrolünü yaptık.
                Ensure.that(N11UserMainPageElements.USER_ACC_LINK).hasText(email)
        );
    }
}
