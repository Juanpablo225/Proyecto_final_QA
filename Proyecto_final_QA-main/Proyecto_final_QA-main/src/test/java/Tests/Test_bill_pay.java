package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_bill_pay;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_bill_pay {

    private WebDriver driver;
    private Page_login login;
    private Page_bill_pay billPay;

    @BeforeMethod
    public void abrir_navegador_y_loguear() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        billPay = new Page_bill_pay(driver);

        login.llenar_login("john", "demo");
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public void pago_de_servicio_exitoso() {
        billPay.ir_a_bill_pay();
        billPay.llenar_formulario_y_enviar(
                "Compañía de Luz",
                "Av. Siempre Viva 123",
                "Springfield",
                "Estado de México",
                "12345",
                "5551234567",
                "987654321",
                "50.00"
        );
        String mensaje_esperado = "Bill Payment Complete";
        Assert.assertEquals(billPay.obtener_mensaje_exito(), mensaje_esperado,
                "El pago de servicio no se completó correctamente o el mensaje no coincidió.");
    }
    //////////////////////////////////////////////////////////////////////////
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
