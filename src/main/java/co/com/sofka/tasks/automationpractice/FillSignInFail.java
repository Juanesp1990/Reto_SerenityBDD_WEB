package co.com.sofka.tasks.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeSignIn.*;

public class FillSignInFail implements Task {
    private String email;
    private String password;

    public FillSignInFail withEmail (String email) {
        this.email=email;
        return this;
    }

    public FillSignInFail withPassword (String password) {
        this.password=password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(FILL_EMAIL),
                Enter.theValue(email).into(FILL_EMAIL),
                Enter.theValue(password).into(FILL_PASSWORD),
                Click.on(BUTTON_SUBMIT_LOGIN)
        );

    }

    public static FillSignInFail fillSignInFail(){
        return new FillSignInFail();
    }
}
