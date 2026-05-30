package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_accounts_overview {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public Page_accounts_overview(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Localizadores
    private final By link_primer_cuenta = By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]/a");
    private final By txt_balance = By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[2]");
    private final By txt_available_amount = By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[3]");
    private final By titulo_detalles_cuenta = By.xpath("//h1[contains(text(),'Account Details')]");

    // Acciones

    public String obtener_balance() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txt_balance)).getText();
    }

    public String obtener_monto_disponible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txt_available_amount)).getText();
    }

    public void clic_primer_cuenta() {
        wait.until(ExpectedConditions.elementToBeClickable(link_primer_cuenta)).click();
    }

    public String obtener_titulo_detalles() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titulo_detalles_cuenta)).getText();
    }
}
