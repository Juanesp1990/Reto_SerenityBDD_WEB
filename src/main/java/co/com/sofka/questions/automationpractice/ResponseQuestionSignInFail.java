package co.com.sofka.questions.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeSignIn.MESSAGE_VALIDATION_SIGN_IN;

public class ResponseQuestionSignInFail implements Question {
    @Override
    public Boolean answeredBy (Actor actor) {
        return (MESSAGE_VALIDATION_SIGN_IN.resolveFor(actor).containsOnlyText("Authentication failed."));
    }

    public static ResponseQuestionSignInFail responseQuestionSignInFail(){
        return new ResponseQuestionSignInFail();
    }
}
