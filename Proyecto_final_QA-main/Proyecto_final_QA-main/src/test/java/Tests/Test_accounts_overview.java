package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_accounts_overview;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_accounts_overview {

    private WebDriver driver;
    private Page_login login;
    private Page_accounts_overview accountsOverview;

    @BeforeMethod
    public void abrir_navegador_y_loguear() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        accountsOverview = new Page_accounts_overview(driver);

        login.llenar_login("john", "demo");
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public void verificacion_balance_inicial() {
        String balance = accountsOverview.obtener_balance();
        Assert.assertFalse(balance.isEmpty(), "Fallo en la UI: El campo del balance inicial se encuentra vacío.");
        Assert.assertTrue(balance.contains("$"), "El balance obtenido (" + balance + ") no contiene el formato de moneda correcto ($).");
    }

    @Test
    public void navegacion_detalle_cuenta() {
        accountsOverview.clic_primer_cuenta();

        String texto_esperado = "Account Details";
        Assert.assertEquals(accountsOverview.obtener_titulo_detalles(), texto_esperado, "Fallo al navegar a la página de detalles de la cuenta.");
    }
    //////////////////////////////////////////////////////////////////////////
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
