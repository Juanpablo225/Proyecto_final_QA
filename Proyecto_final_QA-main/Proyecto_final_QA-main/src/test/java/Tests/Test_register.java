package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_register;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_register {

    private WebDriver driver;
    private Page_login login;
    private Page_register register;

    @BeforeMethod
    public void abrir_navegador() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        login = new Page_login(driver);
        register = new Page_register(driver);
    }

    @Test
    public void crear_usuario_exitoso() {
        String usuarioUnico = "juan_" + System.currentTimeMillis();

        register.ir_a_registro();
        register.llenar_datos("juan", "pablo", "manzana", "tj", "tj", "123", "6647177273", "123", usuarioUnico, "juan225", "juan225");

        String texto_esperado = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(register.mensaje_usuario_erroneo5(), texto_esperado);
    }

    @Test
    public void crear_usuario_campos_vacios() {
        register.ir_a_registro();
        register.llenar_datos("", "", "", "", "", "", "", "", "", "", "");

        String texto_esperado = "First name is required.";
        Assert.assertEquals(register.mensaje_usuario_erroneo3(), texto_esperado);
    }

    @Test
    public void crear_usuario_contrasenas_no_coincidentes() {
        register.ir_a_registro();
        register.llenar_datos("juan", "pablo", "manzana", "tj", "tj", "123", "6647177273", "123", "juan117", "juan", "juan225");

        String texto_esperado = "Passwords did not match.";
        Assert.assertEquals(register.mensaje_usuario_erroneo4(), texto_esperado);
    }

    @Test
    public void crear_usuario_existente() {
        register.ir_a_registro();
        register.llenar_datos("juan", "pablo", "manzana", "tj", "tj", "123", "6647177273", "123", "john", "juan117", "juan117");

        String texto_esperado = "This username already exists.";
        Assert.assertEquals(register.mensaje_usuario_erroneo6(), texto_esperado);
    }

    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
