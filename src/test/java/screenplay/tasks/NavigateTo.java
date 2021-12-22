package screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.user_interface.N11HomePage;

public class NavigateTo {
    public static Performable theN11HomePage() {
        return Task.where("{0} opens the N11 home page",
                Open.browserOn().the(N11HomePage.class));
    }
}
