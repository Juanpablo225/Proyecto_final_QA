package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_loan_request;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_loan_request {

    private WebDriver driver;
    private Page_login login;
    private Page_loan_request loanRequest;

    @BeforeMethod
    public void abrir_navegador_y_loguear() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        loanRequest = new Page_loan_request(driver);

        login.llenar_login("john", "demo");
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public void solicitud_prestamo_aprobada() {
        loanRequest.ir_a_solicitud_prestamo();
        loanRequest.llenar_solicitud_prestamo("1000", "500");

        String estatus_esperado = "Approved";
        Assert.assertEquals(loanRequest.obtener_estado_prestamo(), estatus_esperado,
                "El préstamo debería haber sido aprobado, pero el sistema arrojó otro estatus.");
    }

    @Test
    public void solicitud_prestamo_denegada() {
        loanRequest.ir_a_solicitud_prestamo();
        loanRequest.llenar_solicitud_prestamo("1000000", "0");

        String estatus_esperado = "Denied";
        Assert.assertEquals(loanRequest.obtener_estado_prestamo(), estatus_esperado,
                "El préstamo millonario debería haber sido denegado, pero el sistema lo procesó diferente.");
    }
    //////////////////////////////////////////////////////////////////////////
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
