package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_login {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Page_login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Localizadores
    private final By username_login = By.xpath("//input[@name='username']");
    private final By password_login = By.xpath("//input[@name='password']");
    private final By btn_login = By.xpath("//input[@value='Log In']");
    private final By mensaje_usuario_no_valido = By.xpath("//h1[@class='title']");
    private final By mensaje_no_valido = By.xpath("//p[@class='error']");

    // Acciones

    public void llenar_login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_login)).clear();
        driver.findElement(username_login).sendKeys(username);

        driver.findElement(password_login).clear();
        driver.findElement(password_login).sendKeys(password);
        driver.findElement(btn_login).click();
    }

    public String mensaje_usuario_erroneo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_usuario_no_valido)).getText();
    }

    public String mensaje_usuario_erroneo2() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje_no_valido)).getText();
    }
}

