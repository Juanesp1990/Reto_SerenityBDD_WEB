package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.models.automationpractice.ContacUs;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;


import static co.com.sofka.questions.automationpractice.ResponseQuestionContacUs.responseQuestionContacUs;
import static co.com.sofka.questions.automationpractice.ResponseQuestionContacUsGod.responseQuestionContacUsGod;
import static co.com.sofka.tasks.OpenPageInit.openPageInit;
import static co.com.sofka.tasks.automationpractice.BrowseToContacUs.browseToContacUs;
import static co.com.sofka.tasks.automationpractice.FillAutomationPractice.fillAutomationPractice;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContacUsStepDefinition extends Setup {
    public static Logger LOGGER = Logger.getLogger(ContacUsStepDefinition.class);
    private static final String ACTOR_NAME = "Juanes";
    private ContacUs contacUs;
    private ContacUs contaUsGod;

    @Given("el cliente se encuentra en la página de inicio")
    public void elClienteSeEncuentraEnLaPaginaDeInicio () {
        try {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openPageInit()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("el cliente navega hasta el formulario de contáctenos")
    public void elClienteNavegaHastaElFormularioDeContactenos () {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToContacUs()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("ingresa la información incompleta y presiona el botón enviar")
    public void ingresaLaInformacionIncompletaYPresionaElBotonEnviar () {
        loadMessageBad();
        try {
            theActorInTheSpotlight().attemptsTo(
                    fillAutomationPractice()
                            .withEmail(contacUs.getEmail())
                            .withMessage(contacUs.getMessage())
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }

    @Then("la página debería mostrar un mensaje de error")
    public void laPaginaDeberiaMostrarUnMensajeDeError () {
        try {
            theActorInTheSpotlight().should(seeThat(
                            responseQuestionContacUs(), equalTo(true)
                    )

            );
            LOGGER.info("Comparación Exitosa");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }
    }

    @Given("el clientre se encuentra en la página inicial")
    public void elClientreSeEncuentraEnLaPaginaInicial () {
        try {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openPageInit()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("el cliente navega hasta la opción contáctenos")
    public void elClienteNavegaHastaLaOpcionContactenos () {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToContacUs());
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("ingresa la información completa y presiona el botón enviar")
    public void ingresaLaInformacionCompletaYPresionaElBotonEnviar () {
        loadMessageGod();
        try {
            theActorInTheSpotlight().attemptsTo(
                    fillAutomationPractice()
                            .withEmail(contaUsGod.getEmail())
                            .withMessage(contaUsGod.getMessage())
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @Then("la página debería indicarle la recepción del mensaje")
    public void laPaginaDeberiaIndicarleLaRecepcionDelMensaje () {
        try {
            theActorInTheSpotlight().should(seeThat(
                            responseQuestionContacUsGod(), equalTo(true)
                    )

            );
            LOGGER.info("Comparación Exitosa");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

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
