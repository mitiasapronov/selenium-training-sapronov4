import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class Homework2 {

    static WebDriver driver;
    public int sideMenuSize;
   // WebDriverWait webDriverWait;
    //webDriverWait webDriverWait;


    public void login() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    public void logoClick() {

        driver.findElement(By.className("logotype")).click();

    }
    public List<WebElement> getFullSideMenu() {
        return driver.findElement(By.id("box-apps-menu")).findElements(By.tagName("li"));
    }

    public boolean isElPresent(String locator) {

        return driver.findElements(By.tagName(locator)).size() > 0;
    }
    public WebElement getSideMenuElementByNumber(int count) {

        return getFullSideMenu().get(count);
    }
    public boolean checkIfDropdownExist (int count) {

        try {
            getDropDownMenu(count);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
     public List<WebElement> getDropDownMenu(int count) {
        return getSideMenuElementByNumber(count).findElement(By.className("docs")).findElements(By.tagName("li"));
     }

     public Integer dropDownMenuSize(int count) {

        return getDropDownMenu(count).size();
     }

    @BeforeClass
    public static void startDriver(){
        ChromeDriverManager.getInstance().setup();
        driver =new ChromeDriver();
    }

    @Test
    public void el() {
        login();
        sideMenuSize = getFullSideMenu().size();
        for (int i = 0; i < sideMenuSize; i++) {
            logoClick();
            WebElement sideMenuElement = getSideMenuElementByNumber(i);
            sideMenuElement.click();
            //this.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("docs"))));
            if (checkIfDropdownExist (i)) {
                Integer dropDownElementsSize = dropDownMenuSize(i);
                for (int k = 0; k < dropDownElementsSize; k++) {
                    getDropDownMenu(i).get(k).click();
                    Assert.assertTrue(isElPresent("h1"));
                }
            } else {
                Assert.assertTrue(isElPresent("h1"));
            }
        }
    }
    @AfterClass
          public static void stop() {
               driver.quit();
            }
}
