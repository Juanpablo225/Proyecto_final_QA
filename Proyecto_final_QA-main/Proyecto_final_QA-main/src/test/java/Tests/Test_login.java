package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Page_login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test_login {

    private WebDriver driver;
    private Page_login login;

    //abre navegador
    @BeforeMethod
    public void abrir_navegador() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        login = new Page_login(driver);
    }
    //////////////////////////////////////////////////////////////////////////
    @Test
    public  void login_valido() {
        login.llenar_login("juan225","juan225");
        String url_esperada = "https://parabank.parasoft.com/parabank/overview.htm";
        Assert.assertEquals(driver.getCurrentUrl(), url_esperada);
    }

    @Test
    public  void login_usuario_invalido() {
        login.llenar_login("000","000");
        String texto_esperada = "The username and password could not be verified.";
        Assert.assertEquals(login.mensaje_usuario_erroneo(), texto_esperada);

    }

    @Test
    public  void login_contracena_invalida() {
        login.llenar_login("juan117","");
        String texto_esperada = "Please enter a username and password.";
        Assert.assertEquals(login.mensaje_usuario_erroneo2(), texto_esperada);

    }

    @Test
    public  void login_no_valido() {
        login.llenar_login("juan","juan");
        String texto_esperada = "The username and password could not be verified.";
        Assert.assertEquals(login.mensaje_usuario_erroneo2(), texto_esperada);

    }

    @Test
    public  void login_sin_datos() {
        login.llenar_login("","");
        String texto_esperada = "Please enter a username and password.";
        Assert.assertEquals(login.mensaje_usuario_erroneo2(), texto_esperada);
    }

    //////////////////////////////////////////////////////////////////////////
    //cierra navegador
    @AfterMethod
    public void cerrar_navegador() {
        if (driver != null) {
         driver.quit();
        }
    }
}
