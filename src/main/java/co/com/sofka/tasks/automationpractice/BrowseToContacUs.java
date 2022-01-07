package co.com.sofka.tasks.automationpractice;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeContacUs.*;


public class BrowseToContacUs implements Task {
    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(CONTACT),
                Click.on(CONTACT)

        );
    }

    public static BrowseToContacUs browseToContacUs () {
        return new BrowseToContacUs();

    }
}
