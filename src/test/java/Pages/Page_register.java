package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Page_register {

    WebDriver driver;

    public Page_register(WebDriver driver) {
        this.driver = driver;
    }


    // crear usuario
    By btn_register = By.xpath("//a[normalize-space()='Register']");
    By txt_firstname = By.xpath("//input[@id='customer.firstName']");
    By txt_lasname = By.xpath("//input[@id='customer.lastName']");
    By txt_address = By.xpath("//input[@id='customer.address.street']");
    By txt_city = By.xpath("//input[@id='customer.address.city']");
    By txt_state = By.xpath("//input[@id='customer.address.state']");
    By txt_zip = By.xpath("//input[@id='customer.address.zipCode']");
    By txt_phone = By.xpath("//input[@id='customer.phoneNumber']");
    By txt_ssn = By.xpath("//input[@id='customer.ssn']");
    By txt_user =By.xpath("//input[@id='customer.username']");
    By txt_password =By.xpath("//input[@id='customer.password']");
    By txt_confirm_password = By.xpath("//input[@id='repeatedPassword']");
    By Btn_register2 = By.xpath("//input[@value='Register']");



    public  void llenar_datos(String txt_firstnam, String txt_lasnam, String txt_addres,String txt_cit ,String txt_stat, String txt_zi, String txt_phon, String txt_ss,String txt_use,String txt_passwor,String txt_confirm_passwor) {
        driver.findElement(btn_register).click();
        driver.findElement(txt_firstname).sendKeys(txt_firstnam);
        driver.findElement(txt_lasname).sendKeys(txt_lasnam);
        driver.findElement(txt_address).sendKeys(txt_addres);
        driver.findElement(txt_city).sendKeys(txt_cit);
        driver.findElement(txt_state).sendKeys(txt_stat);
        driver.findElement(txt_zip).sendKeys(txt_zi);
        driver.findElement(txt_phone).sendKeys(txt_phon);
        driver.findElement(txt_ssn).sendKeys(txt_ss);
        driver.findElement(txt_user).sendKeys(txt_use);
        driver.findElement(txt_password).sendKeys(txt_passwor);
        driver.findElement(txt_confirm_password).sendKeys(txt_confirm_passwor);
        driver.findElement(Btn_register2).click();


    }



}
