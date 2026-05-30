package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_loan_request {
    WebDriver driver;
    WebDriverWait wait;

    // Localizadores
    By link_request_loan = By.linkText("Request Loan");
    By input_loan_amount = By.id("amount");
    By input_down_payment = By.id("downPayment");
    By btn_apply_now = By.xpath("//input[@value='Apply Now']");
    By text_loan_status = By.id("loanStatus");

    // Constructor
    public Page_loan_request(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Acciones
    public void ir_a_solicitud_prestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(link_request_loan)).click();
    }

    public void llenar_solicitud_prestamo(String monto, String pago_inicial) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(input_loan_amount)).clear();
        driver.findElement(input_loan_amount).sendKeys(monto);
        driver.findElement(input_down_payment).clear();
        driver.findElement(input_down_payment).sendKeys(pago_inicial);
        driver.findElement(btn_apply_now).click();
    }

    public String obtener_estado_prestamo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(text_loan_status)).getText();
    }
}
