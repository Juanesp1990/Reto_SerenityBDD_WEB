package co.com.sofka.stepdefinition;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static com.ibm.msg.client.commonservices.propertystore.PropertyStore.user_dir;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    @Managed()
    protected WebDriver webDriver;

    private void setupUser (String name, WebDriver webDriver) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(webDriver));
    }

    protected void actorSetupTheBrowser (String name) {
        setupUser(name, webDriver);
    }


}
