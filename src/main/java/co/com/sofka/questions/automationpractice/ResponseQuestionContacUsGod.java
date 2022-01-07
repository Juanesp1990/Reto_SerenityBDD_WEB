package co.com.sofka.questions.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.automationpractice.AutomationPracticeContacUs.MESSA_GOD;

public class ResponseQuestionContacUsGod implements Question <Boolean>{
    @Override
    public Boolean answeredBy (Actor actor) {
        return (MESSA_GOD.resolveFor(actor).containsOnlyText("Your message has been successfully sent to our team."));
    }

    public static ResponseQuestionContacUsGod responseQuestionContacUsGod(){
        return new ResponseQuestionContacUsGod();
    }
}
