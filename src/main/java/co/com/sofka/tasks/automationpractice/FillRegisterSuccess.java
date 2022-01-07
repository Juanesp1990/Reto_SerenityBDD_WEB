package co.com.sofka.tasks.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeRegister.*;

public class FillRegisterSuccess implements Task {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String codePostal;
    private String mobilePhone;

    public FillRegisterSuccess wasFilledFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillRegisterSuccess andWithLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillRegisterSuccess andWithEmail (String email) {
        this.email = email;
        return this;
    }

    public FillRegisterSuccess andWithPassword (String password) {
        this.password = password;
        return this;
    }

    public FillRegisterSuccess andWithAddress (String address) {
        this.address = address;
        return this;
    }

    public FillRegisterSuccess andWithCity (String city) {
        this.city = city;
        return this;
    }

    public FillRegisterSuccess andWithCodePostal (String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public FillRegisterSuccess andWithMobilePhone (String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Override
    public <T extends Actor> void performAs (T actor) {
        actor.attemptsTo(
                Scroll.to(FILL_EMAIL_CREATE),
                Enter.theValue(email).into(FILL_EMAIL_CREATE),
                Click.on(BUTTON_CREATE_ACCONT),

                Scroll.to(FIRST_NAME),
                Enter.theValue(firstName).into(FIRST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),
                Enter.theValue(password).into(FILL_PASSWORD),
                Scroll.to(FILL_ADDRESS),
                Enter.theValue(address).into(FILL_ADDRESS),
                Enter.theValue(city).into(FILL_CITY),
                Scroll.to(FILL_STATE),
                Click.on(FILL_STATE),
                Click.on(STATE_FLORIDA),
                Enter.theValue(codePostal).into(CODE_POSTAL),
                Scroll.to(MOBILE_PHONE),
                Enter.theValue(mobilePhone).into(MOBILE_PHONE),
                Click.on(BUTTON_REGISTER)
        );

    }

    public static FillRegisterSuccess fillRegisterSuccess () {
        return new FillRegisterSuccess();
    }
}
