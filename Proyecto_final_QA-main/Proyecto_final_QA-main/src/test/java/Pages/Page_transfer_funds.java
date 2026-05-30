package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_transfer_funds {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public Page_transfer_funds(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Localizadores
    private final By link_transfer_funds = By.xpath("//a[text()='Transfer Funds']");
    private final By txt_amount = By.id("amount");
    private final By dropdown_from_account = By.id("fromAccountId");
    private final By dropdown_to_account = By.id("toAccountId");
    private final By btn_transfer = By.xpath("//input[@value='Transfer']");

    // Localizador de exito
    private final By titulo_transferencia_completa = By.xpath("//div[@id='showResult']/h1[@class='title']");

    // Accion
    public void ir_a_transferencia_fondos() {
        wait.until(ExpectedConditions.elementToBeClickable(link_transfer_funds)).click();
    }

    public void realizar_transferencia(String monto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_amount)).clear();
        driver.findElement(txt_amount).sendKeys(monto);

        wait.until(d -> new Select(d.findElement(dropdown_from_account)).getOptions().size() > 0);

        Select selectOrigen = new Select(driver.findElement(dropdown_from_account));
        selectOrigen.selectByIndex(0);

        Select selectDestino = new Select(driver.findElement(dropdown_to_account));
        if (selectDestino.getOptions().size() > 1) {
            selectDestino.selectByIndex(1);
        } else {
            selectDestino.selectByIndex(0);
        }

        driver.findElement(btn_transfer).click();
    }

    // Asserts
    public String obtener_mensaje_exito_transferencia() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(titulo_transferencia_completa, "Transfer Complete!"));
        return driver.findElement(titulo_transferencia_completa).getText();
    }
}
