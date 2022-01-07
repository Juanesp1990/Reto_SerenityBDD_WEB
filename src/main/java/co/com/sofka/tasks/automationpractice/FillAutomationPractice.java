package co.com.sofka.tasks.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeContacUs.*;

public class FillAutomationPractice implements Task {

    private String email;
    private String message;

    public FillAutomationPractice withEmail (String email) {
        this.email=email;
        return this;
    }

    public FillAutomationPractice withMessage (String message) {
        this.message=message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(SELEC_TYPE),
                Click.on(SELEC_TYPE),
                Click.on(CUSTOMER_SERVICE),
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(message).into(MESSAGE_CONTAC_US),
                Click.on(BUTTON_SEND)

        );

    }

    public static FillAutomationPractice fillAutomationPractice() {
        return new FillAutomationPractice();

    }
}
