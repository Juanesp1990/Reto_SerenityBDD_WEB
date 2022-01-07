package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.models.automationpractice.Register;
import co.com.sofka.models.automationpractice.SignIn;
import co.com.sofka.stepdefinition.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    private static final String ACTOR_NAME = "Juanes";
    private SignIn signIn;
    private Register register;

    @Given("el cliente se encuentra en la página inicial de automatización")
    public void elClienteSeEncuentraEnLaPáginaInicialDeAutomatización () {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openPageInit()
        );

    }

    @When("el cliente navega hasta la opcion de inicio de sesión")
    public void elClienteNavegaHastaLaOpcionDeInicioDeSesión () {
        theActorInTheSpotlight().attemptsTo(
                browseToSingIn()
        );

    }

    @When("ingresa datos que no están registrados")
    public void ingresaDatosQueNoEstánRegistrados () {
        signIn = new SignIn();
        signIn = fillSignIn();
        theActorInTheSpotlight().attemptsTo(
                fillSignInFail()
                        .withEmail(signIn.getEmail())
                        .withPassword(signIn.getPassword())
        );

    }

    @Then("la página deberá mostrar un mensaje de ingreso fallido")
    public void laPáginaDeberáMostrarUnMensajeDeIngresoFallido () {
        theActorInTheSpotlight().should(
                seeThat(responseQuestionSignInFail(), equalTo(true))
        );

    }

    @Given("el cliente se encuentra en la página principal")
    public void elClienteSeEncuentraEnLaPáginaPrincipal () {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openPageInit()
        );
    }

    @When("el cliente navega hasta inicio de sesión")
    public void elClienteNavegaHastaInicioDeSesión () {
        theActorInTheSpotlight().attemptsTo(
                browseToSingIn()
        );

    }

    @When("selecciona registrarse, llenar su información y presiona registrarse")
    public void seleccionaRegistrarseLlenarSuInformaciónYPresionaRegistrarse () {
        register = new Register();
        register = fillRegister();
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

    }

    @Then("la página deberá mostrar el nombre registrado en la parte superior de la página")
    public void laPáginaDeberáMostrarElNombreRegistradoEnLaParteSuperiorDeLaPágina () {
        theActorInTheSpotlight().should(
                seeThat(
                        responseQuestionRegister()
                                .wasFilledFirstname(register.getFirstName())
                                .andWhitLastname(register.getLastName()),equalTo(true)
                )
        );

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
