package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_register {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public Page_register(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Localizadores de navegación y formulario (Encapsulados)
    private final By btn_register = By.xpath("//a[normalize-space()='Register']");
    private final By txt_firstname = By.xpath("//input[@id='customer.firstName']");
    private final By txt_lasname = By.xpath("//input[@id='customer.lastName']");
    private final By txt_address = By.xpath("//input[@id='customer.address.street']");
    private final By txt_city = By.xpath("//input[@id='customer.address.city']");
    private final By txt_state = By.xpath("//input[@id='customer.address.state']");
    private final By txt_zip = By.xpath("//input[@id='customer.address.zipCode']");
    private final By txt_phone = By.xpath("//input[@id='customer.phoneNumber']");
    private final By txt_ssn = By.xpath("//input[@id='customer.ssn']");
    private final By txt_user = By.xpath("//input[@id='customer.username']");
    private final By txt_password = By.xpath("//input[@id='customer.password']");
    private final By txt_confirm_password = By.xpath("//input[@id='repeatedPassword']");
    private final By Btn_register2 = By.xpath("//input[@value='Register']");

    // Localizadores
    private final By mensaje_usuario_no_valido = By.xpath("//span[@id='customer.firstName.errors']");
    private final By mensaje_usuario_no_valido2 = By.xpath("//span[@id='repeatedPassword.errors']");
    private final By mensaje_usuario_no_valido3 = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    private final By mensaje_usuario_no_valido4 = By.xpath("//span[@id='customer.username.errors']");

    // Metodo independiente para navegar a la seccion de registro
    public void ir_a_registro() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_register)).click();
    }

    // Metodo para rellenar todo el form
    public void llenar_datos(String firstname, String lastname, String address, String city,
                             String state, String zip, String phone, String ssn,
                             String user, String password, String confirmPassword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_firstname)).clear();
        driver.findElement(txt_firstname).sendKeys(firstname);

        driver.findElement(txt_lasname).clear();
        driver.findElement(txt_lasname).sendKeys(lastname);

        driver.findElement(txt_address).clear();
        driver.findElement(txt_address).sendKeys(address);

        driver.findElement(txt_city).clear();
        driver.findElement(txt_city).sendKeys(city);

        driver.findElement(txt_state).clear();
        driver.findElement(txt_state).sendKeys(state);

        driver.findElement(txt_zip).clear();
        driver.findElement(txt_zip).sendKeys(zip);

        driver.findElement(txt_phone).clear();
        driver.findElement(txt_phone).sendKeys(phone);

        driver.findElement(txt_ssn).clear();
        driver.findElement(txt_ssn).sendKeys(ssn);

        driver.findElement(txt_user).clear();
        driver.findElement(txt_user).sendKeys(user);

        driver.findElement(txt_password).clear();
        driver.findElement(txt_password).sendKeys(password);

        driver.findElement(txt_confirm_password).clear();
        driver.findElement(txt_confirm_password).sendKeys(confirmPassword);

        driver.findElement(Btn_register2).click();
    }

    public String mensaje_usuario_erroneo3() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_usuario_no_valido)).getText();
    }

    public String mensaje_usuario_erroneo4() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_usuario_no_valido2)).getText();
    }

    public String mensaje_usuario_erroneo5() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_usuario_no_valido3)).getText();
    }

    public String mensaje_usuario_erroneo6() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_usuario_no_valido4)).getText();
    }
}
