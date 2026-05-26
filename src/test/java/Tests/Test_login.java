package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Test_login {

    static WebDriver driver;
    static Page_login login;

    // abre navegador
    @BeforeMethod
    public void abrir_navegador() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=06119915241E176AC7EBB032A6A1B809");

        login = new Page_login(driver);
    }






/// ////////////////////////////////////////////////////////////////////////////////
@Test
public  void login_valido() {
        login.llenar_login("juan117","juan117");

       String url_esperada = "https://parabank.parasoft.com/parabank/overview.htm";
    Assert.assertEquals(driver.getCurrentUrl(), url_esperada);
}


    @Test
    public  void login_usuario_invalido() {
        login.llenar_login("juan","juan117");
        String texto_esperada = "An internal error has occurred and has been logged.";
        Assert.assertEquals(login.mensaje_usuario_erroneo(), texto_esperada);

    }
    @Test
    public  void login_contracena_invalida() {
        login.llenar_login("juan117","j");

    }

    @Test
    public  void login_no_valido() {
        login.llenar_login("juan117","juan117");
    }

    @Test
    public  void login_sin_datos() {
        login.llenar_login("juan117","juan117");
    }

/// ////////////////////////////////////////////////////////////////////////////



  //  cierra navegador
    @AfterMethod
    public static void cerrar_navegador() {

        driver.quit();

    }

}
