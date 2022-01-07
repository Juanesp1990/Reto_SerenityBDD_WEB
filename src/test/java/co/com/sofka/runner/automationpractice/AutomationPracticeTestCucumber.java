package co.com.sofka.runner.automationpractice;

import io.cucumber.core.backend.Snippet;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/automationpractice/signIn.feature",
                    "src/test/resources/features/automationpractice/contacUs.feature"},
        glue = {"co.com.sofka.stepdefinition.automationpractice"}
)
public class AutomationPracticeTestCucumber {
}
