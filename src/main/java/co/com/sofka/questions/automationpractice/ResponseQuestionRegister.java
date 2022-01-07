package co.com.sofka.questions.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeRegister.CUSTOMER_ACCOUNT;

public class ResponseQuestionRegister implements Question <Boolean>{

    private String firstname;
    private String lastname;

    public ResponseQuestionRegister wasFilledFirstname (String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ResponseQuestionRegister andWhitLastname (String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public Boolean answeredBy (Actor actor) {
        return (CUSTOMER_ACCOUNT.resolveFor(actor).containsOnlyText(firstname+" "+lastname));
    }

    public static ResponseQuestionRegister responseQuestionRegister(){
        return new ResponseQuestionRegister();
    }
}
