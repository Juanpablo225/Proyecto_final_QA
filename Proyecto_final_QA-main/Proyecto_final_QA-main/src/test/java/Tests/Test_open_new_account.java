package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_open_new_account;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_open_new_account {

    private WebDriver driver;
    private Page_login login;
    private Page_open_new_account openNewAccount;

    @BeforeMethod
    public void abrir_navegador_y_loguear() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        openNewAccount = new Page_open_new_account(driver);

        login.llenar_login("john", "demo");
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public void abrir_cuenta_ahorros_savings() {
        openNewAccount.ir_a_abrir_nueva_cuenta();
        openNewAccount.seleccionar_tipo_cuenta("SAVINGS");
        openNewAccount.clic_abrir_cuenta();

        String texto_esperado = "Account Opened!";
        Assert.assertEquals(openNewAccount.obtener_mensaje_exito(), texto_esperado, "No se mostró el mensaje de éxito al abrir la cuenta SAVINGS.");
    }

    @Test
    public void abrir_cuenta_corriente_checking() {
        openNewAccount.ir_a_abrir_nueva_cuenta();
        openNewAccount.seleccionar_tipo_cuenta("CHECKING");
        openNewAccount.clic_abrir_cuenta();

        String texto_esperado = "Account Opened!";
        Assert.assertEquals(openNewAccount.obtener_mensaje_exito(), texto_esperado, "No se mostró el mensaje de éxito al abrir la cuenta CHECKING.");

        String numeroCuentaNueva = openNewAccount.obtener_nuevo_numero_cuenta();
        Assert.assertFalse(numeroCuentaNueva.isEmpty(), "El número de cuenta generado está vacío.");
    }
    //////////////////////////////////////////////////////////////////////////
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
