package co.com.sofka.userinterfaces.automationpractice;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class AutomationPracticeContacUs extends PageObject {
    public static final Target CONTACT = Target
            .the("Contac us")
            .located(By.xpath("//a[@title='Contact Us']"));

    //For fill elements.

    public static final Target SELEC_TYPE = Target
            .the("Selec type menssage")
            .located(By.id("id_contact"));

    public static final Target CUSTOMER_SERVICE = Target
            .the("Customer Service")
            .located(By.xpath("//option[@value='2']"));

    public static final Target EMAIL = Target
            .the("Email")
            .located(By.id("email"));

    public static final Target MESSAGE_CONTAC_US = Target
            .the("Message contac us")
            .located(By.id("message"));

    public static final Target BUTTON_SEND = Target
            .the("Button send")
            .located(By.id("submitMessage"));

    //For validations
    public static final Target MESSAGE_ERROR = Target
            .the("Message error")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));

    public static final Target MESSA_GOD = Target
            .the("Message Succes")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

}
