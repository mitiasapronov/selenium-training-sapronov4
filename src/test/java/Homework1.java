import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework1 {

    public static final String url = "http://google.com";
    public static WebDriver driver;
    @Test
    public void chromeDriver(){

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.quit();

    }
    @Test
    public void ffDriver(){

        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        driver.quit();

    }

}
