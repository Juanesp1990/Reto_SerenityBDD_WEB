package co.com.sofka.userinterfaces.automationpractice;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AutomationPracticeRegister extends PageObject {

    public static final Target FILL_EMAIL_CREATE = Target
            .the("Fill email create")
            .located(By.id("email_create"));

    public static final Target BUTTON_CREATE_ACCONT= Target
            .the("Button create accont")
            .located(By.id("SubmitCreate"));

    public static final Target FIRST_NAME = Target
            .the("Fill first name")
            .located(By.id("customer_firstname"));

    public static final Target LAST_NAME = Target
            .the("Fill last name")
            .located(By.id("customer_lastname"));

    public static final Target FILL_PASSWORD = Target
            .the("Fill password")
            .located(By.id("passwd"));

    public static final Target FILL_ADDRESS = Target
            .the("Fill addres")
            .located(By.id("address1"));

    public static final Target FILL_CITY = Target
            .the("Fill city")
            .located(By.id("city"));

    public static final Target FILL_STATE = Target
            .the("Fill state")
            .located(By.id("id_state"));

    public static final Target STATE_FLORIDA =Target
            .the("State florida")
            .located(By.xpath("//option[contains(text(),'Florida')]"));

    public static final Target CODE_POSTAL = Target
            .the("Code postal")
            .located(By.id("postcode"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile phone")
            .located(By.id("phone_mobile"));

    public static final Target BUTTON_REGISTER = Target
            .the("Button register")
            .located(By.id("submitAccount"));

    /*for validations*/
public static final Target CUSTOMER_ACCOUNT =Target
            .the("Customer account sucesfull")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));

}
