package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_bill_pay {
    WebDriver driver;
    WebDriverWait wait;

    //  Localizadores
    By link_bill_pay = By.linkText("Bill Pay");
    By input_payee_name = By.name("payee.name");
    By input_address = By.name("payee.address.street");
    By input_city = By.name("payee.address.city");
    By input_state = By.name("payee.address.state");
    By input_zip = By.name("payee.address.zipCode");
    By input_phone = By.name("payee.phoneNumber");
    By input_account = By.name("payee.accountNumber");
    By input_verify_account = By.name("verifyAccount");
    By input_amount = By.name("amount");
    By btn_send_payment = By.xpath("//input[@value='Send Payment']");
    By titulo_pago_completado = By.xpath("//h1[contains(text(), 'Bill Payment Complete')]");

    // Constructor
    public Page_bill_pay(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  Acciones
    public void ir_a_bill_pay() {
        wait.until(ExpectedConditions.elementToBeClickable(link_bill_pay)).click();
    }

    public void llenar_formulario_y_enviar(String nombre, String direccion, String ciudad, String estado, String zip, String telefono, String cuenta, String monto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(input_payee_name)).sendKeys(nombre);
        driver.findElement(input_address).sendKeys(direccion);
        driver.findElement(input_city).sendKeys(ciudad);
        driver.findElement(input_state).sendKeys(estado);
        driver.findElement(input_zip).sendKeys(zip);
        driver.findElement(input_phone).sendKeys(telefono);
        driver.findElement(input_account).sendKeys(cuenta);
        driver.findElement(input_verify_account).sendKeys(cuenta);
        driver.findElement(input_amount).sendKeys(monto);
        driver.findElement(btn_send_payment).click();
    }

    public String obtener_mensaje_exito() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titulo_pago_completado)).getText();
    }
}
