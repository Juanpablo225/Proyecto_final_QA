package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import Pages.Page_register;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_register {
    static WebDriver driver;
    static Page_login login;
    static Page_register register;

    // abre navegador
    @BeforeMethod
    public void abrir_navegador() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=06119915241E176AC7EBB032A6A1B809");

        login = new Page_login(driver);
        register = new Page_register(driver);
    }


    @Test
    public void crear_usuario_exitoso() {
        register.llenar_datos("juan","pablo","manzana","tj","tj","123","6647177273","123","juan400","juan225","juan225");
        String texto_esperada ="Your account was created successfully. You are now logged in.";
        Assert.assertEquals(register.mensaje_usuario_erroneo5(), texto_esperada);
    }


    @Test
    public void crear_usuario_campos_vacios() {
        register.llenar_datos("","","","","","","","","","","");
        String texto_esperada = "First name is required.";
        Assert.assertEquals(register.mensaje_usuario_erroneo3(), texto_esperada);

    }


    @Test
    public void crear_usuario_contrasenas_no_coincidentes() {
        register.llenar_datos("juan","pablo","manzana","tj","tj","123","6647177273","123","juan117","juan","juan225");
        String texto_esperada = "Passwords did not match.";
        Assert.assertEquals(register.mensaje_usuario_erroneo4(), texto_esperada);


    }

    @Test
    public void crear_usuario_existente() {


        register.llenar_datos("juan","pablo","manzana","tj","tj","123","6647177273","123","juan400","juan117","juan117");
        String texto_esperada ="This username already exists.";
        Assert.assertEquals(register.mensaje_usuario_erroneo6(), texto_esperada);
    }




    //cierra navegador
     @AfterMethod
      public static void cerrar_navegador() {

        driver.quit();

      }
}
