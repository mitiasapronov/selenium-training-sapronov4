import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    @Test
    public void firstTest ()
    {
////        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();

        FirefoxDriverManager.getInstance().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get ("http://google.com");

        driver.quit();
    }
}




