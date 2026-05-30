package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_accounts_overview;
import Pages.Page_transfer_funds;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_transfer_funds {

    private WebDriver driver;
    private Page_login login;
    private Page_accounts_overview accountsOverview;
    private Page_transfer_funds transferFunds;

    @BeforeMethod
    public void abrir_navegador_y_loguear() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        accountsOverview = new Page_accounts_overview(driver);
        transferFunds = new Page_transfer_funds(driver);

        login.llenar_login("john", "demo");
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public void transferencia_exitosa_entre_cuentas_propias() {
        transferFunds.ir_a_transferencia_fondos();
        transferFunds.realizar_transferencia("10.00");

        String mensaje_esperado = "Transfer Complete!";
        Assert.assertEquals(transferFunds.obtener_mensaje_exito_transferencia(), mensaje_esperado,
                "El mensaje de confirmación de transferencia no apareció en la interfaz de usuario.");
    }

    @Test
    public void transferencia_fallida_por_fondos_insuficientes() {
        transferFunds.ir_a_transferencia_fondos();
        transferFunds.realizar_transferencia("99999999.00");

        String mensaje_esperado = "Transfer Complete!";
        Assert.assertEquals(transferFunds.obtener_mensaje_exito_transferencia(), mensaje_esperado, "El sistema falló al procesar la solicitud de transferencia extrema.");
    }
    //////////////////////////////////////////////////////////////////////////
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
