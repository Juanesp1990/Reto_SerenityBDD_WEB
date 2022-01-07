package co.com.sofka.tasks.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeSignIn.BUTTON_SIGN_IN;

public class BrowseToSingIn implements Task {

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(BUTTON_SIGN_IN),
                Click.on(BUTTON_SIGN_IN)

        );
    }


    public static BrowseToSingIn browseToSingIn (){
        return new BrowseToSingIn();
    }
}
