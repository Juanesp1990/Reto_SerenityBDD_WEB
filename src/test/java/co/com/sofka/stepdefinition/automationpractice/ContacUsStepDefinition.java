package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.models.automationpractice.ContacUs;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.questions.automationpractice.ResponseQuestionContacUs.responseQuestionContacUs;
import static co.com.sofka.questions.automationpractice.ResponseQuestionContacUsGod.responseQuestionContacUsGod;
import static co.com.sofka.tasks.OpenPageInit.openPageInit;
import static co.com.sofka.tasks.automationpractice.BrowseToContacUs.browseToContacUs;
import static co.com.sofka.tasks.automationpractice.FillAutomationPractice.fillAutomationPractice;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContacUsStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Juanes";
    private ContacUs contacUs;
    private ContacUs contaUsGod;

    @Given("el cliente se encuentra en la página de inicio")
    public void elClienteSeEncuentraEnLaPaginaDeInicio () {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openPageInit()
        );

    }

    @When("el cliente navega hasta el formulario de contáctenos")
    public void elClienteNavegaHastaElFormularioDeContactenos () {
        theActorInTheSpotlight().attemptsTo(
                browseToContacUs()
        );

    }

    @When("ingresa la información incompleta y presiona el botón enviar")
    public void ingresaLaInformacionIncompletaYPresionaElBotonEnviar () {
        loadMessageBad();
        theActorInTheSpotlight().attemptsTo(
                fillAutomationPractice()
                        .withEmail(contacUs.getEmail())
                        .withMessage(contacUs.getMessage())
        );

    }

    @Then("la página debería mostrar un mensaje de error")
    public void laPaginaDeberiaMostrarUnMensajeDeError () {
        theActorInTheSpotlight().should(seeThat(
                        responseQuestionContacUs(), equalTo(true)
                )

        );

    }

    @Given("el clientre se encuentra en la página inicial")
    public void elClientreSeEncuentraEnLaPaginaInicial () {

        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openPageInit()
        );

    }

    @When("el cliente navega hasta la opción contáctenos")
    public void elClienteNavegaHastaLaOpcionContactenos () {
        theActorInTheSpotlight().attemptsTo(
                browseToContacUs());

    }

    @When("ingresa la información completa y presiona el botón enviar")
    public void ingresaLaInformacionCompletaYPresionaElBotonEnviar () {
        loadMessageGod();
        theActorInTheSpotlight().attemptsTo(
                fillAutomationPractice()
                        .withEmail(contaUsGod.getEmail())
                        .withMessage(contaUsGod.getMessage())
        );

    }

    @Then("la página debería indicarle la recepción del mensaje")
    public void laPaginaDeberiaIndicarleLaRecepcionDelMensaje () {
        theActorInTheSpotlight().should(seeThat(
                        responseQuestionContacUsGod(), equalTo(true)
                )

        );


    }

    private void loadMessageBad () {
        contacUs = new ContacUs();
        contacUs.setEmail("carlitos_123@gmail.com");
        contacUs.setMessage("");

    }

    private void loadMessageGod () {
        contaUsGod = new ContacUs();
        contaUsGod.setEmail("carlitos_123@gmail.com");
        contaUsGod.setMessage("No llegaron las tallas correctas para todas las prendas");

    }

}
