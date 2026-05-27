package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Page_login {

    WebDriver driver;

    public Page_login(WebDriver driver) {
        this.driver = driver;
    }



    //assertions
// acceder a login

By username_login = By.xpath("//input[@name='username']");
    By password_login = By.xpath("//input[@name='password']");
By btn_login = By.xpath("//input[@value='Log In']");

    By mensaje_usuario_no_valido = By.xpath("//h1[@class='title']");
 By mensaje_no_valido = By.xpath("//p[@class='error']");
public void llenar_login(String username,String password){
driver.findElement(username_login).sendKeys(username);
driver.findElement(password_login).sendKeys(password);
driver.findElement(btn_login).click();
}


    public String mensaje_usuario_erroneo(){

        return driver.findElement(mensaje_usuario_no_valido).getText();
    }

    public String mensaje_usuario_erroneo2(){

        return driver.findElement(mensaje_no_valido).getText();
    }

}

