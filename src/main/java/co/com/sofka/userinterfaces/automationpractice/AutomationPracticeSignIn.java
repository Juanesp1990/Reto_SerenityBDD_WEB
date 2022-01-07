package co.com.sofka.userinterfaces.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class AutomationPracticeSignIn extends PageObject {

    public static final Target BUTTON_SIGN_IN = Target
            .the("Button SignIn")
            .located(By.cssSelector("a[class='login']"));

    public static final Target FILL_EMAIL = Target
            .the("Fill Email")
            .located(By.id("email"));

    public static final Target FILL_PASSWORD = Target
            .the("Fill PassWord")
            .located(By.id("passwd"));

    public static final Target BUTTON_SUBMIT_LOGIN = Target
            .the("Button submit login")
            .located(By.id("SubmitLogin"));

    /*for validations*/

    public static final Target MESSAGE_VALIDATION_SIGN_IN= Target
            .the("Message validation Sign In")
            .located(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
}
