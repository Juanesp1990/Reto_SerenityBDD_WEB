package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.models.automationpractice.Register;
import co.com.sofka.models.automationpractice.SignIn;
import co.com.sofka.stepdefinition.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.util.Locale;

import static co.com.sofka.questions.automationpractice.ResponseQuestionRegister.responseQuestionRegister;
import static co.com.sofka.questions.automationpractice.ResponseQuestionSignInFail.responseQuestionSignInFail;
import static co.com.sofka.tasks.OpenPageInit.openPageInit;
import static co.com.sofka.tasks.automationpractice.BrowseToSingIn.browseToSingIn;
import static co.com.sofka.tasks.automationpractice.FillRegisterSuccess.fillRegisterSuccess;
import static co.com.sofka.tasks.automationpractice.FillSignInFail.fillSignInFail;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SingInStepDefinition extends Setup {
    public static Logger LOGGER = Logger.getLogger(ContacUsStepDefinition.class);
    private static final String ACTOR_NAME = "Juanes";
    private Register register;

    @Given("el cliente se encuentra en la página inicial de automatización")
    public void elClienteSeEncuentraEnLaPaginaInicialDeAutomatizacion () {
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

    @When("el cliente navega hasta la opcion de inicio de sesión")
    public void elClienteNavegaHastaLaOpcionDeInicioDeSesion () {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToSingIn()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("ingresa datos que no están registrados")
    public void ingresaDatosQueNoEstanRegistrados () {
        SignIn signIn;
        signIn = fillSignIn();
        try {
            theActorInTheSpotlight().attemptsTo(
                    fillSignInFail()
                            .withEmail(signIn.getEmail())
                            .withPassword(signIn.getPassword())
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @Then("la página deberá mostrar un mensaje de ingreso fallido")
    public void laPaginaDeberaMostrarUnMensajeDeIngresoFallido () {
        try {
            theActorInTheSpotlight().should(
                    seeThat(responseQuestionSignInFail(), equalTo(true))
            );
            LOGGER.info("Comparación Exitosa");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @Given("el cliente se encuentra en la página principal")
    public void elClienteSeEncuentraEnLaPaginaPrincipal () {
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

    @When("el cliente navega hasta inicio de sesión")
    public void elClienteNavegaHastaInicioDeSesion () {
        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToSingIn()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @When("selecciona registrarse, llenar su información y presiona registrarse")
    public void seleccionaRegistrarseLlenarSuInformacionYPresionaRegistrarse () {
        register = new Register();
        register = fillRegister();
        try {
            theActorInTheSpotlight().attemptsTo(
                    fillRegisterSuccess()
                            .wasFilledFirstName(register.getFirstName())
                            .andWithLastName(register.getLastName())
                            .andWithEmail(register.getEmail())
                            .andWithPassword(register.getPassword())
                            .andWithAddress(register.getAddress())
                            .andWithCity(register.getCity())
                            .andWithCodePostal(register.getCodePostal())
                            .andWithMobilePhone(register.getMobilePhone())
            );

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    @Then("la página deberá mostrar el nombre registrado en la parte superior de la página")
    public void laPaginaDeberaMostrarElNombreRegistradoEnLaParteSuperiorDeLaPagina () {
        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            responseQuestionRegister()
                                    .wasFilledFirstname(register.getFirstName())
                                    .andWhitLastname(register.getLastName()), equalTo(true)
                    )
            );
            LOGGER.info("Comparación Exitosa");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("");
        }

    }

    private SignIn fillSignIn () {
        SignIn newSignIn = new SignIn();
        Faker faker = new Faker(new Locale("en-US"));
        newSignIn.setEmail(
                faker.name().firstName()
                        + "_22_"
                        + faker.name().lastName()
                        + "@Hijmail.com"
        );

        newSignIn.setPassword(
                faker.bothify("??????####")
        );

        return newSignIn;
    }

    private Register fillRegister () {
        Register newRegister = new Register();
        Faker faker = new Faker(new Locale("en-US"));

        newRegister.setFirstName(faker.name().firstName());
        newRegister.setLastName(faker.name().lastName());
        newRegister.setEmail(
                newRegister.getFirstName()
                        + newRegister.getLastName()
                        + "123@zoho.com"
        );
        newRegister.setPassword(faker.bothify("????###"));
        newRegister.setAddress("5744 W 77th St, Burbank, IL 60459,");
        newRegister.setCity("Burbank");
        newRegister.setCodePostal(faker.bothify("#####"));
        newRegister.setMobilePhone(faker.bothify("##########"));
        return newRegister;
    }

}
