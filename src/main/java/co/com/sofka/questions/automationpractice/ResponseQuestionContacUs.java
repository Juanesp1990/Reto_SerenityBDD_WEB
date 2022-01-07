package co.com.sofka.questions.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeContacUs.MESSAGE_ERROR;

public class ResponseQuestionContacUs implements Question {
    @Override
    public Boolean answeredBy (Actor actor) {
         return (MESSAGE_ERROR.resolveFor(actor).containsOnlyText("The message cannot be blank."));
    }

    public static ResponseQuestionContacUs responseQuestionContacUs(){
        return new ResponseQuestionContacUs();
    }
}
