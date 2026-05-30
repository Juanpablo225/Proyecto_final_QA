package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_open_new_account {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public Page_open_new_account(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Localizadores
    private final By link_open_new_account = By.xpath("//a[text()='Open New Account']");
    private final By dropdown_account_type = By.id("type");
    private final By dropdown_from_account = By.id("fromAccountId");
    private final By btn_open_new_account = By.xpath("//input[@value='Open New Account']");

    // Localizadores de validacion
    private final By titulo_exito = By.xpath("//h1[@class='title']");
    private final By link_nuevo_numero_cuenta = By.id("newAccountId");

    // Acciones

    public void ir_a_abrir_nueva_cuenta() {
        wait.until(ExpectedConditions.elementToBeClickable(link_open_new_account)).click();
    }

    public void seleccionar_tipo_cuenta(String tipoCuenta) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_account_type));

        Select selectTipo = new Select(driver.findElement(dropdown_account_type));
        selectTipo.selectByVisibleText(tipoCuenta);
    }

    public void clic_abrir_cuenta() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_from_account));
        wait.until(ExpectedConditions.elementToBeClickable(btn_open_new_account)).click();
    }

    // Extraccion para Asserts

    public String obtener_mensaje_exito() {
        By titulo_exito_real = By.xpath("//div[@id='openAccountResult']/h1[@class='title']");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(titulo_exito_real, "Account Opened!"));

        return driver.findElement(titulo_exito_real).getText();
    }

    public String obtener_nuevo_numero_cuenta() {
        By link_nuevo_numero_cuenta = By.id("newAccountId");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(link_nuevo_numero_cuenta)).getText();
    }
}
